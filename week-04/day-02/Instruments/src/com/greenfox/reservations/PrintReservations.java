package com.greenfox.reservations;

public class PrintReservations {
    public static void main(String[] args) {

        Reservation reservation;
        for (int i = 0; i < 8; i++) {
            reservation = new Reservation();
            reservation.printReservation();
        }
    }
}
