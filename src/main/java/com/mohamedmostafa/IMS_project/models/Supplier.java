package com.mohamedmostafa.IMS_project.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
@Builder
@Data
public class Supplier {

    @Id
    private String id;


    @NotBlank(message = "Name is required ....")
    private String name;


    private String address;

    @PrePersist
    private void setId() {
        if (id == null) this.id = UUID.randomUUID().toString();
    }
}
