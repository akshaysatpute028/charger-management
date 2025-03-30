package com.example.charger_management.repository;

import com.example.charger_management.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByChargerChargerIdAndStartTimeBetween(String chargerId, LocalDateTime start, LocalDateTime end);
}
