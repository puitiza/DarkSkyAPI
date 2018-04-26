package com.example.apuitiza.darkskyapi.Events;

import com.example.apuitiza.darkskyapi.Models.Clima;

public class ClimaEvent {

    private final Clima clima;

    public ClimaEvent(Clima clima) {
        this.clima = clima;
    }

    public Clima getClima() {
        return clima;
    }
}
