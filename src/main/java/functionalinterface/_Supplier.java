package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("Imperative Approach");
        System.out.println(getDBConnectionURL());

        System.out.println("Declarative Approach");
        System.out.println(getDBConnectionURLSupplier.get());
    }

    // Imperative Approach
    public static String getDBConnectionURL() {
        return "jdbc://localhost:8080/user";
    }

    // Declarative Approach
    // no argument 1 result as output
    public static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:8080/user";
}
