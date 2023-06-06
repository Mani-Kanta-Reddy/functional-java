package com.neon.functionalinterface.callbacks;

import java.util.function.Consumer;

public class Main
{
    public static void main(String[] args)
    {
        greet("John", "Wick", value -> System.out.println("no last name for " + value));
        greet("John", null, value -> System.out.println(" provide your last name " + value));
    }

    static void greet(String firstName, String lastName, Consumer<String> callback) {
        System.out.print("Hi " + firstName);
        if(lastName != null) {
            System.out.println(lastName + " welcome!!!");
        } else {
            callback.accept(firstName);
        }
    }
}
