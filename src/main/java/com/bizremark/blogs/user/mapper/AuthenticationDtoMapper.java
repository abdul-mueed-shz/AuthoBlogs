package com.bizremark.blogs.user.mapper;

import com.bizremark.blogs.user.dto.AuthenticationDto;
import com.bizremark.blogs.user.info.AuthenticationInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationDtoMapper {
    AuthenticationInfo authenticationDtoToAuthenticationInfo(AuthenticationDto authenticationDto);

    AuthenticationDto authenticationInfoToAuthenticationDto(AuthenticationInfo authenticationInfo);
}
