package com.mohamedmostafa.IMS_project.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDto {
    private String token;         // JWT token
    private String email;         // optional, can help client
    private Date expiresAt;
}
