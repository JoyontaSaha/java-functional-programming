package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("Imperative Approach");
        System.out.println(getDBConnectionURL());

        System.out.println("Declarative Approach");
        System.out.println(getDBConnectionURLSupplier.get());

        System.out.println("Declarative Approach");
        System.out.println(getDBConnectionURLListSupplier.get());
    }

    // Imperative Approach
    public static String getDBConnectionURL() {
        return "jdbc://localhost:8080/user";
    }

    // Declarative Approach
    // no argument 1 result as output
    public static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:8080/user";

    // Declarative Approach
    // no argument 1 result as output
    public static Supplier<List<String>> getDBConnectionURLListSupplier = () ->
            Arrays.asList("jdbc://localhost:8080/user", "jdbc://localhost:8081/admin");

}
