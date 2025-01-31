package org.example.application;

import org.example.application.services.GameService;
import org.example.application.services.MenuService;
import org.example.application.services.QuitService;
import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;
import org.example.domain.models.Monstre;
import org.example.domain.services.PlayerActionService;
import org.example.infrastructure.utils.UserInputValidator;
import org.example.application.ConsoleUI;  

public class GameController {
    private final PlayerActionService playerActionService;
    private final GameService gameService;
    private final QuitService quitService;
    private final MenuService menuService;
    private final UserInputValidator inputValidator;

    private Joueur joueur;
    private Donjon donjon;

    public GameController(PlayerActionService playerActionService, GameService gameService, QuitService quitService, UserInputValidator inputValidator) {
        this.playerActionService = playerActionService;
        this.gameService = gameService;
        this.quitService = quitService;
        this.inputValidator = inputValidator;
        this.menuService = new MenuService(this, inputValidator);
    }

    public void startGame() {
        System.out.println("🎮 Bienvenue dans le jeu !");
        System.out.println("1: Charger une partie");
        System.out.println("2: Commencer une nouvelle partie");

        int choix = inputValidator.lireEntier(1, 2);

        if (choix == 1) {
            joueur = gameService.chargerPartie();
        } else {
            joueur = gameService.creerNouvellePartie();
        }

        donjon = new Donjon(5, 5); 

        while (true) {
            menuService.afficherMenu();
        }
    }

    public void executerAction(int choix) {
        if (joueur == null) {
            System.out.println("❌ Erreur : Aucun joueur n'a été initialisé.");
            return;
        }

        switch (choix) {
            case 1 -> playerActionService.attaquer(joueur, new Monstre(50, 8, 5, "Gobelin"));
            case 2 -> playerActionService.seDeplacer(joueur, donjon, inputValidator.lireDirection());
            case 3 -> gameService.sauvegarderPartie(joueur, donjon);
            case 4 -> quitService.quitter();
        }
        ConsoleUI.afficherEtat(joueur, donjon);
    }
}
