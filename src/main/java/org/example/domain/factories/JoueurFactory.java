package org.example.domain.factories;

import org.example.domain.models.*;

public class JoueurFactory {

    public static Joueur creerJoueur(int choix) {
        return switch (choix) {
            case 1 -> new Guerrier("Guerrier");
            case 2 -> new Mage("Mage");
            case 3 -> new Voleur("Voleur");
            default -> throw new IllegalArgumentException("Classe de joueur non reconnue.");
        };
    }
}
