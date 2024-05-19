package com.bizremark.blogs.user.mapper;

import com.bizremark.blogs.user.dto.RegistrationDto;
import com.bizremark.blogs.user.info.RegistrationInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationDtoMapper {
    RegistrationInfo registrationDtoToRegistrationInfo(RegistrationDto registrationDto);

    RegistrationDto registrationInfoToRegistrationDto(RegistrationInfo registrationInfo);
}
