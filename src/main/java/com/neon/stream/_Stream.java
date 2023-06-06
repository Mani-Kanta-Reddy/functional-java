package com.neon.stream;

import java.util.List;
import java.util.stream.Collectors;

public class _Stream
{
    public static void main(String[] args)
    {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Mary", Gender.FEMALE),
            new Person("Alice", Gender.FEMALE),
            new Person("Bob", Gender.MALE),
            new Person("Zarah", Gender.PREFER_NOT_TO_SAY)
        );

        //Just print all available genders
        people.stream()
            .map(person -> person.gender)
            .collect(Collectors.toSet())
            .forEach(System.out::println);

        //Check if all are persons only
        System.out.println(people.stream().allMatch(person -> person.gender.equals(Gender.MALE)));
        //Check if atlease one MALE
        System.out.println(people.stream().anyMatch(person -> person.gender.equals(Gender.MALE)));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
