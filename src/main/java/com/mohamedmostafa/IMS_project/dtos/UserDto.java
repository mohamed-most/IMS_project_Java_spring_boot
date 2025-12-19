package com.mohamedmostafa.IMS_project.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mohamedmostafa.IMS_project.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class UserDto {

    private String id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    private UserRole role;

    private List<TransactionDto> transactions;

    private LocalDateTime createdAt;
}
