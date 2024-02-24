package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.model.Reservation;
import main.model.Trip;
import main.model.User;
import main.service.addUserService;
import main.service.bookTripService;
import main.service.cancelReservationService;
import main.service.dataLoadCSV;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static List<Trip> trips = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        dataLoadCSV.loadCSVData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayTrips();
                    break;
                case 2:
                    bookTripService.bookTrip(scanner);
                    break;
                case 3:
                    cancelReservationService.cancelReservation(scanner);
                    break;
                case 4:
                    addUserService.addUser(scanner);
                    break;
                case 5:
                    main.service.ViaggioExporter.exportViaggiDisponibili(trips);
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
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

    public static void displayTrips() {
        System.out.println("Lista dei viaggi:");
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }
    // private static void loadCSVData() {
    // try {
    // BufferedReader userReader = new BufferedReader(new
    // FileReader("src/main/data/utenti.csv"));
    // String lineUser;
    // boolean firstLine = true;
    // while ((lineUser = userReader.readLine()) != null) {
    // if (firstLine) {
    // firstLine = false;
    // continue; // Ignora la prima riga di intestazione
    // }
    // String[] data = lineUser.split(";");

    // try {
    // int id = Integer.parseInt(data[0]);
    // User user = new User(id, data[1], data[2]);
    // users.add(user);
    // } catch (NumberFormatException e) {
    // System.err.println("Errore durante il parsing dell'ID utente: " + lineUser);
    // e.printStackTrace();
    // }

    // }
    // userReader.close();
    // // Carica viaggi
    // BufferedReader tripReader = new BufferedReader(new
    // FileReader("src/main/data/viaggi.csv"));
    // String line;
    // while ((line = tripReader.readLine()) != null) {
    // // Ignora le righe vuote o con dati non validi
    // if (line.trim().isEmpty() || line.startsWith("?ID")) {
    // continue;
    // }
    // String[] data = line.split(";");
    // // Ignora le righe con un numero insufficiente di campi
    // if (data.length < 4) {
    // System.err.println("Riga viaggio non valida: " + line);
    // continue;
    // }
    // try {
    // // Rimuovi caratteri non numerici dall'ID del viaggio
    // String idString = data[0].replaceAll("[^0-9]", "");
    // if (!idString.isEmpty()) {
    // int id = Integer.parseInt(idString);
    // String date = data[1];
    // int timeTrip = Integer.parseInt(data[2]);
    // String start = data[3];
    // String arrive = data[4];
    // boolean available = Boolean.parseBoolean(data[5]);
    // Trip trip = new Trip(id, date, timeTrip, start, arrive, available);
    // trips.add(trip);
    // }
    // } catch (NumberFormatException e) {
    // System.err.println("Errore durante il parsing dell'ID viaggio: " + line);
    // e.printStackTrace();
    // }
    // }
    // tripReader.close();
    // BufferedReader reservationReader = new BufferedReader(new
    // FileReader("src/main/data/prenotazioni.csv"));
    // String lineReservation;
    // boolean firstLineReservation = true; // Aggiunto per ignorare la prima riga
    // while ((lineReservation = reservationReader.readLine()) != null) {
    // if (firstLineReservation) {
    // firstLineReservation = false;
    // continue; // Ignora la prima riga di intestazione
    // }

    // String[] data = lineReservation.split(";");
    // // if (data.length < 4) {
    // // System.err.println(
    // // "Errore durante il parsing della prenotazione: la riga non ha abbastanza
    // // elementi");
    // // System.err.println("Riga: " + lineReservation);
    // // continue;
    // // }

    // try {
    // int id = Integer.parseInt(data[0]);
    // int userId = Integer.parseInt(data[1]);
    // int bookId = Integer.parseInt(data[2]);
    // // String date = data[3];
    // Reservation reservation = new Reservation(id, userId, bookId);
    // reservations.add(reservation);
    // System.out.println(reservation); // Stampiamo per debug
    // } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
    // System.err.println("Errore durante il parsing della prenotazione: " +
    // lineReservation);
    // e.printStackTrace();
    // }
    // }
    // reservationReader.close();
    // } catch (IOException e) {
    // System.err.println("Errore durante l'apertura o la lettura del file");
    // e.printStackTrace();
    // }

    // }

    // private static void bookTrip(Scanner scanner) {
    // displayTrips();
    // System.out.println("Inserisci l'ID del viaggio che vuoi prenotare:");
    // int tripId = scanner.nextInt();
    // Trip trip = findTripById(tripId);
    // if (trip == null) {
    // System.out.println("Viaggio non trovato.");
    // return;
    // }
    // if (!trip.isAvailable()) {
    // System.out.println("Questo viaggio è già prenotato.");
    // return;
    // }
    // System.out.println("Inserisci l'ID dell'utente che effettua la
    // prenotazione:");
    // int userId = scanner.nextInt();
    // User user = findUserById(userId);
    // if (user == null) {
    // System.out.println("Utente non trovato.");
    // return;
    // }
    // int reservationId = reservations.size() + 1; // ID prenotazione
    // // System.out.println(reservations.size() + 1);
    // Reservation reservation = new Reservation(reservationId, userId, tripId);
    // reservations.add(reservation);
    // trip.setAvailable(false);
    // System.out.println(
    // "Prenotazione effettuata con successo." + "il numero di prenotazione è il
    // seguente: " + reservationId);
    // }

    // private static void cancelReservation(Scanner scanner) {
    // System.out.println("Inserisci l'ID della prenotazione che vuoi disdire:");
    // int reservationId = scanner.nextInt();
    // Reservation reservationToRemove = findReservationById(reservationId);
    // if (reservationToRemove == null) {
    // System.out.println("Prenotazione non trovata.");
    // return;
    // }
    // Trip reservedTrip = findTripById(reservationToRemove.getTripId());
    // if (reservedTrip != null) {
    // System.out.println("Viaggio trovato con ID: " + reservedTrip.getId());
    // System.out.println("Stato del viaggio prima dell'aggiornamento: " +
    // reservedTrip.isAvailable());
    // reservedTrip.setAvailable(true);
    // System.out.println("Stato del viaggio dopo l'aggiornamento: " +
    // reservedTrip.isAvailable());
    // reservations.remove(reservationToRemove);
    // System.out.println("Prenotazione disdetta correttamente.");
    // } else {
    // System.out.println("Errore nella disdetta della prenotazione.");
    // }
    // }

    // private static void addUser(Scanner scanner) {
    // System.out.println("Inserisci l'ID del nuovo utente:");
    // int userId = scanner.nextInt();
    // scanner.nextLine(); // Consuma il resto della riga
    // System.out.println("Inserisci il nome del nuovo utente:");
    // String userName = scanner.nextLine();
    // System.out.println("Inserisci il cognome del nuovo utente:");
    // String userSurname = scanner.nextLine();
    // User newUser = new User(userId, userName, userSurname);
    // users.add(newUser);
    // System.out.println("Nuovo utente aggiunto correttamente.");
    // }

    // private static Trip findTripById(int id) {
    // for (Trip trip : trips) {
    // if (trip.getId() == id) {
    // System.out.println(id);
    // return trip;
    // }
    // }
    // return null;
    // }

    // private static User findUserById(int id) {
    // for (User user : users) {
    // if (user.getId() == id) {
    // return user;
    // }
    // }
    // return null;
    // }

    // private static Reservation findReservationById(int id) {
    // for (Reservation reservation : reservations) {
    // if (reservation.getId() == id) {
    // return reservation;
    // }
    // }
    // return null;
    // }
}