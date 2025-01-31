package org.example.application;

import org.example.application.services.GameService;
import org.example.application.services.QuitService;
import org.example.domain.services.CombatService;
import org.example.domain.services.DeplacementService;
import org.example.domain.services.PlayerActionService;
import org.example.infrastructure.persistence.SaveLoadManager;
import org.example.infrastructure.utils.UserInputValidator;

public class GameRunner {
    public void run() {
        CombatService combatService = new CombatService();
        DeplacementService deplacementService = new DeplacementService(5, 5);
        PlayerActionService playerActionService = new PlayerActionService(combatService, deplacementService);
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        UserInputValidator inputValidator = new UserInputValidator();
        GameService gameService = new GameService(saveLoadManager, inputValidator);

        QuitService quitService = new QuitService();

        GameController gameController = new GameController(playerActionService, gameService, quitService, inputValidator);
        gameController.startGame();
    }
}
