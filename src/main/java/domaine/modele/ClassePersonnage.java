package domaine.modele;

public enum ClassePersonnage {
    GUERRIER, MAGE, VOLEUR;

    public Statistiques initialiserStatistiques() {
        switch (this) {
            case GUERRIER: return new Statistiques(100, 10, 5, 0);
            case MAGE: return new Statistiques(70, 5, 3, 50);
            case VOLEUR: return new Statistiques(80, 7, 7, 20);
            default: throw new IllegalArgumentException("Classe inconnue");
        }
    }
}
