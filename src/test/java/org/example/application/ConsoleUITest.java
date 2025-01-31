package org.example.application;

import org.example.domain.models.Donjon;
import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.example.domain.models.Mage;
import org.example.domain.models.Salle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testAfficherEtat() {
        Joueur joueur = new Guerrier("Jean"); // Assumant que les coordonnées x, y sont initialement 0, 0
        Donjon donjon = new Donjon(3, 3);
        donjon.genererSalles(); // Assure la création de salles avec dimensions correctes

        ConsoleUI.afficherEtat(joueur, donjon);

        String expectedOutput = "Vous êtes dans la salle (0, 0)\n" +
                "Position dans la salle : (0, 0)\n" +
                "Salle : Salle (0, 0)\n" +
                "P . . . . \n" +
                ". . . . . \n" +
                ". . . . . \n" +
                ". . . . . \n" +
                ". . . . . \n" +
                "Donjon :\n" +
                "[P] [ ] [ ] \n" +
                "[ ] [ ] [ ] \n" +
                "[ ] [ ] [ ]";

        String normalizedExpected = normalize(expectedOutput);
        String normalizedActual = normalize(outputStreamCaptor.toString());

        assertEquals(normalizedExpected.length(), normalizedActual.length(), "Les longueurs des chaînes diffèrent");
        assertEquals(normalizedExpected, normalizedActual, "Les contenus des chaînes diffèrent");

    }

    @Test
    void testAfficherInventaire() {
        Joueur joueur = new Mage("Juan");
        ConsoleUI.afficherInventaire(joueur);
        assertEquals("Inventaire : (non implémenté)", outputStreamCaptor.toString().trim());
    }

    @Test
    void testAfficherSalle() {
        Salle salle = new Salle(5, 5, "Salle Test"); // Nom, largeur, hauteur
        int joueurX = 2; // Position X du joueur dans la salle
        int joueurY = 3; // Position Y du joueur dans la salle

        ConsoleUI.afficherSalle(salle, joueurX, joueurY);

        String expectedOutput = "Salle : Salle Test\n" +
                ". . . . . \n" +
                ". . . . . \n" +
                ". . . . . \n" +
                ". . P . . \n" + // Position du joueur
                ". . . . . \n";
        assertEquals(normalize(expectedOutput), normalize(outputStreamCaptor.toString()));
    }

    @Test
    void testAfficherDonjon() {
        Donjon donjon = new Donjon(3, 3); // 3x3 donjon
        donjon.genererSalles(); // Assure que toutes les salles sont initialisées
        int salleX = 1;
        int salleY = 1;

        ConsoleUI.afficherDonjon(donjon, salleX, salleY);

        String expectedOutput = "Donjon :\n" +
                "[ ] [ ] [ ] \n" +
                "[ ] [P] [ ] \n" + // Position du joueur
                "[ ] [ ] [ ] \n";
        assertEquals(normalize(expectedOutput), normalize(outputStreamCaptor.toString()));
    }

    private String normalize(String input) {
        return input.replace("\r", "").trim();
    }

}
