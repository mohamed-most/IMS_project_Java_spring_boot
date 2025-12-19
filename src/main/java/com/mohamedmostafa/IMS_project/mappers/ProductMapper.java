package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.ProductDto;
import com.mohamedmostafa.IMS_project.models.Product;

public class ProductMapper {

    // Entity → DTO
    public static ProductDto toDto(Product product) {
        if (product == null) return null;

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .description(product.getDescription())
                .expiryDate(product.getExpiryDate())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }

    // DTO → Entity
    public static Product toEntity(ProductDto dto) {
        if (dto == null) return null;

        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .sku(dto.getSku())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .description(dto.getDescription())
                .expiryDate(dto.getExpiryDate())
                .imageUrl(dto.getImageUrl())
                .category(CategoryMapper.toEntity(dto.getCategory()))
                .build();
    }
}
