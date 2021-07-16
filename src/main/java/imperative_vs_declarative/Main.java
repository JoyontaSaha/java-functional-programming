package imperative_vs_declarative;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        List<Person> females = new LinkedList<>();

        // Imperative approach :: What to do and How to do
        for (Person person: people) {
            if(person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }


        System.out.println(" ::: Imperative Approach :::");
        System.out.println(" :: Females :: ");
        for (Person female: females) {
            System.out.println(female);
        }

        System.out.println("\n\n\n");

        System.out.println(" ::: Declarative Approach :::");
        System.out.println(" :: Females :: ");

        // Declarative approach :: What to do
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static List<Person> getPeople() {
        return Arrays.asList(new Person("John", Gender.MALE),
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.MALE));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    static enum Gender {
        MALE,
        FEMALE
    }
}
