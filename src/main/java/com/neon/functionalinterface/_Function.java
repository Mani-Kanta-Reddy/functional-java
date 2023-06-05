package com.neon.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function
{
    public static void main(String[] args)
    {

        System.out.println(incrementer(1));
        System.out.println(superIncrementer.apply(1));

        Integer result = superIncrementer.apply(2);
        Integer finalResult = multiplyBy10.apply(result);
        System.out.println(finalResult); // (2 + 1) * 10

        System.out.println(incrementAndMultiplyBy10.apply(5));  // (5 + 1) * 10

        System.out.println(incrementAndMultiply(4, 100)); // (4 + 1) * 100
        System.out.println(incByOneAndMul.apply(4, 100));
    }

    static Function<Integer, Integer> superIncrementer = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static Function<Integer, Integer> incrementAndMultiplyBy10 = superIncrementer.andThen(multiplyBy10);

    static BiFunction<Integer, Integer, Integer> incByOneAndMul = (number, mulVal) -> (number + 1) * mulVal;

    static int incrementer(int number)
    {
        return number + 1;
    }

    static int incrementAndMultiply(int number, int mulVal) {
        return (number + 1) * mulVal;
    }
}
