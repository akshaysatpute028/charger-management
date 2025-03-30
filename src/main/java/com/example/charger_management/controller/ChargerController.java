package com.example.charger_management.controller;

import com.example.charger_management.model.Charger;
import com.example.charger_management.service.ChargerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/chargers")
public class ChargerController {
    @Autowired
    private ChargerService chargerService;

    @GetMapping
    public List<Charger> getChargers() {
        return chargerService.getAllChargers();
    }
}

