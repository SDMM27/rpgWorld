package org.example;

import java.util.Scanner;

public class Main {
    private static Joueur joueur; // Variable globale pour le joueur

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre classe : ");
        System.out.println("1: Guerrier\n2: Mage\n3: Voleur");

        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        if (choix == 1) {
            joueur = new Guerrier("joueur1");
            joueur.createPlayer();
        } else if (choix == 2) {
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

        while (true) {
            menu();
        }
    }

    public static void seDeplacer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dans quelle direction voulez-vous aller ? (N, S, E, O)");
        String direction = scanner.nextLine();

        Donjon donjon = new Donjon(5, 5); // Donjon 5x5
        DeplacementService deplacementService = new DeplacementService(5, 5);
        String resultat = deplacementService.deplacerDansSalle(joueur, donjon, direction); // Passe le joueur
        System.out.println(resultat);

        // Afficher la salle actuelle
        Salle salleActuelle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
        if (salleActuelle != null) {
            salleActuelle.afficherSalle(joueur.getPositionX(), joueur.getPositionY());
        }

        // Afficher le donjon
        donjon.afficherDonjon(joueur.getSalleX(), joueur.getSalleY());
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
            System.exit(0);
        }
    }

    public static void attaquer() {
        Monstre monstre = new Monstre(50, 8, 5);
        CombatService combatService = new CombatService();
        String resultatCombat = combatService.engagerCombat(joueur, monstre);
        System.out.println(resultatCombat);
    }


    public static void recolter() {
        System.out.println("Récolte");
    }

    public static void afficherInventaire() {
        System.out.println("Inventaire");
    }

    public static void quitter() {
        System.out.println("Au revoir");
    }

    public static void sauvegarderPartie(Joueur joueur, Donjon donjon) {
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        saveLoadManager.sauvegarderPartie(joueur, donjon);
    }

}
