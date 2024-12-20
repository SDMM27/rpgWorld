package org.example.service;

import org.example.model.Joueur;
import org.example.model.Monstre;

import java.util.Random;

public class CombatService {
    public String engagerCombat(Joueur joueur, Monstre monstre) {
        Random random = new Random();
        while (joueur.getSante() > 0 && monstre.getSante() > 0) {
            // Tour du joueur
            int degatsJoueur = joueur.getForce() - monstre.getDefense();
            monstre.setSante(monstre.getSante() - Math.max(degatsJoueur, 0));
            if (monstre.getSante() <= 0) {
                return "Victoire ! Le monstre a été vaincu.";
            }

            // Tour du monstre
            int degatsMonstre = monstre.getForce() - joueur.getDefense();
            joueur.setSante(joueur.getSante() - Math.max(degatsMonstre, 0));
            if (joueur.getSante() <= 0) {
                return "Défaite... Vous avez été vaincu.";
            }
        }
        return "Combat terminé.";
    }
}
