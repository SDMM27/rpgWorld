package org.example.model;

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

    public void setSante(int sante) {
        this.sante = sante;
    }

    public int getForce() {
        return force;
    }

    public int getDefense() {
        return defense;
    }
}
