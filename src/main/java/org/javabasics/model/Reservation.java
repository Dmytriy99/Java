package org.javabasics.model;

public class Reservation {
    private int id;
    private int userId;
    private int tripId;

    public Reservation(int id, int userId, int tripId) {
        this.id = id;
        this.userId = userId;
        this.tripId = tripId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getTripId() {
        return tripId;
    }

    @Override
    public String toString() {
        return "ID Prenotazione: " + id + ", ID Utente: " + userId + ", ID Viaggio: " + tripId;
    }
}