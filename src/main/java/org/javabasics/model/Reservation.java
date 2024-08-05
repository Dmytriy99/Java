package org.javabasics.model;

public class Reservation {
    private int id;
    private int tripId;
    private int userId;

    public Reservation(int id, int tripId, int userId) {
        this.id = id;
        this.tripId = tripId;
        this.userId = userId;
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