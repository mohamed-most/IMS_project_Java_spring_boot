package com.mohamedmostafa.IMS_project.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mohamedmostafa.IMS_project.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String email;

    @JsonIgnore
    private String password;


    private String phoneNumber;


    private UserRole role;

    //transactions add later

    private LocalDateTime createdAt;
}
