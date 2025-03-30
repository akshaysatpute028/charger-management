package com.example.charger_management.repository;

import com.example.charger_management.model.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, Long> {
    Optional<Charger> findByChargerId(String chargerId);
}
