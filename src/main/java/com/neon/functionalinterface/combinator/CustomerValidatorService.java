package com.neon.functionalinterface.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService
{
    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private boolean isPhoneValid(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public boolean isValid(Customer customer) {
        return isValidEmail(customer.getEmail()) &&
            isPhoneValid(customer.getPhoneNumber()) &&
            isAdult(customer.getDob());
    }
}
