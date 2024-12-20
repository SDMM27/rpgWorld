package org.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadManager {
    private static final String SAVE_FILE = "savefile.json";
    private final Gson gson;

    public SaveLoadManager() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Joueur.class, new JoueurTypeAdapter()) // Enregistre l'adaptateur
                .setPrettyPrinting() // Format JSON lisible
                .create();
    }

    // Sauvegarder les données
    public void sauvegarderPartie(Joueur joueur, Donjon donjon) {
        try (FileWriter writer = new FileWriter(SAVE_FILE)) {
            PartieData data = new PartieData(joueur, donjon);
            gson.toJson(data, writer);
            System.out.println("Partie sauvegardée avec succès dans " + SAVE_FILE);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    // Charger les données
    public PartieData chargerPartie() {
        try (FileReader reader = new FileReader(SAVE_FILE)) {
            return gson.fromJson(reader, PartieData.class);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
            return null;
        }
    }

    // Classe interne pour stocker les données
    public static class PartieData {
        public Joueur joueur;
        public Donjon donjon;

        public PartieData(Joueur joueur, Donjon donjon) {
            this.joueur = joueur;
            this.donjon = donjon;
        }
    }
}

