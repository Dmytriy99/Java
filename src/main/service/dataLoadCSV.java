package main.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.Main;
import main.model.Reservation;
import main.model.Trip;
import main.model.User;

public class dataLoadCSV {
    public static void loadCSVData() {
        try {
            BufferedReader userReader = new BufferedReader(new FileReader("src/main/data/utenti.csv"));
            String lineUser;
            boolean firstLine = true;
            while ((lineUser = userReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Ignora la prima riga di intestazione
                }
                String[] data = lineUser.split(";");

                try {
                    int id = Integer.parseInt(data[0]);
                    User user = new User(id, data[1], data[2]);
                    Main.users.add(user);
                } catch (NumberFormatException e) {
                    System.err.println("Errore durante il parsing dell'ID utente: " + lineUser);
                    e.printStackTrace();
                }

            }
            userReader.close();
            // Carica viaggi
            BufferedReader tripReader = new BufferedReader(new FileReader("src/main/data/viaggi.csv"));
            String line;
            while ((line = tripReader.readLine()) != null) {
                // Ignora le righe vuote o con dati non validi
                if (line.trim().isEmpty() || line.startsWith("?ID")) {
                    continue;
                }
                String[] data = line.split(";");
                // Ignora le righe con un numero insufficiente di campi
                if (data.length < 4) {
                    System.err.println("Riga viaggio non valida: " + line);
                    continue;
                }
                try {
                    // Rimuovi caratteri non numerici dall'ID del viaggio
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
            BufferedReader reservationReader = new BufferedReader(new FileReader("src/main/data/prenotazioni.csv"));
            String lineReservation;
            boolean firstLineReservation = true; // Aggiunto per ignorare la prima riga
            while ((lineReservation = reservationReader.readLine()) != null) {
                if (firstLineReservation) {
                    firstLineReservation = false;
                    continue; // Ignora la prima riga di intestazione
                }

                String[] data = lineReservation.split(";");
                // if (data.length < 4) {
                // System.err.println(
                // "Errore durante il parsing della prenotazione: la riga non ha abbastanza
                // elementi");
                // System.err.println("Riga: " + lineReservation);
                // continue;
                // }

                try {
                    int id = Integer.parseInt(data[0]);
                    int userId = Integer.parseInt(data[1]);
                    int bookId = Integer.parseInt(data[2]);
                    // String date = data[3];
                    Reservation reservation = new Reservation(id, userId, bookId);
                    Main.reservations.add(reservation);
                    // System.out.println(reservation); // Stampiamo per debug
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
