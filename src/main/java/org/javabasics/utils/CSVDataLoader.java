package org.javabasics.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.javabasics.model.Reservation;

import org.javabasics.Main;
import org.javabasics.model.Trip;
import org.javabasics.model.User;

public class CSVDataLoader {
    public static void loadCSVData() {
        try {
            InputStream userStream = Main.class.getResourceAsStream("/data/utenti.csv");
            BufferedReader userReader = new BufferedReader(new InputStreamReader(userStream, "UTF-8"));
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
            InputStream tripStream = Main.class.getResourceAsStream("/data/viaggi.csv");
            BufferedReader tripReader = new BufferedReader(new InputStreamReader(tripStream, "UTF-8"));
            String line;
            boolean firstLineTrip = true;
            while ((line = tripReader.readLine()) != null) {
                if (firstLineTrip) {
                    firstLineTrip = false;
                    continue;
                }

                String[] data = line.split(";");
                try {
                    int id = Integer.parseInt(data[0]);
                    String date = data[1];
                    int timeTrip = Integer.parseInt(data[2]);
                    String start = data[3];
                    String arrive = data[4];
                    boolean available = true;
                    Trip trip = new Trip(id, date, timeTrip, start, arrive, available);
                    Main.trips.add(trip);

                } catch (NumberFormatException e) {
                    System.err.println("Errore durante il parsing dell'ID viaggio: " + line);
                    e.printStackTrace();
                }
            }
            tripReader.close();
            InputStream reservationStream = Main.class.getResourceAsStream("/data/prenotazioni.csv");
            BufferedReader reservationReader = new BufferedReader(new InputStreamReader(reservationStream, "UTF-8"));
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
                    int bookId = Integer.parseInt(data[1]);
                    int userId = Integer.parseInt(data[2]);
                    Reservation reservation = new Reservation(id, bookId, userId);
                    Main.reservations.add(reservation);
                    Trip trip = Finder.findTripById(bookId);
                    if (trip != null) {
                        trip.setAvailable(false);
                    }
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
