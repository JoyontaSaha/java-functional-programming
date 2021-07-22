package functionalinterface;

import java.util.function.Consumer;

public class _Callbacks {
    public static void main(String[] args) {
        hello("Alex", "dear", value -> {
            System.out.println("No last name defined for " + value);
        });

        hello("Roy", null, value -> {
            System.out.println("No last name defined for " + value);
        });

        hello2("Maria", null, () -> {
            System.out.println("No last name defined");
        });
    }
    static void hello(String firstName, String lastName, Consumer<String> callbacks) {
        System.out.println("FirstName :: " + firstName);

        if(lastName != null) {
            System.out.println("LastName :: " + lastName);
        } else {
            callbacks.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callbacks) {
        System.out.println("FirstName :: " + firstName);

        if(lastName != null) {
            System.out.println("LastName :: " + lastName);
        } else {
            callbacks.run();
        }
    }
}
