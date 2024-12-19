package domaine.service;

import application.dto.ReponseAction;

public class DeplacementService {
    public ReponseAction deplacer(String direction) {
        // Logique de déplacement
        return new ReponseAction(true, "Déplacement vers " + direction + " effectué.");
    }
}
