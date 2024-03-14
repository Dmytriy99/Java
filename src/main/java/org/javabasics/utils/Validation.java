package org.javabasics.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public static int inputNumberValida(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Inserimento non valido. Inserisci un numero come ID:");
                scanner.next();
            }
        }
    }

    public static String inputStringaValida(Scanner scanner) {
        String input = scanner.nextLine();
        if (isString(input)) {
            return input;
        } else {
            System.out.println("Inserimento non valido. Inserisci un testo.");
            return inputStringaValida(scanner);
        }
    }

    private static boolean isString(String str) {
        return str.matches("[a-zA-Z ]+");
    }

    public static String inputDataValida(Scanner scanner) {
        String input = scanner.nextLine();
        Date data = parseData(input);

        if (data != null) {
            return input;
        } else {
            System.out.println("Inserimento non valido. Inserisci la data nel formato corretto(dd/MM/yyyy). ");
            return inputDataValida(scanner);
        }
    }

    private static Date parseData(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            return null;
        }
    }
}
