package org.javabasics.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.javabasics.model.Reservation;

import org.javabasics.Main;
import org.javabasics.model.Trip;
import org.javabasics.model.User;
import org.javabasics.utils.Finder;

public class TripService {
    public static void displayTrips() {
        System.out.println("Lista dei viaggi:");
        for (Trip trip : Main.trips) {
            System.out.println(trip);
        }
    }

    Scanner scanner = new Scanner(System.in);

    public static void bookTrip(Scanner scanner) {

        displayTrips();
        System.out.println("Inserisci l'ID del viaggio che vuoi prenotare:");
        int tripId = scanner.nextInt();
        Trip trip = Finder.findTripById(tripId);
        if (trip == null) {
            System.out.println("Viaggio non trovato.");
            return;
        }
        if (!trip.isAvailable()) {
            System.out.println("Questo viaggio è già prenotato.");
            return;
        }
        System.out.println("Inserisci l'ID dell'utente che effettua la prenotazione:");
        int userId = scanner.nextInt();
        User user = Finder.findUserById(userId);
        if (user == null) {
            System.out.println("Utente non trovato.");
            return;
        }
        int reservationId = Main.reservations.size() + 1;
        Reservation reservation = new Reservation(reservationId, userId, tripId);
        Main.reservations.add(reservation);
        trip.setAvailable(false);
        System.out.println(
                "Prenotazione effettuata con successo." + "il numero di prenotazione è il seguente: " + reservationId);
    }

    public static void exportViaggiDisponibili(List<Trip> viaggi) {

        List<Trip> viaggiDisponibili = filterViaggiDisponibili(viaggi);

        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
        Date date = new Date();
        String currentDate = formatter.format(date);

        String fileName = "viaggi_" + currentDate + ".csv";

        try {

            FileWriter writer = new FileWriter(fileName);

            writer.append("ID;     Data;      Durata(ore);   Partenza;   Arrivo\n");

            for (Trip viaggio : viaggiDisponibili) {
                writer.append(viaggio.getId() + ";   ");
                writer.append(viaggio.getDate() + ";        ");
                writer.append(viaggio.getTimeTrip() + ";         ");
                writer.append(viaggio.getStart() + ";   ");
                writer.append(viaggio.getDestination() + "\n");
            }

            writer.close();

            System.out.println("I viaggi disponibili sono stati esportati correttamente nel file: " + fileName);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante l'esportazione dei viaggi disponibili.");
            e.printStackTrace();
        }
    }

    private static List<Trip> filterViaggiDisponibili(List<Trip> viaggi) {

        List<Trip> viaggiDisponibili = new ArrayList<>();
        for (Trip viaggio : viaggi) {
            if (viaggio.isAvailable()) {
                viaggiDisponibili.add(viaggio);
            }
        }
        return viaggiDisponibili;
    }
}
