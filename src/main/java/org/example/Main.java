package org.example;

import java.util.Scanner;

public class Main {
    private static Joueur joueur; // Variable globale pour le joueur
    private static Donjon donjon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu !");
        System.out.println("1: Charger une partie");
        System.out.println("2: Commencer une nouvelle partie");

        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        if (choix == 1) {
            chargerPartie(); // Appelle la méthode pour charger une partie
            if (joueur == null || donjon == null) {
                System.out.println("Aucune partie sauvegardée n'a été trouvée. Créons une nouvelle partie !");
                creerNouvellePartie(scanner);
            }
        } else if (choix == 2) {
            creerNouvellePartie(scanner);
        } else {
            System.out.println("Choix invalide. Le jeu va s'arrêter.");
            System.exit(0);
        }

        // Lancer la boucle principale du jeu
        while (true) {
            menu();
        }
    }

    public static void creerNouvellePartie(Scanner scanner) {
        donjon = new Donjon(5, 5); // Initialiser un nouveau donjon

        System.out.println("Choisissez votre classe : ");
        System.out.println("1: Guerrier\n2: Mage\n3: Voleur");

        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        if (choix == 1) {
            joueur = new Guerrier("joueur1");
        } else if (choix == 2) {
            joueur = new Mage("joueur1");
        } else if (choix == 3) {
            joueur = new Voleur("joueur1");
        } else {
            System.out.println("Choix invalide. Créons un Guerrier par défaut.");
            joueur = new Guerrier("joueur1");
        }

        joueur.createPlayer();

        System.out.println("Bienvenue " + joueur.getNom() + " !");
        System.out.println("Voici vos caractéristiques : ");
        System.out.println("Force : " + joueur.getForce());
        System.out.println("Défense : " + joueur.getDefense());
        System.out.println("Santé : " + joueur.getSante());
        System.out.println("Mana : " + joueur.getMana());
    }


    public static void seDeplacer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dans quelle direction voulez-vous aller ? (N, S, E, O)");
        String direction = scanner.nextLine();

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
        System.out.println("5: Sauvegarder la partie");
        System.out.println("6: Charger une partie");
        System.out.println("7: Quitter");

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
            sauvegarderPartie(joueur, donjon);
        } else if (choix == 6) {
            chargerPartie();
        } else if (choix == 7) {
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

    public static void chargerPartie() {
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        SaveLoadManager.PartieData data = saveLoadManager.chargerPartie();

        if (data != null) {
            joueur = data.joueur;
            donjon = data.donjon;
            System.out.println("Partie chargée avec succès !");
        } else {
            System.out.println("Aucune partie sauvegardée n'a été trouvée ou une erreur est survenue.");
        }
    }



}
