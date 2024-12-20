package org.example.domain.models;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testCreationPersonnageValide() {
        Joueur joueur = new Guerrier("Arthur");
        assertEquals("Arthur", joueur.getNom());
        assertEquals(10, joueur.getForce(), "La force initiale devrait être 10");
        assertEquals(5, joueur.getDefense(), "La défense initiale devrait être 5");
        assertEquals(100, joueur.getSante(), "La santé initiale devrait être 100");
        assertEquals(50, joueur.getMana(), "Le mana initial devrait être 50");
    }

    @Test
    void testNomValide() {
        Joueur joueur = new Guerrier("Arthur");
        assertEquals("Arthur", joueur.getNom(), "Le nom du joueur doit correspondre à celui défini");
    }

    @Test
    void testCreatePlayerWithValidName() {
        // Simuler une entrée utilisateur
        String nomJoueur = "ValidName\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());
        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("ValidName", joueur.getNom(), "Le joueur devrait avoir le nom 'ValidName'");

        // Réinitialiser l'entrée standard
        System.setIn(System.in);
    }

    @Test
    void testCreatePlayerWithLongName() {
        // Simuler une entrée utilisateur avec un nom trop long suivi d'un nom valide
        String nomJoueur = "NomTropLong\nValide\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());
        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("Valide", joueur.getNom(), "Le joueur devrait avoir un nom valide après validation");

        // Réinitialiser l'entrée standard
        System.setIn(System.in);
    }
}
