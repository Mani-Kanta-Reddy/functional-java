package com.neon.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier
{
    public static void main(String[] args)
    {
        //normal
        System.out.println(getConnectionURL());
        //supplier
        System.out.println(supplyConnectionURL.get());
        System.out.println(supplyURLs.get());
    }

    static Supplier<String> supplyConnectionURL = () -> "jdbc:mysql://localhost:3306/users";
    static Supplier<List<String>> supplyURLs = () -> List.of(
        "jdbc:mysql://localhost:3306/users",
        "jdbc:postgresql://localhost:5432/users"
    );

    static String getConnectionURL() {
        return "jdbc:mysql://localhost:3306/users";
    }
}
