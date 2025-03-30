package com.example.charger_management.controller;

import com.example.charger_management.model.Transaction;
import com.example.charger_management.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{chargerId}")
    public List<Transaction> getTransactions(@PathVariable String chargerId,
                                             @RequestParam LocalDateTime start,
                                             @RequestParam LocalDateTime end) {
        return transactionService.getTransactions(chargerId, start, end);
    }

    @PostMapping("/start/{chargerId}")
    public String startTransaction(@PathVariable String chargerId) {
        transactionService.startTransaction(chargerId);
        return "Transaction started for charger: " + chargerId;
    }

    @PostMapping("/stop/{transactionId}")
    public String stopTransaction(@PathVariable Long transactionId, @RequestParam Double energyConsumed) {
        transactionService.stopTransaction(transactionId, energyConsumed);
        return "Transaction stopped. Energy consumed: " + energyConsumed + " kWh";
    }
}

