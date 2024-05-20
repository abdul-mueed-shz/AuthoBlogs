package com.bizremark.blogs.user.info;

import com.bizremark.blogs.user.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoggedInUserInfo {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserRole role;
}
