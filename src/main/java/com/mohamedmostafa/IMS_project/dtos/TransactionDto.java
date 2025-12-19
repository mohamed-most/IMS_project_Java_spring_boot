package com.mohamedmostafa.IMS_project.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mohamedmostafa.IMS_project.enums.TransactionStatus;
import com.mohamedmostafa.IMS_project.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class TransactionDto {
    private Long id;

    private Integer totalProducts;

    private BigDecimal totalPrice;


    private TransactionType transactionType; // pruchase, sale, return


    private TransactionStatus status; //pending, completed, processing

    private String description;
    private String note;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    private ProductDto product;

    private UserDto user;

    private SupplierDto supplier;
}
