package com.mohamedmostafa.IMS_project.services.impl;


import com.mohamedmostafa.IMS_project.dtos.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.Response;
import com.mohamedmostafa.IMS_project.dtos.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.exceptions.InvalidCredentialsException;
import com.mohamedmostafa.IMS_project.exceptions.NotFoundException;
import com.mohamedmostafa.IMS_project.models.User;
import com.mohamedmostafa.IMS_project.repos.UserRepository;
import com.mohamedmostafa.IMS_project.security.JwtUtil;
import com.mohamedmostafa.IMS_project.services.AuthService;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
@Data
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    /**
     *
     * @param loginRequestDto
     * @return Response
     */
    @Override
    public Response login(LoginRequestDto loginRequestDto) {
        // load user from database
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new NotFoundException("User's Email Not Found "));

        //check password with that stored in db
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Password don't match ");
        }

        //generate token
        String token = jwtUtil.generateToken(loginRequestDto.getEmail());

        //build response
        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("User Logged In successfully")
                .token(token)
                .role(user.getRole())
                .build();
    }


    /**
     *
     * @param signUpRequestDto
     * @return Response
     */
    @Override
    public Response signUp(SignUpRequestDto signUpRequestDto) {
        //build User Object from request
        User user = User.builder()
                .name(signUpRequestDto.getName())
                .email(signUpRequestDto.getEmail())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .phoneNumber(signUpRequestDto.getPhoneNumber())
                .role(signUpRequestDto.getRole())
                .build();

        //store user in database
        User savedUser = userRepository.save(user);

        //build response
        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("User Created Successfully ")
                .build();
    }
}
