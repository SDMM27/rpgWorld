package org.example.domain.services;

import org.example.domain.models.Donjon;
import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.example.domain.models.Mage;
import org.example.domain.models.Monstre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerActionServiceTest {

    @Mock
    private CombatService combatService;
    @Mock
    private DeplacementService deplacementService;

    private PlayerActionService playerActionService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerActionService = new PlayerActionService(combatService, deplacementService);
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out
    }

    @Test
    void testAttaquer() {
        Joueur joueur = new Guerrier("Héros");
        Monstre monstre = new Monstre(100, 10, 5, "Gobelin");

        when(combatService.engagerCombat(joueur, monstre)).thenReturn("Le joueur attaque le monstre");

        playerActionService.attaquer(joueur, monstre);

        verify(combatService).engagerCombat(joueur, monstre);
        assertTrue(outputStreamCaptor.toString().contains("Le joueur attaque le monstre"));
        if (monstre.getSante() <= 0) {
            assertTrue(outputStreamCaptor.toString().contains("Gobelin est vaincu !"));
        } else if (joueur.getSante() <= 0) {
            assertTrue(outputStreamCaptor.toString().contains("Héros est mort..."));
        }
    }

    @Test
    void testSeDeplacer() {
        Joueur joueur = new Mage("Héros");
        Donjon donjon = new Donjon(5, 5);
        String direction = "nord";

        when(deplacementService.deplacerDansSalle(joueur, donjon, direction))
                .thenReturn("Le joueur se déplace vers le nord");

        playerActionService.seDeplacer(joueur, donjon, direction);

        verify(deplacementService).deplacerDansSalle(joueur, donjon, direction);
        assertTrue(outputStreamCaptor.toString().contains("Le joueur se déplace vers le nord"));
    }
}
