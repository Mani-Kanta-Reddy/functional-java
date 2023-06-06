package com.neon.functionalinterface.combinator;

import com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.isAdult;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.validateEmail;
import static com.neon.functionalinterface.combinator.CustomerRegistrationValidator.validatePhone;

public class _Combinator
{
    public static void main(String[] args)
    {
        Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+919742343999",
            LocalDate.of(2000, 1, 23)
        );

        //normal
        System.out.println(new CustomerValidatorService().isValid(customer));


        Customer customer1 = new Customer(
            "Alice",
            "alice@gmail.com",
            "919742343999",
            LocalDate.of(2000, 1, 23)
        );
        //using combinator pattern
        ValidationResult result = validateEmail()
            .and(validatePhone())
            .and(isAdult())
            .apply(customer1);

        System.out.println(result);
        if(!result.equals(SUCCESS)) throw new IllegalStateException("Invalid Customer : " + result.name());
    }
}
