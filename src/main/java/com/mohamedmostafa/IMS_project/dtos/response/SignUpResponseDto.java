package com.mohamedmostafa.IMS_project.dtos.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpResponseDto {
    private String email;
}
