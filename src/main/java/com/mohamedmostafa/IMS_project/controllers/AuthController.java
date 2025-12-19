package com.mohamedmostafa.IMS_project.controllers;


import com.mohamedmostafa.IMS_project.dtos.Response;
import com.mohamedmostafa.IMS_project.dtos.request.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.request.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.dtos.response.LoginResponseDto;
import com.mohamedmostafa.IMS_project.dtos.response.SignUpResponseDto;
import com.mohamedmostafa.IMS_project.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponseDto>> loginApi(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Response.success("User Logged In successfully ", authService.login(loginRequestDto)));
    }

    @PostMapping("/signup")
    public ResponseEntity<Response<SignUpResponseDto>> signUpApi(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Response.success("User SignUp successfully ", authService.signUp(signUpRequestDto)));
    }
}
