package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre classe : ");
        System.out.println("1: Guerrier\n2: Mage\n3: Voleur");

        int choix = scanner.nextInt();
        Joueur joueur = null;

        if (choix == 1){
            joueur = new Guerrier("joueur1");
            joueur.createPlayer();
        } else if (choix == 2){
            joueur = new Mage("joueur1");
            joueur.createPlayer();
        } else if (choix == 3) {
            joueur = new Voleur("joueur1");
            joueur.createPlayer();
        }

        System.out.println("Bienvenue " + joueur.getNom() + " !" + " Voici vos caractéristiques : ");
        System.out.println("Force : " + joueur.getForce());
        System.out.println("Défense : " + joueur.getDefense());
        System.out.println("Santé : " + joueur.getSante());
        System.out.println("Mana : " + joueur.getMana());

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
