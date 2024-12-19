package domaine.modele;

public class Monstre {
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

    private String nom;
    private Statistiques statistiques;

    public Monstre(String nom, Statistiques statistiques) {
        this.nom = nom;
        this.statistiques = statistiques;
    }
}
