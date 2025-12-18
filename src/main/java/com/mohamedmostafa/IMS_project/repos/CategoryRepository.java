package com.mohamedmostafa.IMS_project.repos;

import com.mohamedmostafa.IMS_project.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
