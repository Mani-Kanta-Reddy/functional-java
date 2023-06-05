package com.neon.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer
{
    public static void main(String[] args) {
        Customer mary = new Customer("Mary", "9742439479");
        //normal func
        greet(mary);
        //consumer
        greet.accept(mary);
        greetOptional.accept(mary, false);
    }

    static Consumer<Customer> greet = (customer) -> {
        System.out.println(
            "Hi " + customer.name + " thanks for registering and your mobile number is : " + customer.mobile
        );
    };

    static BiConsumer<Customer, Boolean> greetOptional = (customer, displayMobile) -> {

        if (!displayMobile)
        {
            System.out.println("Hi " + customer.name + " thanks for registering with us");
        } else {
            greet(customer);
        }
    };
    static void greet(Customer customer) {
        System.out.println(
            "Hi " + customer.name + " thanks for registering and your mobile number is : " + customer.mobile
        );
    }

    static class Customer {
        private final String name;
        private final String mobile;

        Customer(String name, String mobile)
        {
            this.name = name;
            this.mobile = mobile;
        }
    }
}
