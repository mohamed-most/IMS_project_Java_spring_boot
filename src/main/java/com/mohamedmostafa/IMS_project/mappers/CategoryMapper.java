package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.CategoryDto;
import com.mohamedmostafa.IMS_project.dtos.ProductDto;
import com.mohamedmostafa.IMS_project.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    // Entity → DTO
    public static CategoryDto toDto(Category category) {
        if (category == null) return null;

        List<ProductDto> productDtos = null;
        if (category.getProducts() != null) {
            productDtos = category.getProducts().stream()
                    .map(ProductMapper::toDto)
                    .collect(Collectors.toList());
        }

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .products(productDtos)
                .build();
    }

    // DTO → Entity
    public static Category toEntity(CategoryDto dto) {
        if (dto == null) return null;

        List products = null;
        if (dto.getProducts() != null) {
            products = dto.getProducts().stream()
                    .map(ProductMapper::toEntity)
                    .collect(Collectors.toList());
        }

        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .products(products)
                .build();
    }
}
