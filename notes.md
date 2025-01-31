# Principes SOLID non respectés
## Single Responsibility Principle (SRP)
La classe GameController a trop de responsabilités. Elle gère le menu, les combats, les déplacements ...

## Open/Closed Principle (OCP)
La création des personnages dans JoueurFactory utilise un switch case qui nécessite modification pour chaque nouvelle classe de personnage.
Dans Donjon.java le getSalle expose la structure interne du donjon.
Dans ConsoleUI.java l'UI accède directement aux salles du donjon via getSalle, créant un couplage fort.

# Tests
Manque de tests pour plusieurs classes importantes :
- GameController
- ConsoleUI
- PlayerActionService
- DonjonService

Allez je vous aide un peu :
```java
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position deplacer(Direction direction) {
        return switch (direction) {
            case NORD -> new Position(x, y - 1);
            case SUD -> new Position(x, y + 1);
            case EST -> new Position(x + 1, y);
            case OUEST -> new Position(x - 1, y);
        };
    }

    public boolean estDansLimites(int largeur, int hauteur) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }
}
```

Et je devrait voir ça quelque part :
```java
    private final Map<Position, Salle> salles;
```
