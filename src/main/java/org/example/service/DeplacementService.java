package org.example.service;

import org.example.model.Donjon;
import org.example.model.Joueur;

public class DeplacementService {
    private final int largeurGrille;
    private final int hauteurGrille;

    public DeplacementService(int largeurGrille, int hauteurGrille) {
        this.largeurGrille = largeurGrille;
        this.hauteurGrille = hauteurGrille;
    }

    public String deplacerDansSalle(Joueur joueur, Donjon donjon, String direction) {
        int x = joueur.getPositionX();
        int y = joueur.getPositionY();
        Salle salleActuelle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());

        switch (direction.toUpperCase()) {
            case "N": // Nord (vers le haut)
                y -= 1; // On diminue y pour aller vers le haut
                if (y < 0) { // Limite nord
                    joueur.setSalleY(joueur.getSalleY() - 1); // Passe à la salle nord
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) {
                        y = nouvelleSalle.getHauteur() - 1; // Dernière ligne de la nouvelle salle
                    } else {
                        joueur.setSalleY(joueur.getSalleY() + 1); // Reste dans la salle actuelle
                        y = 0;
                        return "Vous êtes déjà au bord nord du donjon.";
                    }
                }
                break;
            case "S": // Sud (vers le bas)
                y += 1; // On augmente y pour aller vers le bas
                if (y >= salleActuelle.getHauteur()) { // Limite sud
                    joueur.setSalleY(joueur.getSalleY() + 1); // Passe à la salle sud
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) {
                        y = 0; // Première ligne de la nouvelle salle
                    } else {
                        joueur.setSalleY(joueur.getSalleY() - 1); // Reste dans la salle actuelle
                        y = salleActuelle.getHauteur() - 1;
                        return "Vous êtes déjà au bord sud du donjon.";
                    }
                }
                break;
            case "E": // Est (vers la droite)
                x += 1; // On augmente x pour aller vers la droite
                if (x >= salleActuelle.getLargeur()) { // Limite est
                    joueur.setSalleX(joueur.getSalleX() + 1); // Passe à la salle est
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) {
                        x = 0; // Première colonne de la nouvelle salle
                    } else {
                        joueur.setSalleX(joueur.getSalleX() - 1); // Reste dans la salle actuelle
                        x = salleActuelle.getLargeur() - 1;
                        return "Vous êtes déjà au bord est du donjon.";
                    }
                }
                break;
            case "O": // Ouest (vers la gauche)
                x -= 1; // On diminue x pour aller vers la gauche
                if (x < 0) { // Limite ouest
                    joueur.setSalleX(joueur.getSalleX() - 1); // Passe à la salle ouest
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) {
                        x = nouvelleSalle.getLargeur() - 1; // Dernière colonne de la nouvelle salle
                    } else {
                        joueur.setSalleX(joueur.getSalleX() + 1); // Reste dans la salle actuelle
                        x = 0;
                        return "Vous êtes déjà au bord ouest du donjon.";
                    }
                }
                break;
            default:
                return "Commande invalide. Utilisez N, S, E ou O.";
        }

        joueur.setPositionX(x);
        joueur.setPositionY(y);
        return "Nouvelle position dans " + salleActuelle.getNom() + ": (" + x + ", " + y + ")";
    }



    public String deplacer(Joueur joueur, String direction) {
        int x = joueur.getPositionX();
        int y = joueur.getPositionY();

        switch (direction.toUpperCase()) {
            case "N":
                y += 1;
                break;
            case "S":
                y -= 1;
                break;
            case "E":
                x += 1;
                break;
            case "O":
                x -= 1;
                break;
            default:
                return "Commande invalide.";
        }

        if (x < 0 || x >= largeurGrille || y < 0 || y >= hauteurGrille) {
            return "Vous ne pouvez pas sortir des limites de la grille.";
        }

        joueur.setPositionX(x);
        joueur.setPositionY(y);
        return "Position mise à jour : (" + x + ", " + y + ")";
    }
}
