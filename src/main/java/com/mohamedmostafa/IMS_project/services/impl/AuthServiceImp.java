package com.mohamedmostafa.IMS_project.services.impl;


import com.mohamedmostafa.IMS_project.dtos.request.LoginRequestDto;
import com.mohamedmostafa.IMS_project.dtos.request.SignUpRequestDto;
import com.mohamedmostafa.IMS_project.dtos.response.LoginResponseDto;
import com.mohamedmostafa.IMS_project.dtos.response.SignUpResponseDto;
import com.mohamedmostafa.IMS_project.exceptions.InvalidCredentialsException;
import com.mohamedmostafa.IMS_project.exceptions.NotFoundException;
import com.mohamedmostafa.IMS_project.mappers.AuthMapper;
import com.mohamedmostafa.IMS_project.models.User;
import com.mohamedmostafa.IMS_project.repos.UserRepository;
import com.mohamedmostafa.IMS_project.security.JwtUtil;
import com.mohamedmostafa.IMS_project.services.AuthService;
import lombok.Data;
import org.springframework.context.annotation.Primary;
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
     * @return Response<LoginResponseDto>
     */
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
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
        return LoginResponseDto.builder()
                .email(user.getEmail())
                .token(token)
                .expiresAt(jwtUtil.extractExpiration(token))
                .build();
    }


    /**
     *
     * @param signUpRequestDto
     * @return Response
     */
    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        //build User Object from request
        User user = AuthMapper.toUser(signUpRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //store user in database
        User savedUser = userRepository.save(user);

        //build response
        return SignUpResponseDto.builder()
                .email(user.getEmail())
                .build();
    }
}
