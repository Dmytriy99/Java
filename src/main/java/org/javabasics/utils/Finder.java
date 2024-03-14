package org.javabasics.utils;

import org.javabasics.model.Reservation;

import org.javabasics.Main;
import org.javabasics.model.Trip;
import org.javabasics.model.User;

public class Finder {

    public static Trip findTripById(int id) {
        for (Trip trip : Main.trips) {
            if (trip.getId() == id) {
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
