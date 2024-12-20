package org.example.domain.ports;

import org.example.domain.Joueur;

public interface DeplacementPort {
    String deplacer(Joueur joueur, String direction);
}
