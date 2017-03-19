package me.yingrui.workshop.refactoring;

import org.junit.Test;

import static me.yingrui.workshop.refactoring.Rentals.rentals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class CustomerTest {

    @Test
    public void should_be_able_to_print_statement_for_customer() {
        Customer customer = new Customer("yingrui");
        rentals.forEach(customer::addRental);

        String statement = customer.statement();
        assertThat(statement, containsString("Rental Record for yingrui"));
        rentals.forEach(rental -> assertThat(statement, containsString(String.format("%s\t%s", rental.getMovie().getTitle(), rental.getCharge()))));
        assertThat(statement, containsString("Amount owed is 28.0"));
        assertThat(statement, containsString("You earned 6 frequent renter points"));
    }

    @Test
    public void should_be_able_to_print_html_statement_for_customer() {
        Customer customer = new Customer("yingrui");
        rentals.forEach(customer::addRental);

        String statement = customer.htmlStatement();
        assertThat(statement, containsString("<h1>Rental Record for yingrui</h1>"));
        rentals.forEach(rental -> assertThat(statement, containsString(String.format("<li><span class='movie'>%s</span><strong>%s</strong></li>", rental.getMovie().getTitle(), rental.getCharge()))));
        assertThat(statement, containsString("<h2>Amount owed is <strong>28.0</strong></h2>"));
        assertThat(statement, containsString("<h2>You earned <font color='red'>6</font> frequent renter points</h2>"));
    }

}