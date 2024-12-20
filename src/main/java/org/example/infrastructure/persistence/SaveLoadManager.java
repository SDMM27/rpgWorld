package org.example.infrastructure.persistence;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.domain.Donjon;
import org.example.domain.Joueur;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadManager {
    private static final String SAVE_FILE = "savefile.json";
    private final Gson gson;

    public SaveLoadManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void sauvegarderPartie(Joueur joueur, Donjon donjon) {
        try (FileWriter writer = new FileWriter(SAVE_FILE)) {
            writer.write(gson.toJson(new PartieData(joueur, donjon)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Donjon chargerPartie() {
        try (FileReader reader = new FileReader(SAVE_FILE)) {
            return gson.fromJson(reader, Donjon.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class PartieData {
        private final Joueur joueur;
        private final Donjon donjon;

        public PartieData(Joueur joueur, Donjon donjon) {
            this.joueur = joueur;
            this.donjon = donjon;
        }

        public Joueur getJoueur() {
            return joueur;
        }

        public Donjon getDonjon() {
            return donjon;
        }
    }
}