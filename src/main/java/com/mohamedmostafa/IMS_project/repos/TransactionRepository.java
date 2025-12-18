package com.mohamedmostafa.IMS_project.repos;

import com.mohamedmostafa.IMS_project.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
