package org.example;

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
            case "N":
                y += 1;
                if (y >= salleActuelle.getHauteur()) { // Limite nord
                    joueur.setSalleY(joueur.getSalleY() + 1); // Passe à la salle nord
                    y = 0; // Réinitialise à la première position de la nouvelle salle
                }
                break;
            case "S":
                y -= 1;
                if (y < 0) { // Limite sud
                    joueur.setSalleY(joueur.getSalleY() - 1); // Passe à la salle sud
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) y = nouvelleSalle.getHauteur() - 1; // Dernière ligne de la salle sud
                }
                break;
            case "E":
                x += 1;
                if (x >= salleActuelle.getLargeur()) { // Limite est
                    joueur.setSalleX(joueur.getSalleX() + 1); // Passe à la salle est
                    x = 0;
                }
                break;
            case "O":
                x -= 1;
                if (x < 0) { // Limite ouest
                    joueur.setSalleX(joueur.getSalleX() - 1); // Passe à la salle ouest
                    Salle nouvelleSalle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
                    if (nouvelleSalle != null) x = nouvelleSalle.getLargeur() - 1; // Dernière colonne de la salle ouest
                }
                break;
            default:
                return "Commande invalide.";
        }

        // Vérifie si le joueur sort des limites du donjon
        if (donjon.getSalle(joueur.getSalleX(), joueur.getSalleY()) == null) {
            return "Vous ne pouvez pas aller plus loin.";
        }

        // Met à jour la position dans la salle actuelle
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
