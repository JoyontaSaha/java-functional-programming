package functionalinterface;

import imperative_vs_declarative.Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("John", Gender.MALE),
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.MALE),
                new Person("Bob", Gender.PREFER_NOT_TO_SAY));

        // Imperative Approach
        System.out.println("Imperative Approach :: ");
        for (Person person : people) {
            System.out.println(person.getName().length());
        }

        boolean anyFemale = false;

        for(Person person : people) {
            if(person.getGender().equals(Gender.FEMALE)) {
                anyFemale = true;
                break;
            }
        }

        if(anyFemale) {
            System.out.println("anyFemale :: " + true);
        } else {
            System.out.println("anyFemale :: " + false);
        }

        System.out.println("\n\n\n");

        // Declarative Approach
        System.out.println("Declarative Approach Explicit variable declaration:: ");
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        boolean anyMatchFemale = people.stream()
                .anyMatch(personPredicate);

        System.out.println("anyMatchFemale :: " + anyMatchFemale);

        System.out.println("\nDeclarative Approach inline declaration:: ");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean anyMatchFemale2 = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println("anyMatchFemale :: " + anyMatchFemale2);

    }

    static class Person {
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
