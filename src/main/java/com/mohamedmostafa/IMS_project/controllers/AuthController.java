package com.mohamedmostafa.IMS_project.controllers;


import com.mohamedmostafa.IMS_project.dtos.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.Response;
import com.mohamedmostafa.IMS_project.dtos.SignUpRequestDto;
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
    public ResponseEntity<Response> loginApi(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(authService.login(loginRequestDto), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> signUpApi(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        return new ResponseEntity<>(authService.signUp(signUpRequestDto), HttpStatus.OK);
    }
}
