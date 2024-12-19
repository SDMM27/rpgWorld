package application.controleur;

import application.dto.ReponseAction;
import domaine.modele.ClassePersonnage;
import domaine.modele.Monstre;
import domaine.modele.Personnage;
import domaine.service.CombatService;
import domaine.service.CreationPersonnageService;
import domaine.service.DeplacementService;
import domaine.service.InventaireService;

public class ControleurJeu {
    private final CreationPersonnageService creationPersonnageService;
    private final DeplacementService deplacementService;
    private final CombatService combatService;
    private final InventaireService inventaireService;

    public ControleurJeu(CreationPersonnageService cps, DeplacementService ds, CombatService cs, InventaireService is) {
        this.creationPersonnageService = cps;
        this.deplacementService = ds;
        this.combatService = cs;
        this.inventaireService = is;
    }

    public ReponseAction creerPersonnage(String nom, ClassePersonnage classe) {
        return creationPersonnageService.creerPersonnage(nom, classe);
    }

    public ReponseAction deplacerPersonnage(String direction) {
        return deplacementService.deplacer(direction);
    }

    public ReponseAction combattre(Personnage personnage, Monstre monstre) {
        return combatService.combattre(personnage, monstre);
    }

    public ReponseAction utiliserObjet(Personnage personnage, String nomObjet) {
        return inventaireService.utiliserObjet(personnage, nomObjet);
    }
}
