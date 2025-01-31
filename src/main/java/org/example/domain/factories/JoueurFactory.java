package org.example.domain.factories;

import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.example.domain.models.Mage;
import org.example.domain.models.Voleur;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JoueurFactory {
    private static final Map<String, Function<String, Joueur>> REGISTRE = new HashMap<>();

    static {
        REGISTRE.put("Guerrier", Guerrier::new);
        REGISTRE.put("Mage", Mage::new);
        REGISTRE.put("Voleur", Voleur::new);
    }

    public static Joueur creerJoueur(String type, String nom) {
        Function<String, Joueur> constructeur = REGISTRE.get(type);
        if (constructeur == null) {
            throw new IllegalArgumentException("Type de joueur inconnu : " + type);
        }
        return constructeur.apply(nom);
    }
}
