package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class JoueurTest {
    @Test
    public void testCreationPersonnageValide() {
        Joueur joueur = new Guerrier("Arthur");
        assertEquals("Arthur", joueur.getNom());
        assertEquals(10, joueur.getForce());
        assertEquals(5, joueur.getDefense());
        assertEquals(100, joueur.getSante());
        assertEquals(50, joueur.getMana());
    }

    @Test
    public void testNomValide() {
        Joueur joueur = new Guerrier("Arthur");
        assertEquals("Arthur", joueur.getNom());
    }

    @Test
    public void testCreatePlayerWithValidName() {

        String nomJoueur = "ValidName\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());

        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("ValidName", joueur.getNom());

        System.setIn(System.in);
    }

    @Test
    public void testCreatePlayerWithLongName() {
        String nomJoueur = "NomTropLong\nValide\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());

        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("Valide", joueur.getNom());

        System.setIn(System.in);
    }
}
