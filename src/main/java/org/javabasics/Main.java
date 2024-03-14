package org.javabasics;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.javabasics.model.Reservation;

import org.javabasics.model.Trip;
import org.javabasics.model.User;
import org.javabasics.service.ReservationService;
import org.javabasics.service.TripService;
import org.javabasics.service.UserService;
import org.javabasics.utils.CSVDataLoader;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static List<Trip> trips = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        CSVDataLoader.loadCSVData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            displayMenu();
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        TripService.displayTrips();
                        break;
                    case 2:
                        TripService.bookTrip(scanner);
                        break;
                    case 3:
                        ReservationService.cancelReservation(scanner);
                        break;
                    case 4:
                        UserService.addUser(scanner);
                        break;
                    case 5:
                        TripService.exportViaggiDisponibili(trips);
                        break;
                    case 0:
                        System.out.println("Uscita dal programma.");
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserire un numero valido.");
                scanner.next();
                choice = -1;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Seleziona un'operazione:");
        System.out.println("1. Visualizzare tutte le attività");
        System.out.println("2. Prenotare un'attività esistente");
        System.out.println("3. Disdire la prenotazione di un viaggio");
        System.out.println("4. Aggiungere un nuovo utente");
        System.out.println("5. Esportare un file con i viaggi ancora disponibili");
        System.out.println("0. Uscire dal programma");
    }
}
