package org.example.infrastructure.io;

import org.example.application.CombatUseCase;
import org.example.application.DeplacementUseCase;
import org.example.domain.Guerrier;
import org.example.domain.Joueur;
import org.example.domain.Monstre;

import java.util.Scanner;

public class ConsoleAdapter {
    public void lancerJeu() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueur = new Guerrier("Hero");
        Monstre monstre = new Monstre(100, 10, 5);

        CombatUseCase combatUseCase = new CombatUseCase();
        System.out.println(combatUseCase.engagerCombat(joueur, monstre));

        System.out.println("Voulez-vous vous déplacer ? (y/n)");
        String choix = scanner.next();

        if (choix.equalsIgnoreCase("y")) {
            DeplacementUseCase deplacementUseCase = new DeplacementUseCase();
            System.out.println(deplacementUseCase.deplacer(joueur, "N"));
        }
    }
}