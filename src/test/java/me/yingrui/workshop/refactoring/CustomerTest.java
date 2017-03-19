package me.yingrui.workshop.refactoring;

import org.junit.Test;

import static me.yingrui.workshop.refactoring.Rentals.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class CustomerTest {

    @Test
    public void should_be_able_to_print_statement_for_customer() {
        Customer customer = new Customer("yingrui");
        customer.addRental(children(1));
        customer.addRental(children(4));
        customer.addRental(regular(2));
        customer.addRental(regular(5));
        customer.addRental(newRelease(5));

        String statement = customer.statement();
        assertThat(statement, containsString("Amount owed is 28.0"));
        assertThat(statement, containsString("You earned 6 frequent renter points"));
    }

}