package com.bizremark.blogs.user.controller;

import com.bizremark.blogs.user.dto.AuthenticationDto;
import com.bizremark.blogs.user.dto.RegistrationDto;
import com.bizremark.blogs.user.info.AuthenticationResponse;
import com.bizremark.blogs.user.mapper.AuthenticationDtoMapper;
import com.bizremark.blogs.user.mapper.RegistrationDtoMapper;
import com.bizremark.blogs.user.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthenticationDtoMapper authenticationDtoMapper;
    private final RegistrationDtoMapper registrationDtoMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegistrationDto registerationDto
    ) {
        return ResponseEntity
                .ok(authService.register(registrationDtoMapper.registrationDtoToRegistrationInfo(registerationDto)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationDto authenticationDto
    ) {
        return ResponseEntity
                .ok(authService.authenticate(authenticationDtoMapper
                        .authenticationDtoToAuthenticationInfo(authenticationDto)));
    }
}
