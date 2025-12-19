package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.request.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.dtos.response.SignUpResponseDto;
import com.mohamedmostafa.IMS_project.models.User;


public class AuthMapper {

    // Map SignUpRequestDto to User entity
    public static User toUser(SignUpRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .role(dto.getRole())
                .build();
    }

    // Map User entity to SignUpResponseDto
    static SignUpResponseDto toSignUpResponse(User user) {

        return null;
    }
}
