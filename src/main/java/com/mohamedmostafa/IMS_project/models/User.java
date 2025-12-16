package com.mohamedmostafa.IMS_project.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required ")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "PhoneNumber is required")
    @Column(name = "phone_number")
    private String phoneNumber;

}
