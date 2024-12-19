package domaine.modele;

public class Statistiques {
    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    private int sante;
    private int force;
    private int defense;
    private int mana;

    public Statistiques(int sante, int force, int defense, int mana) {
        this.sante = sante;
        this.force = force;
        this.defense = defense;
        this.mana = mana;
    }
}
