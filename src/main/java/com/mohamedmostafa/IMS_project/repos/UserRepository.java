package com.mohamedmostafa.IMS_project.repos;


import com.mohamedmostafa.IMS_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findById(String userId);

    void deleteById(String id);

    boolean existsById(String id);
}
