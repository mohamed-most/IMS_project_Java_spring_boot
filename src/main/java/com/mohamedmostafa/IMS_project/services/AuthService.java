package com.mohamedmostafa.IMS_project.services;

import com.mohamedmostafa.IMS_project.dtos.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.Response;
import com.mohamedmostafa.IMS_project.dtos.SignUpRequestDto;

public interface AuthService {

    Response login(LoginRequestDto loginRequestDto);

    Response signUp(SignUpRequestDto signUpRequestDto);
}
