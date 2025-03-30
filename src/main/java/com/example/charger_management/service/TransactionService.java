package com.example.charger_management.service;

import com.example.charger_management.model.Charger;
import com.example.charger_management.model.Transaction;
import com.example.charger_management.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactions(String chargerId, LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByChargerChargerIdAndStartTimeBetween(chargerId, start, end);
    }

    public void startTransaction(String chargerId) {
        Transaction transaction = new Transaction();
        transaction.setCharger(new Charger(chargerId));
        transaction.setStartTime(LocalDateTime.now());
        transaction.setStatus("Started");
        transactionRepository.save(transaction);
    }

    public void stopTransaction(Long transactionId, Double energyConsumed) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
        transaction.setStopTime(LocalDateTime.now());
        transaction.setEnergyConsumedKwh(energyConsumed);
        transaction.setStatus("Completed");
        transactionRepository.save(transaction);
    }
}

