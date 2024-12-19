package domaine.service;

import application.dto.ReponseAction;
import domaine.modele.Personnage;

public class InventaireService {
    public ReponseAction utiliserObjet(Personnage personnage, String nomObjet) {
        // Logique d'utilisation d'objet (comme utiliser une potion pour soigner le personnage)
        return new ReponseAction(true, "Objet utilisé : " + nomObjet);
    }
}
