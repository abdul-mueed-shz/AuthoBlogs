package com.bizremark.blogs.user.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistrationInfo {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
