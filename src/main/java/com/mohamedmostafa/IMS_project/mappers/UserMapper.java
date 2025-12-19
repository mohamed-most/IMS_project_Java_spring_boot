package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.TransactionDto;
import com.mohamedmostafa.IMS_project.dtos.UserDto;
import com.mohamedmostafa.IMS_project.models.Transaction;
import com.mohamedmostafa.IMS_project.models.User;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class UserMapper {

    // Entity → DTO
    public static UserDto toDto(User user) {
        if (user == null) return null;

        List<TransactionDto> transactionDtos = null;
        if (user.getTransactions() != null) {
            transactionDtos = user.getTransactions().stream()
                    .map(TransactionMapper::toDto)
                    .collect(Collectors.toList());
        }

        return UserDto.builder()
                .id(user.getId()) // optional
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .transactions(transactionDtos)
                .createdAt(user.getCreatedAt())
                .build();
    }

    // DTO → Entity
    public static User toEntity(UserDto dto) {
        if (dto == null) return null;

        List<Transaction> transactions = null;
        if (dto.getTransactions() != null) {
            transactions = dto.getTransactions().stream()
                    .map(TransactionMapper::toEntity)
                    .collect(Collectors.toList());
        }

        return User.builder()
                .id(dto.getId() != null ? dto.getId().toString() : null)
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .role(dto.getRole())
                .transactions(transactions)
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
