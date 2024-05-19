package com.bizremark.blogs.user.service;

import com.bizremark.blogs.common.config.JwtService;
import com.bizremark.blogs.user.info.AuthenticationInfo;
import com.bizremark.blogs.user.info.AuthenticationResponse;
import com.bizremark.blogs.user.info.RegistrationInfo;
import com.bizremark.blogs.user.info.UserInfo;
import com.bizremark.blogs.user.model.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDao userDao;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegistrationInfo registrationInfo) {
        var userInfo = userDao.registerUser(registrationInfo);
        return generateAuthenticationResponse(userInfo);
    }

    public AuthenticationResponse authenticate(AuthenticationInfo authenticationInfo) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationInfo.getUsername(),
                        authenticationInfo.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var userInfo = userDao.findByUsername(authenticationInfo.getUsername());
        return generateAuthenticationResponse(userInfo);
    }

    private AuthenticationResponse generateAuthenticationResponse(UserInfo userInfo) {
        var jwtToken = jwtService.generateToken(userInfo);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
