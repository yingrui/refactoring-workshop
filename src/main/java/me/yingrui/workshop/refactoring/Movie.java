package me.yingrui.workshop.refactoring;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        this.setPriceCode(priceCode);
    }

    private void setPriceCode(int arg) {
        _priceCode = new Price(arg);
    }

    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRented) {
        return _priceCode.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        int points = 1;
        if ((_priceCode.getPriceCode() == NEW_RELEASE) && (daysRented > 1))
            points++;
        return points;
    }
}
