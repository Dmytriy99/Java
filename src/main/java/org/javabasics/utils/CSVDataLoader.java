package org.javabasics.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.javabasics.model.Reservation;

import org.javabasics.Main;
import org.javabasics.model.Trip;
import org.javabasics.model.User;

public class CSVDataLoader {
    public static void loadCSVData() {
        try {
            BufferedReader userReader = new BufferedReader(
                    new FileReader("src/main/java/org/javabasics/data/utenti.csv"));
            String lineUser;
            boolean firstLine = true;
            while ((lineUser = userReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = lineUser.split(";");

                try {
                    int id = Integer.parseInt(data[0]);
                    User user = new User(id, data[1], data[2], data[3], data[4], data[5]);
                    Main.users.add(user);
                } catch (NumberFormatException e) {
                    System.err.println("Errore durante il parsing dell'ID utente: " + lineUser);
                    e.printStackTrace();
                }

            }
            userReader.close();
            // Carica viaggi
            BufferedReader tripReader = new BufferedReader(
                    new FileReader("src/main/java/org/javabasics/data/viaggi.csv"));
            String line;
            while ((line = tripReader.readLine()) != null) {

                if (line.trim().isEmpty() || line.startsWith("?ID")) {
                    continue;
                }
                String[] data = line.split(";");

                if (data.length < 4) {
                    System.err.println("Riga viaggio non valida: " + line);
                    continue;
                }
                try {

                    String idString = data[0].replaceAll("[^0-9]", "");
                    if (!idString.isEmpty()) {
                        int id = Integer.parseInt(idString);
                        String date = data[1];
                        int timeTrip = Integer.parseInt(data[2]);
                        String start = data[3];
                        String arrive = data[4];
                        boolean available = Boolean.parseBoolean(data[5]);
                        Trip trip = new Trip(id, date, timeTrip, start, arrive, available);
                        Main.trips.add(trip);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Errore durante il parsing dell'ID viaggio: " + line);
                    e.printStackTrace();
                }
            }
            tripReader.close();
            BufferedReader reservationReader = new BufferedReader(
                    new FileReader("src/main/java/org/javabasics/data/prenotazioni.csv"));
            String lineReservation;
            boolean firstLineReservation = true; // Aggiunto per ignorare la prima riga
            while ((lineReservation = reservationReader.readLine()) != null) {
                if (firstLineReservation) {
                    firstLineReservation = false;
                    continue;
                }
                String[] data = lineReservation.split(";");
                try {
                    int id = Integer.parseInt(data[0]);
                    int userId = Integer.parseInt(data[1]);
                    int bookId = Integer.parseInt(data[2]);
                    Reservation reservation = new Reservation(id, userId, bookId);
                    Main.reservations.add(reservation);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Errore durante il parsing della prenotazione: " + lineReservation);
                    e.printStackTrace();
                }
            }
            reservationReader.close();
        } catch (IOException e) {
            System.err.println("Errore durante l'apertura o la lettura del file");
            e.printStackTrace();
        }

    }
}
