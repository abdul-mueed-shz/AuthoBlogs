package com.bizremark.blogs.common.config;

import com.bizremark.blogs.user.info.LoggedInUserInfo;
import com.bizremark.blogs.user.mapper.LoggedInUserMapper;
import com.bizremark.blogs.user.model.entity.User;
import com.bizremark.blogs.user.model.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;
    private final LoggedInUserMapper loggedInUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // !BUG: Ensure only users with unique usernames/emails exist in the system
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public LoggedInUserInfo getLoggedInUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return loggedInUserMapper.userToLoggedInUserInfo(user);
    }
}
