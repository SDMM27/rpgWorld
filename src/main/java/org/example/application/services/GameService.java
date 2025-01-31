package org.example.application.services;

import org.example.domain.factories.JoueurFactory;
import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;
import org.example.infrastructure.persistence.SaveLoadManager;
import org.example.infrastructure.utils.UserInputValidator;

public class GameService {
    private final SaveLoadManager saveLoadManager;
    private final UserInputValidator inputValidator;

    public GameService(SaveLoadManager saveLoadManager, UserInputValidator inputValidator) {
        this.saveLoadManager = saveLoadManager;
        this.inputValidator = inputValidator;
    }

    public Joueur creerNouvellePartie() {
        System.out.println("🆕 Création d'une nouvelle partie...");

        System.out.println("Choisissez votre classe :");
        System.out.println("1: Guerrier");
        System.out.println("2: Mage");
        System.out.println("3: Voleur");

        int choixClasse = inputValidator.lireEntier(1, 3);
        String nomJoueur = inputValidator.lireNomJoueur();

        Joueur joueur;
        switch (choixClasse) {
            case 1 -> joueur = JoueurFactory.creerJoueur("Guerrier", nomJoueur);
            case 2 -> joueur = JoueurFactory.creerJoueur("Mage", nomJoueur);
            case 3 -> joueur = JoueurFactory.creerJoueur("Voleur", nomJoueur);
            default -> throw new IllegalStateException("Choix invalide, impossible !");
        }

        System.out.println("✅ Nouvelle partie créée avec succès !");
        return joueur;
    }

    public Joueur chargerPartie() {
        var data = saveLoadManager.chargerPartie();
        if (data != null) {
            System.out.println("✅ Partie chargée avec succès !");
            return data.joueur;
        } else {
            System.out.println("⚠️ Aucune sauvegarde trouvée, création d'une nouvelle partie.");
            return creerNouvellePartie();
        }
    }

    public void sauvegarderPartie(Joueur joueur, Donjon donjon) {
        saveLoadManager.sauvegarderPartie(joueur, donjon);
        System.out.println("💾 Partie sauvegardée avec succès !");
    }
}
