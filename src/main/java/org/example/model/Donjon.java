package org.example.model;

public class Donjon {
    private final Salle[][] salles;
    private final int largeur;
    private final int hauteur;

    public Donjon(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.salles = new Salle[largeur][hauteur];
        genererSalles();
    }

    private void genererSalles() {
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                salles[x][y] = new Salle(5, 5, "Salle (" + x + ", " + y + ")");
            }
        }
    }

    public Salle getSalle(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            return salles[x][y];
        }
        return null; // Pas de salle (hors limites du donjon)
    }

    public void afficherDonjon(int salleX, int salleY) {
        System.out.println("Donjon :");
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (x == salleX && y == salleY) {
                    System.out.print("[P] "); // Salle où se trouve le joueur
                } else {
                    System.out.print("[ ] "); // Salle vide
                }
            }
            System.out.println();
        }
    }
}
