package me.yingrui.workshop.refactoring;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

public class Rentals {

    public static List<Rental> rentals = Lists.newArrayList(children(1), children(4), regular(2), regular(5), newRelease(5));

    public static Rental regular(int daysRented) {
        return getRental(daysRented, Movie.REGULAR);
    }

    public static Rental newRelease(int daysRented) {
        return getRental(daysRented, Movie.NEW_RELEASE);
    }

    public static Rental children(int daysRented) {
        return getRental(daysRented, Movie.CHILDREN);
    }

    private static Rental getRental(int daysRented, int priceCode) {
        String movieName = UUID.randomUUID().toString();
        Movie movie = new Movie(movieName, priceCode);
        return new Rental(movie, daysRented);
    }

}
