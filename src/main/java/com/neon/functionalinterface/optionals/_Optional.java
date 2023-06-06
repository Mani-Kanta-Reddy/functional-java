package com.neon.functionalinterface.optionals;

import java.util.Optional;

public class _Optional
{
    public static void main(String[] args) {
        String s = Optional.ofNullable("John").orElse("No User Found");
        Object noUserFound = Optional.ofNullable(null).orElse("No User Found");
        System.out.println(s);
        System.out.println(noUserFound);
        String s1 = Optional.ofNullable("john@gmail.com").orElseThrow();
        System.out.println(s1);
        // Object o = Optional.ofNullable(null).orElseThrow(); //Throws NoSuchElementException
        Integer length = Optional.ofNullable("John").map(String::length).orElse(0);
        System.out.println(length);
        Optional.ofNullable("John").ifPresent(System.out::println);
        Optional.ofNullable("John").ifPresentOrElse(System.out::println, () -> System.out.println("User Not Found"));
    }
}
