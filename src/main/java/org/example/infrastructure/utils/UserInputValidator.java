package org.example.infrastructure.utils;

import java.util.Scanner;

public class UserInputValidator {
    private final Scanner scanner;

    public UserInputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public int lireEntier(int min, int max) {
        int choix;
        while (true) {
            try {
                System.out.print("> ");
                choix = Integer.parseInt(scanner.nextLine());
                if (choix >= min && choix <= max) {
                    return choix;
                } else {
                    System.out.println("❌ Entrée invalide. Veuillez choisir entre " + min + " et " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Veuillez entrer un nombre valide.");
            }
        }
    }

    public String lireNomJoueur() {
        System.out.print("Entrez le nom de votre personnage : ");
        String nom;
        while (true) {
            nom = scanner.nextLine().trim();
            if (isNomValide(nom)) {
                return nom;
            }
            System.out.println("❌ Nom invalide. Il doit contenir uniquement des lettres (3-15 caractères). Réessayez.");
        }
    }

    private boolean isNomValide(String nom) {
        return nom.matches("[a-zA-Z]{3,15}");
    }

    public String lireDirection() {
        System.out.println("Dans quelle direction voulez-vous aller ? (N, S, E, O) : ");
        String direction;
        while (true) {
            direction = scanner.nextLine().trim().toUpperCase();
            if (direction.matches("[NSEO]")) {
                return direction;
            }
            System.out.println("❌ Entrée invalide. Veuillez choisir parmi (N, S, E, O).");
        }
    }
}
