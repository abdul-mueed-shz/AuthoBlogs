package com.bizremark.blogs.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationDto {
    @NotNull
    @Size(min = 7, max = 320)
    @Email
    private String email;

    private String firstName;
    private String lastName;

    @NotNull
    @Size(min = 5, max = 320)
    private String username;

    @NotNull
    private String password;
}
