package main.service;

import java.util.Scanner;

import main.Main;
import main.model.User;

public class addUserService {
    public static void addUser(Scanner scanner) {
        System.out.println("Inserisci l'ID del nuovo utente:");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consuma il resto della riga
        System.out.println("Inserisci il nome del nuovo utente:");
        String userName = scanner.nextLine();
        System.out.println("Inserisci il cognome del nuovo utente:");
        String userSurname = scanner.nextLine();
        User newUser = new User(userId, userName, userSurname);
        Main.users.add(newUser);
        System.out.println("Nuovo utente aggiunto correttamente.");
    }
}
