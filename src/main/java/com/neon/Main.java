package com.neon;

import java.util.ArrayList;
import java.util.List;

import static com.neon.Main.Gender.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Person> people = List.of(
            new Person("Dave", MALE),
            new Person("John", MALE),
            new Person("Alice", FEMALE),
            new Person("Bob", MALE),
            new Person("Maria", FEMALE)
        );

        //Imperative style for gathering FEMALES
        System.out.println("Imperative Style");
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }

        for(Person person : females) {
            System.out.println(person);
        }

        //Declrative style for the same
        System.out.println("Declarative Style");
        List<Person> females1 = people.stream().filter(person -> person.gender.equals(FEMALE)).toList();
        females1.forEach(System.out::println);
    }

    static class Person
    {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString()
        {
            return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE
    }
}
