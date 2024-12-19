package domaine.modele;

import java.util.ArrayList;
import java.util.List;

public class Personnage {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }

    public List<Objet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(List<Objet> inventaire) {
        this.inventaire = inventaire;
    }

    public ClassePersonnage getClasse() {
        return classe;
    }

    public void setClasse(ClassePersonnage classe) {
        this.classe = classe;
    }

    private Statistiques statistiques;
    private List<Objet> inventaire;
    private ClassePersonnage classe;

    public Personnage(String nom, ClassePersonnage classe) {
        this.nom = nom;
        this.classe = classe;
        this.statistiques = classe.initialiserStatistiques();
        this.inventaire = new ArrayList<>();
    }
}