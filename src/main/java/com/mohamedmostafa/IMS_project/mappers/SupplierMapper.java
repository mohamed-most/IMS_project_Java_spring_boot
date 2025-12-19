package com.mohamedmostafa.IMS_project.mappers;

import com.mohamedmostafa.IMS_project.dtos.SupplierDto;
import com.mohamedmostafa.IMS_project.models.Supplier;

public class SupplierMapper {
    // Entity → DTO
    public static SupplierDto toDto(Supplier supplier) {
        if (supplier == null) return null;

        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .build();
    }

    // DTO → Entity
    public static Supplier toEntity(SupplierDto dto) {
        if (dto == null) return null;

        return Supplier.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .build();
    }
}
