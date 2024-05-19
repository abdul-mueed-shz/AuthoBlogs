package com.bizremark.blogs.user.mapper;

import com.bizremark.blogs.user.info.UserInfo;
import com.bizremark.blogs.user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfo userToUserInfo(User user);

    User userInfoToUser(UserInfo userInfo);

}
