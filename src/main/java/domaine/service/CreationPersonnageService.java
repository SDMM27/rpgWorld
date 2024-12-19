package domaine.service;

import application.dto.ReponseAction;
import domaine.modele.ClassePersonnage;
import domaine.modele.Personnage;

public class CreationPersonnageService {
    public ReponseAction creerPersonnage(String nom, ClassePersonnage classe) {
        if (nom.length() < 3 || nom.length() > 20) {
            return new ReponseAction(false, "Le nom doit être compris entre 3 et 20 caractères.");
        }
        Personnage personnage = new Personnage(nom, classe);
        return new ReponseAction(true, "Personnage créé avec succès.");
    }
}
