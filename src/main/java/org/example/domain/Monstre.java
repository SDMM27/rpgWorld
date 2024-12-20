package org.example.domain;

public class Monstre {
    private int sante;
    private int force;
    private int defense;

    public Monstre(int sante, int force, int defense) {
        this.sante = sante;
        this.force = force;
        this.defense = defense;
    }

    public int getSante() {
        return sante;
    }

    public void prendreDegats(int degats) {
        this.sante = Math.max(0, this.sante - degats);
    }

    public int getForce() {
        return force;
    }

    public int getDefense() {
        return defense;
    }
}