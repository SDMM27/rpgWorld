package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public abstract class Joueur  {

    private String nom;
    private int force, defense, sante, mana;
    private Map<Objet, Integer> inventaire = new HashMap<>();


    public Joueur(String nom, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
    }

    public Joueur(String nom) {
        this.nom = nom;
    }

    public Joueur createPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur : ");
        String nom = scanner.nextLine();
        this.nom = nom;
        return this;
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




}
