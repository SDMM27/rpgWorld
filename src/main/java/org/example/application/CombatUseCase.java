package org.example.application;

import org.example.domain.Joueur;
import org.example.domain.Monstre;
import org.example.domain.ports.CombatPort;

public class CombatUseCase implements CombatPort {
    @Override
    public String engagerCombat(Joueur joueur, Monstre monstre) {
        while (joueur.getSante() > 0 && monstre.getSante() > 0) {
            monstre.prendreDegats(joueur.getForce());
            if (monstre.getSante() <= 0) {
                return "Victoire ! Le monstre a été vaincu.";
            }

            joueur.prendreDegats(monstre.getForce());
            if (joueur.getSante() <= 0) {
                return "Défaite... Vous avez été vaincu.";
            }
        }
        return "Combat terminé.";
    }
}