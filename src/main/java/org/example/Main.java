package org.example;

import org.example.infrastructure.io.ConsoleAdapter;

public class Main {
    public static void main(String[] args) {
        ConsoleAdapter consoleAdapter = new ConsoleAdapter();
        consoleAdapter.lancerJeu();
    }
}