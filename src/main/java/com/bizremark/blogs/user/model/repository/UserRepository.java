package com.bizremark.blogs.user.model.repository;


import com.bizremark.blogs.user.info.RegistrationInfo;
import com.bizremark.blogs.user.info.UserInfo;

public interface UserRepository {
    UserInfo registerUser(RegistrationInfo registrationInfo);

    UserInfo findByUsername(String username);
}
