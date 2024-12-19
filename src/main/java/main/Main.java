package main;

import application.controleur.ControleurJeu;
import application.dto.ReponseAction;
import domaine.modele.ClassePersonnage;
import domaine.modele.Monstre;
import domaine.modele.Personnage;
import domaine.modele.Statistiques;
import domaine.service.CombatService;
import domaine.service.CreationPersonnageService;
import domaine.service.DeplacementService;
import domaine.service.InventaireService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialisation des services
        CreationPersonnageService creationPersonnageService = new CreationPersonnageService();
        DeplacementService deplacementService = new DeplacementService();
        CombatService combatService = new CombatService();
        InventaireService inventaireService = new InventaireService();

        // Initialisation du contrôleur principal
        ControleurJeu controleurJeu = new ControleurJeu(creationPersonnageService, deplacementService, combatService, inventaireService);

        System.out.println("Bienvenue dans le RPG !");
        System.out.print("Entrez le nom de votre personnage : ");
        String nomPersonnage = scanner.nextLine();

        System.out.println("Choisissez une classe de personnage :");
        System.out.println("1. Guerrier\n2. Mage\n3. Voleur");
        int choixClasse = scanner.nextInt();
        scanner.nextLine(); // Consomme la ligne restante

        ClassePersonnage classe = switch (choixClasse) {
            case 1 -> ClassePersonnage.GUERRIER;
            case 2 -> ClassePersonnage.MAGE;
            case 3 -> ClassePersonnage.VOLEUR;
            default -> {
                System.out.println("Choix incorrect, le personnage sera un Guerrier par défaut.");
                yield ClassePersonnage.GUERRIER;
            }
        };

        ReponseAction reponseCreation = controleurJeu.creerPersonnage(nomPersonnage, classe);
        System.out.println(reponseCreation.getMessage());

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Se déplacer\n2. Combattre un monstre\n3. Utiliser un objet\n4. Quitter le jeu");
            int choixAction = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne restante

            switch (choixAction) {
                case 1 -> {
                    System.out.println("Choisissez une direction : nord, sud, est, ou ouest");
                    String direction = scanner.nextLine().toLowerCase();
                    ReponseAction deplacement = controleurJeu.deplacerPersonnage(direction);
                    System.out.println(deplacement.getMessage());
                }
                case 2 -> {
                    Monstre monstre = new Monstre("Gobelin", new Statistiques(30, 5, 2, 0));
                    ReponseAction combat = controleurJeu.combattre(new Personnage(nomPersonnage, classe), monstre);
                    System.out.println(combat.getMessage());
                }
                case 3 -> {
                    System.out.println("Entrez le nom de l'objet à utiliser :");
                    String nomObjet = scanner.nextLine();
                    ReponseAction utilisationObjet = controleurJeu.utiliserObjet(new Personnage(nomPersonnage, classe), nomObjet);
                    System.out.println(utilisationObjet.getMessage());
                }
                case 4 -> {
                    System.out.println("Fin de la session de jeu.");
                    continuer = false;
                }
                default -> System.out.println("Choix incorrect. Veuillez choisir une option valide.");
            }
        }
        scanner.close();
    }
}
