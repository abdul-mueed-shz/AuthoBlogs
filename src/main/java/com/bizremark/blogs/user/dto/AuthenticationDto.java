package com.bizremark.blogs.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticationDto {
    @NotNull
    @Size(min = 5, max = 320)
    private String username;

    @NotNull
    private String password;
}
