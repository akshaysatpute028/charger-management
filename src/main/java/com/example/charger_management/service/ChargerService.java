package com.example.charger_management.service;

import com.example.charger_management.model.Charger;
import com.example.charger_management.repository.ChargerRepository;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

@Service
public class ChargerService {
    @Autowired
    private ChargerRepository chargerRepository;

    public List<Charger> getAllChargers() {
        return chargerRepository.findAll();
    }

    public Optional<Charger> getChargerById(String chargerId) {
        return chargerRepository.findByChargerId(chargerId);
    }

    public void updateChargerStatus(String chargerId, String status) {
        Optional<Charger> chargerOpt = chargerRepository.findByChargerId(chargerId);
        if (chargerOpt.isPresent()) {
            Charger charger = chargerOpt.get();
            charger.setStatus(status);
            charger.setLastHeartbeat(LocalDateTime.now());
            chargerRepository.save(charger);
        }
    }
}

