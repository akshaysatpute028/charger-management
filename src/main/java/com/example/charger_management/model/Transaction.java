package com.example.charger_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "charger_id", referencedColumnName = "chargerId", nullable = false)
    private Charger charger;

    @Column(nullable = false)
    private LocalDateTime startTime;

    private LocalDateTime stopTime;
    private Double energyConsumedKwh;

    @Column(nullable = false)
    private String status; // Started, Completed, Faulted
}


