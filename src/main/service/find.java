package main.service;

import main.model.Reservation;
import main.model.Trip;
import main.model.User;
import main.Main;

public class find {

    public static Trip findTripById(int id) {
        for (Trip trip : Main.trips) {
            if (trip.getId() == id) {
                System.out.println(id);
                return trip;
            }
        }
        return null;
    }

    public static User findUserById(int id) {
        for (User user : Main.users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static Reservation findReservationById(int id) {
        for (Reservation reservation : Main.reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }
}
