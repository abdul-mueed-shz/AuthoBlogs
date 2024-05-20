package com.bizremark.blogs.user.mapper;

import com.bizremark.blogs.user.info.LoggedInUserInfo;
import com.bizremark.blogs.user.model.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LoggedInUserMapper {
    LoggedInUserInfo userToLoggedInUserInfo(User user);

    User loggedInUserInfoToUser(LoggedInUserInfo userInfo);
}
