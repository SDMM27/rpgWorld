package domaine.modele;

public class Salle {
    public boolean isContientMonstre() {
        return contientMonstre;
    }

    public void setContientMonstre(boolean contientMonstre) {
        this.contientMonstre = contientMonstre;
    }

    public boolean isContientTresor() {
        return contientTresor;
    }

    public void setContientTresor(boolean contientTresor) {
        this.contientTresor = contientTresor;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    private boolean contientMonstre;
    private boolean contientTresor;
    private Monstre monstre;

    public Salle(boolean contientMonstre, boolean contientTresor, Monstre monstre) {
        this.contientMonstre = contientMonstre;
        this.contientTresor = contientTresor;
        this.monstre = monstre;
    }
}
