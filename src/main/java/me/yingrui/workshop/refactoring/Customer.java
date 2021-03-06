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
        String result = "Rental Record for " + getName() + "\n";
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n<ul>";
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += "\t<li><span class='movie'>" + each.getMovie().getTitle() + "</span><strong>" + String.valueOf(each.getCharge()) + "</strong></li>\n";
        }

        result += "</ul><h2>Amount owed is <strong>" + String.valueOf(getTotalCharge()) + "</strong></h2>\n";
        result += "<h2>You earned <font color='red'>" + String.valueOf(getFrequentRenterPoints()) + "</font> frequent renter points</h2>";
        return result;
    }

    private int getFrequentRenterPoints() {
        Enumeration<Rental> rentals = _rentals.elements();
        int frequentRenterPoints = 0;
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        Enumeration<Rental> rentals = _rentals.elements();
        double totalAmount = 0;
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }
}
