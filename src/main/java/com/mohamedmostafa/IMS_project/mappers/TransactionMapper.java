package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.TransactionDto;
import com.mohamedmostafa.IMS_project.models.Transaction;

public class TransactionMapper {


    // Entity → DTO
    public static TransactionDto toDto(Transaction transaction) {
        if (transaction == null) return null;

        return TransactionDto.builder()
                .id(transaction.getId())
                .totalProducts(transaction.getTotalNumberOfProducts())
                .totalPrice(transaction.getTotalPrice())
                .transactionType(transaction.getTransactionType())
                .status(transaction.getTransactionStatus())
                .description(transaction.getDescription())
                .note(transaction.getNote())
                .createdAt(transaction.getCreatedAt())
                .updateAt(transaction.getUpdatedAt())
                .product(ProductMapper.toDto(transaction.getProduct()))
                .user(UserMapper.toDto(transaction.getUser()))
                .supplier(SupplierMapper.toDto(transaction.getSupplier()))
                .build();
    }

    // DTO → Entity
    public static Transaction toEntity(TransactionDto dto) {
        if (dto == null) return null;

        return Transaction.builder()
                .id(dto.getId())
                .totalNumberOfProducts(dto.getTotalProducts())
                .totalPrice(dto.getTotalPrice())
                .transactionType(dto.getTransactionType())
                .transactionStatus(dto.getStatus())
                .description(dto.getDescription())
                .note(dto.getNote())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdateAt())
                .product(ProductMapper.toEntity(dto.getProduct()))
                .user(UserMapper.toEntity(dto.getUser()))
                .supplier(SupplierMapper.toEntity(dto.getSupplier()))
                .build();
    }
}
