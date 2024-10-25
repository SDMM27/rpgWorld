package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("joueur",1,1,1,1);
        joueur.createPlayer();
        // gererDonjon();
        for (int i = 1; true;) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("1: Attaquer");
        System.out.println("2: Récolter");
        System.out.println("3: Afficher inventaire");
        System.out.println("4: Se déplacer");
        System.out.println("5: Quitter");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        if (choix == 1) {
            attaquer();
        } else if (choix == 2) {
            recolter();
        } else if (choix == 3) {
            afficherInventaire();
        } else if (choix == 4) {
            seDeplacer();
        } else if (choix == 5) {
            quitter();
            // Ajoute un `System.exit(0)` pour sortir de la boucle infinie
            System.exit(0);
        }
    }

    public static void attaquer() {
        System.out.println("Attaque");
    }

    public static void recolter() {
        System.out.println("Récolte");
    }

    public static void afficherInventaire() {
        System.out.println("Inventaire");
    }

    public static void seDeplacer() {
        System.out.println("Déplacement");
    }

    public static void quitter() {
        System.out.println("Au revoir");
    }
}
