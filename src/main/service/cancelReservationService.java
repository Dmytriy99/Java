package main.service;

import java.util.Scanner;

import main.model.Reservation;
import main.model.Trip;
import main.Main;

public class cancelReservationService {
    public static void cancelReservation(Scanner scanner) {
        System.out.println("Inserisci l'ID della prenotazione che vuoi disdire:");
        int reservationId = scanner.nextInt();
        Reservation reservationToRemove = find.findReservationById(reservationId);
        if (reservationToRemove == null) {
            System.out.println("Prenotazione non trovata.");
            return;
        }
        Trip reservedTrip = find.findTripById(reservationToRemove.getTripId());
        if (reservedTrip != null) {
            System.out.println("Viaggio trovato con ID: " + reservedTrip.getId());
            System.out.println("Stato del viaggio prima dell'aggiornamento: " + reservedTrip.isAvailable());
            reservedTrip.setAvailable(true);
            System.out.println("Stato del viaggio dopo l'aggiornamento: " + reservedTrip.isAvailable());
            Main.reservations.remove(reservationToRemove);
            System.out.println("Prenotazione disdetta correttamente.");
        } else {
            System.out.println("Errore nella disdetta della prenotazione.");
        }
    }
}
