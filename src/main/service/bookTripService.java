package main.service;

import java.util.Scanner;
import main.Main;
import main.model.Reservation;
import main.model.Trip;
import main.model.User;

public class bookTripService {
    Scanner scanner = new Scanner(System.in);

    public static void bookTrip(Scanner scanner) {

        Main.displayTrips();
        System.out.println("Inserisci l'ID del viaggio che vuoi prenotare:");
        int tripId = scanner.nextInt();
        Trip trip = find.findTripById(tripId);
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
        User user = find.findUserById(userId);
        if (user == null) {
            System.out.println("Utente non trovato.");
            return;
        }
        int reservationId = Main.reservations.size() + 1; // ID prenotazione
        // System.out.println(reservations.size() + 1);
        Reservation reservation = new Reservation(reservationId, userId, tripId);
        Main.reservations.add(reservation);
        trip.setAvailable(false);
        System.out.println(
                "Prenotazione effettuata con successo." + "il numero di prenotazione è il seguente: " + reservationId);
    }

}
