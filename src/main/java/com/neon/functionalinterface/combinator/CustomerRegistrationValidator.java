package com.neon.functionalinterface.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult.NOT_AN_ADULT;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult.PHONE_NOT_VALID;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult>
{

    static CustomerRegistrationValidator validateEmail() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator validatePhone() {
        return customer -> customer.getPhoneNumber().startsWith("+91") ? SUCCESS : PHONE_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer ->
            Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    default CustomerRegistrationValidator or(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? SUCCESS : other.apply(customer);
        };
    }

    enum ValidationResult {
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NOT_VALID,
        NOT_AN_ADULT
    }

}
