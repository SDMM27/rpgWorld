package org.example.domain;

public class Salle {
    private final int largeur;
    private final int hauteur;
    private final String nom;

    public Salle(int largeur, int hauteur, String nom) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.nom = nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getNom() {
        return nom;
    }

    public void afficherSalle(int joueurX, int joueurY) {
        System.out.println("Salle : " + nom);
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (x == joueurX && y == joueurY) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}