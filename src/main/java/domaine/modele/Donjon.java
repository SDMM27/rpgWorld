package domaine.modele;

import java.util.ArrayList;
import java.util.List;

public class Donjon {
    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    private List<Salle> salles;

    public Donjon() {
        this.salles = new ArrayList<>();
    }

    public void genererDonjon(int nombreDeSalles) {
        for (int i = 0; i < nombreDeSalles; i++) {
            boolean contientMonstre = Math.random() < 0.5;
            boolean contientTresor = Math.random() < 0.3;
            Monstre monstre = contientMonstre ? new Monstre("Monstre", new Statistiques(50, 10, 5, 0)) : null;
            this.salles.add(new Salle(contientMonstre, contientTresor, monstre));
        }
    }
}