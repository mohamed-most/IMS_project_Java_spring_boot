package com.mohamedmostafa.IMS_project.services;

import com.mohamedmostafa.IMS_project.dtos.request.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.request.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.dtos.response.LoginResponseDto;
import com.mohamedmostafa.IMS_project.dtos.response.SignUpResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);
}
