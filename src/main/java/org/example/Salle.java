package org.example;

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

    // Méthode pour afficher la salle
    public void afficherSalle(int joueurX, int joueurY) {
        System.out.println("Salle : " + nom);
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (x == joueurX && y == joueurY) {
                    System.out.print("P "); // Position du joueur
                } else {
                    System.out.print(". "); // Case vide
                }
            }
            System.out.println();
        }
    }
}
