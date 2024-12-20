package org.example.application;

import org.example.domain.Joueur;
import org.example.domain.ports.DeplacementPort;

public class DeplacementUseCase implements DeplacementPort {
    @Override
    public String deplacer(Joueur joueur, String direction) {
        int x = joueur.getPositionX();
        int y = joueur.getPositionY();

        switch (direction.toUpperCase()) {
            case "N":
                y -= 1;
                break;
            case "S":
                y += 1;
                break;
            case "E":
                x += 1;
                break;
            case "O":
                x -= 1;
                break;
            default:
                return "Direction invalide.";
        }

        joueur.setPositionX(x);
        joueur.setPositionY(y);
        return "Nouveau déplacement : (" + x + ", " + y + ")";
    }
}