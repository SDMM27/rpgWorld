package org.example.application;

import org.example.domain.Donjon;
import org.example.domain.Salle;

public class GestionDonjonUseCase {
    private final Donjon donjon;

    public GestionDonjonUseCase(Donjon donjon) {
        this.donjon = donjon;
    }

    public String explorerSalle(int salleX, int salleY) {
        Salle salle = donjon.getSalle(salleX, salleY);
        if (salle != null) {
            return "Exploration de la salle : " + salle.getNom();
        }
        return "Salle introuvable.";
    }

    public void afficherDonjon(int joueurSalleX, int joueurSalleY) {
        donjon.afficherDonjon(joueurSalleX, joueurSalleY);
    }
}