package domaine.modele;

public class Objet {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public Objet(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }
}