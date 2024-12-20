package org.example.domain.ports;

import org.example.domain.Donjon;
import org.example.domain.Joueur;

public interface PersistancePort {
    void sauvegarderPartie(Joueur joueur, Donjon donjon);
    Donjon chargerPartie();
}
