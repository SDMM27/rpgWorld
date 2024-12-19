package domaine.service;

import application.dto.ReponseAction;
import domaine.modele.Monstre;
import domaine.modele.Personnage;

public class CombatService {
    public ReponseAction combattre(Personnage personnage, Monstre monstre) {
        while (personnage.getStatistiques().getSante() > 0 && monstre.getStatistiques().getSante() > 0) {
            // Logique du combat (attaques mutuelles, dégâts)
        }
        return personnage.getStatistiques().getSante() > 0
                ? new ReponseAction(true, "Victoire contre le monstre !")
                : new ReponseAction(false, "Défaite contre le monstre...");
    }
}
