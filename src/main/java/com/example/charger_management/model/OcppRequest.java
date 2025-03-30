package com.example.charger_management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcppRequest {
    private String action;
    private String chargerId;
    private String status;
}

