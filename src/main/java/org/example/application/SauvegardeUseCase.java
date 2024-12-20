package org.example.application;

import org.example.domain.Donjon;
import org.example.domain.Joueur;
import org.example.domain.ports.PersistancePort;
import org.example.infrastructure.persistence.SaveLoadManager;

public class SauvegardeUseCase implements PersistancePort {
    private final SaveLoadManager saveLoadManager;

    public SauvegardeUseCase(SaveLoadManager saveLoadManager) {
        this.saveLoadManager = saveLoadManager;
    }

    @Override
    public void sauvegarderPartie(Joueur joueur, Donjon donjon) {
        saveLoadManager.sauvegarderPartie(joueur, donjon);
    }

    @Override
    public Donjon chargerPartie() {
        return saveLoadManager.chargerPartie();
    }
}