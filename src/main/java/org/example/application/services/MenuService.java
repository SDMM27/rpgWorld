package org.example.application.services;

import org.example.application.GameController;
import org.example.infrastructure.utils.UserInputValidator;

public class MenuService {
    private final GameController gameController;
    private final UserInputValidator inputValidator;

    public MenuService(GameController gameController, UserInputValidator inputValidator) {
        this.gameController = gameController;
        this.inputValidator = inputValidator;
    }

    public void afficherMenu() {
        System.out.println("1: Attaquer");
        System.out.println("2: Se déplacer");
        System.out.println("3: Sauvegarder");
        System.out.println("4: Quitter");

        int choix = inputValidator.lireEntier(1, 4);
        gameController.executerAction(choix);
    }
}
