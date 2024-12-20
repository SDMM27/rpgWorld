package org.example.domain;

public abstract class Joueur {
    private String nom;
    private int force, defense, sante, mana;
    private int positionX, positionY, salleX, salleY;

    public Joueur(String nom, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
    }

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public int getDefense() {
        return defense;
    }

    public int getSante() {
        return sante;
    }

    public int getMana() {
        return mana;
    }

    public void prendreDegats(int degats) {
        this.sante = Math.max(0, this.sante - degats);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSalleX() {
        return salleX;
    }

    public void setSalleX(int salleX) {
        this.salleX = salleX;
    }

    public int getSalleY() {
        return salleY;
    }

    public void setSalleY(int salleY) {
        this.salleY = salleY;
    }
}