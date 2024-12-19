package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public abstract class Joueur  {

    private String nom;
    private int force, defense, sante, mana;
    private String type;
    private Map<Objet, Integer> inventaire = new HashMap<>();
    private int positionX = 0;
    private int positionY = 0;
    private int salleX = 0;
    private int salleY = 0;



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

        while (true) {
            System.out.println("Entrez le nom du joueur (maximum 10 caractères) : ");
            String nom = scanner.nextLine();

            if (nom.length() <= 10 && !nom.isEmpty()) {
                this.nom = nom;
                break;
            } else {
                System.out.println("Le nom est trop long, il doit contenir au minimum 1 caractère et  maximum 10 caractères. Essayez à nouveau.");
            }
        }
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

    // Getters et setters
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


    // Getters et setters
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

    public void setSante(int sante) {
        this.sante = sante;
    }

    public String getType() {
        if (type == null || type.isEmpty()) {
            this.type = this.getClass().getSimpleName();
        }
        return type;
    }



}
