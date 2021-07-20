package functionalinterface;

import java.util.Optional;

public class _Optionals {
    public static void main(String[] args) {
        Optional<String> objectOptional = Optional.of("hello");
//        Optional<String> objectOptional2 = Optional.ofNullable(null); // throws null pointer exception
        Optional<String> objectOptional2 = Optional.ofNullable(null);

        String orElse = objectOptional.orElse("world");
        String orElse2 = objectOptional2.orElse("Hi");

        String orElse3 = objectOptional2
                .map(String::toUpperCase)
                .orElse("world");

        String orElse4 = objectOptional2
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // space for extra computation to retrieve value
                    return "world";
                });

        String orElse5 = objectOptional // objectOptional2 throws IllegalStateException
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalStateException("This objectOptional is null"));

        String orElse6 = objectOptional // objectOptional2 throws IllegalStateException
                .map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);

        objectOptional.ifPresent(word -> {System.out.println(word);});

        // java 11 feature
        /*objectOptional.ifPresentOrElse(System.out::println, ()-> {
            System.out.println("world");
        });*/


        System.out.println("isPresent :: " + objectOptional.isPresent());
        boolean isEmpty = !objectOptional.isPresent();
        System.out.println("isEmpty :: " + isEmpty);

        System.out.println("isPresent :: " + objectOptional2.isPresent());
        boolean isEmpty2 = !objectOptional2.isPresent();
        System.out.println("isEmpty :: " + isEmpty2);

        System.out.println("orElse :: " + orElse);
        System.out.println("orElse :: " + orElse2);

        System.out.println("orElse3 :: " + orElse3);
        System.out.println("orElse4 :: " + orElse4);
        System.out.println("orElse5 :: " + orElse5);
        System.out.println("orElse6 :: " + orElse6);


        Person person = new Person("Alex", Gender.MALE, "alex@gmail.com");
        Person person2 = new Person("Alex", Gender.MALE, null);


        // java 11 feature
        /*String email = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email not provided");

          System.out.println(email);*/

        if(!person.getEmail().isEmpty()) {
            System.out.println(person.getEmail());
        } else {
            System.out.println("Email not provided");
        }

        Optional<String> emailOptional = Optional.ofNullable(person2.getEmail());
        if(emailOptional.isPresent()) {
            System.out.println(person2.getEmail());
        } else {
            System.out.println("Email not provided");
        }



    }

    static class Person {
        private String name;
        private Gender gender;
        private String email;

        public Person(String name, Gender gender, String email) {
            this.name = name;
            this.gender = gender;
            this.email = email;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
