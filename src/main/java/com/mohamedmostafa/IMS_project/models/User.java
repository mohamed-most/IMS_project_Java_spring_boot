package com.mohamedmostafa.IMS_project.models;


import com.mohamedmostafa.IMS_project.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
@Builder
public class User {


    @Id
    private String id;


    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required ")
    @Column(name = "email", unique = true)
    private String email;


    @NotBlank(message = "Password is required")
    private String password;


    @NotBlank(message = "PhoneNumber is required")
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;


    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
