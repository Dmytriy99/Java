package org.javabasics.service;

import java.util.Scanner;

import org.javabasics.Main;
import org.javabasics.model.User;
import org.javabasics.utils.Validation;

public class UserService {
    public static void addUser(Scanner scanner) {
        System.out.println("Inserisci l'ID del nuovo utente:");
        int userId = Validation.inputNumberValida(scanner);
        scanner.nextLine();
        System.out.println("Inserisci il nome del nuovo utente:");
        String userName = Validation.inputStringaValida(scanner);
        System.out.println("Inserisci il cognome del nuovo utente:");
        String userSurname = Validation.inputStringaValida(scanner);
        System.out.println("Inserisci la data di nascita (formato: gg/mm/yyyy):");
        String date = Validation.inputDataValida(scanner);

        System.out.println("Inserisci l'indirizzo:");
        String adress = scanner.nextLine();
        System.out.println("Inserisci il documento ID utente:");
        String documentId = scanner.nextLine();

        User newUser = new User(userId, userName, userSurname, date, adress, documentId);
        Main.users.add(newUser);
        System.out.println("Nuovo utente aggiunto correttamente, ID utente è il seguente: " + userId);
    }
}
