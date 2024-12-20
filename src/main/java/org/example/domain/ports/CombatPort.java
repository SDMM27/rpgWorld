package org.example.domain.ports;

import org.example.domain.Joueur;
import org.example.domain.Monstre;

public interface CombatPort {
    String engagerCombat(Joueur joueur, Monstre monstre);
}