package com.mohamedmostafa.IMS_project.repos;

import com.mohamedmostafa.IMS_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
