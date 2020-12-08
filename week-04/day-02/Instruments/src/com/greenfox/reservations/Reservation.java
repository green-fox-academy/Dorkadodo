package com.greenfox.reservations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reservation implements Reservationy {

    private String booking;

    public Reservation (){
        booking = "Booking# " + getCodeBooking() + " for " + getDowBooking();
    }

    public void printReservation() {
        System.out.println(booking);
    }

    @Override
    public String getDowBooking() {
        Random random = new Random();
        return getListOfDays().get(random.nextInt(7));
    }

    @Override
    public String getCodeBooking() {
        String code = "";
        for (int i = 0; i < 8; i++) {
            code += getRandomCharacter();
        }
        return code;
    }

    private char getRandomCharacter() {
        Random random = new Random();
        int n = random.nextInt(36);
        if (n < 10) {
            return (char) (n + 48);
        }
        return (char) (n + 55);
    }

    private List<String> getListOfDays() {
        Path path = Paths.get("days.txt");
        List<String> days = new ArrayList<>();
        try {
            days = Files.readAllLines(path);
        } catch (IOException e) {
            for (int i = 0; i < 7; i++) {
                days.add("MON");
            }
        }
        return days;
    }


}
