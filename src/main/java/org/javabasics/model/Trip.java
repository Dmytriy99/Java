package org.javabasics.model;

public class Trip {
    private int id;
    private String date;
    private int timeTrip;
    private String start;
    private String arrive;
    private boolean available;

    public Trip(int id, String date, int timeTrip, String start, String arrive, boolean available) {
        this.id = id;
        this.date = date;
        this.timeTrip = timeTrip;
        this.start = start;
        this.arrive = arrive;

        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return arrive;
    }

    public String getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getTimeTrip() {
        return timeTrip;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Data: " + date + ",Durata volo" + timeTrip + ",Partenza: " + start + ", Arrivo: "
                + arrive + ", Disponibile: " + (available ? "SI" : "NO");
    }
}
