package me.yingrui.workshop.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = amountFor(each);
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (each.getDaysRented() > 1))
                frequentRenterPoints++;

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental each) {
        double result = 0;

        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (each.getDaysRented() > 2) {
                    result += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (each.getDaysRented() > 3) {
                    result += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
