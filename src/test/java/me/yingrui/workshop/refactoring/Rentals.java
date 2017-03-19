package me.yingrui.workshop.refactoring;

import java.util.UUID;

public class Rentals {

    public static Rental regular(int daysRented) {
        return getRental(daysRented, Movie.REGULAR);
    }

    public static Rental newRelease(int daysRented) {
        return getRental(daysRented, Movie.NEW_RELEASE);
    }

    public static Rental children(int daysRented) {
        return getRental(daysRented, Movie.CHILDRENS);
    }

    private static Rental getRental(int daysRented, int priceCode) {
        String movieName = UUID.randomUUID().toString();
        Movie movie = new Movie(movieName, priceCode);
        return new Rental(movie, daysRented);
    }

}
