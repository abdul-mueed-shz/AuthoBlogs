package com.bizremark.blogs.user.model.dao;

import com.bizremark.blogs.user.info.RegistrationInfo;
import com.bizremark.blogs.user.info.UserInfo;
import com.bizremark.blogs.user.mapper.UserInfoMapper;
import com.bizremark.blogs.user.model.entity.User;
import com.bizremark.blogs.user.model.entity.UserRole;
import com.bizremark.blogs.user.model.repository.UserJpaRepository;
import com.bizremark.blogs.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoMapper userInfoMapper;

    public UserInfo registerUser(RegistrationInfo registrationInfo) {
        var user = User.builder()
                .username(registrationInfo.getUsername())
                .password(passwordEncoder.encode(registrationInfo.getPassword()))
                .email(registrationInfo.getEmail())
                .firstName(registrationInfo.getFirstName())
                .lastName(registrationInfo.getLastName())
                .role(UserRole.USER)
                .build();
        userJpaRepository.save(user);
        return userInfoMapper.userToUserInfo(user);
    }

    public UserInfo findByUsername(String username) {
        var user = userJpaRepository.findByUsername(username);
        return user.map(userInfoMapper::userToUserInfo).orElse(null);
    }
}
