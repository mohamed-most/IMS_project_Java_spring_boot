package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.request.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequestDto dto);

//    UserResponseDto toDto(User user);
}
