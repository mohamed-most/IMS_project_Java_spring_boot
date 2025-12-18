package com.mohamedmostafa.IMS_project.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
@Builder
@Data
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;


    @NotBlank(message = "Name is required ....")
    private String name;


    private String address;
}
