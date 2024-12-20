package org.example.ui;

import org.example.model.Monstre;
import org.example.model.Joueur;
import org.example.model.Donjon;
import org.example.service.CombatService;
import org.example.service.DeplacementService;
import org.example.service.GameSession;
import org.example.util.SaveLoadManager;

import java.util.Scanner;

public class ConsoleUI {
    private GameSession gameSession;

    public void lancer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu !");
        afficherOptionsDemarrage();

        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            chargerPartie();
        } else if (choix == 2) {
            creerNouvellePartie(scanner);
        } else {
            System.out.println("Choix invalide. Le jeu va s'arrêter.");
            System.exit(0);
        }

        lancerJeu();
    }

    private void afficherOptionsDemarrage() {
        System.out.println("1: Charger une partie");
        System.out.println("2: Commencer une nouvelle partie");
    }

    private void creerNouvellePartie(Scanner scanner) {
        System.out.println("Choisissez votre classe : ");
        System.out.println("1: Guerrier\n2: Mage\n3: Voleur");

        int choix = scanner.nextInt();
        scanner.nextLine();

        Joueur joueur;
        switch (choix) {
            case 1 -> joueur = JoueurFactory.createGuerrier();
            case 2 -> joueur = JoueurFactory.createMage();
            case 3 -> joueur = JoueurFactory.createVoleur();
            default -> {
                System.out.println("Choix invalide. Guerrier par défaut sélectionné.");
                joueur = JoueurFactory.createGuerrier();
            }
        }

        joueur.createPlayer();
        Donjon donjon = new Donjon(5, 5);

        gameSession = new GameSession(joueur, donjon);
        System.out.println("Nouvelle partie créée avec succès !");
    }

    private void chargerPartie() {
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        SaveLoadManager.PartieData data = saveLoadManager.chargerPartie();

        if (data != null) {
            gameSession = new GameSession(data.joueur, data.donjon);
            System.out.println("Partie chargée avec succès !");
        } else {
            System.out.println("Aucune sauvegarde trouvée. Création d'une nouvelle partie.");
            Scanner scanner = new Scanner(System.in);
            creerNouvellePartie(scanner);
        }
    }

    private void lancerJeu() {
        while (true) {
            afficherMenuPrincipal();
        }
    }

    private void afficherMenuPrincipal() {
        System.out.println("1: Attaquer");
        System.out.println("2: Récolter");
        System.out.println("3: Afficher inventaire");
        System.out.println("4: Se déplacer");
        System.out.println("5: Sauvegarder la partie");
        System.out.println("6: Charger une partie");
        System.out.println("7: Quitter");

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        switch (choix) {
            case 1 -> attaquer();
            case 2 -> recolter();
            case 3 -> afficherInventaire();
            case 4 -> seDeplacer();
            case 5 -> sauvegarderPartie();
            case 6 -> chargerPartie();
            case 7 -> quitter();
            default -> System.out.println("Choix invalide. Réessayez.");
        }
    }

    private void attaquer() {
        Monstre monstre = new Monstre(50, 8, 5);
        CombatService combatService = new CombatService();
        String resultatCombat = combatService.engagerCombat(gameSession.getJoueur(), monstre);
        System.out.println(resultatCombat);
    }

    private void recolter() {
        System.out.println("Récolte non implémentée.");
    }

    private void afficherInventaire() {
        System.out.println("Inventaire : " + gameSession.getJoueur().getInventaire());
    }

    private void seDeplacer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dans quelle direction voulez-vous aller ? (N, S, E, O)");
        String direction = scanner.nextLine();

        DeplacementService deplacementService = new DeplacementService(5, 5);
        String resultat = deplacementService.deplacerDansSalle(gameSession.getJoueur(), gameSession.getDonjon(), direction);
        System.out.println(resultat);
    }

    private void sauvegarderPartie() {
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        saveLoadManager.sauvegarderPartie(gameSession.getJoueur(), gameSession.getDonjon());
    }

    private void quitter() {
        System.out.println("Au revoir");
        System.exit(0);
    }
}