package org.example.domain;

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
        return null;
    }

    public void afficherDonjon(int salleX, int salleY) {
        System.out.println("Donjon :");
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (x == salleX && y == salleY) {
                    System.out.print("[P] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}