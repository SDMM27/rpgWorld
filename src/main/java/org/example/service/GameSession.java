package org.example.service;

import org.example.model.Donjon;
import org.example.model.Joueur;

public class GameSession {
    private final Joueur joueur;
    private final Donjon donjon;

    public GameSession(Joueur joueur, Donjon donjon) {
        this.joueur = joueur;
        this.donjon = donjon;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Donjon getDonjon() {
        return donjon;
    }
}