package org.javabasics.service;

import java.util.Scanner;

import org.javabasics.model.Reservation;

import org.javabasics.Main;
import org.javabasics.model.Trip;
import org.javabasics.utils.Finder;

public class ReservationService {
    public static void cancelReservation(Scanner scanner) {
        System.out.println("Inserisci l'ID della prenotazione che vuoi disdire:");
        int reservationId = scanner.nextInt();
        Reservation reservationToRemove = Finder.findReservationById(reservationId);
        if (reservationToRemove == null) {
            System.out.println("Prenotazione non trovata.");
            return;
        }
        Trip reservedTrip = Finder.findTripById(reservationToRemove.getTripId());
        if (reservedTrip != null) {
            reservedTrip.setAvailable(true);
            Main.reservations.remove(reservationToRemove);
            System.out.println("Prenotazione disdetta correttamente.");
        } else {
            System.out.println("Errore nella disdetta della prenotazione.");
        }
    }
}
