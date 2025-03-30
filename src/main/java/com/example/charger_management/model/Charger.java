package com.example.charger_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chargers")
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String chargerId;

    @Column(nullable = false)
    private String status; // Available, Charging, Faulted, Unavailable

    @Column(nullable = false)
    private LocalDateTime lastHeartbeat;

    public Charger(String chargerId) {
        this.chargerId = chargerId;
    }
}

