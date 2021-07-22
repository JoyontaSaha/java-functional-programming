package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Functional Programming Properties
 * 1. No state (ex: _Lambdas)
 * 2. Pure functions (ex: _Lambdas)
 * 3. No side effects (ex: _Lambdas)
 * 4. Higher order Functions
 *  i. The functions take one or more functions as parameters. (Callbacks)
 *  ii. The function returns another function as result.(ex: CutomerRegistrationValidator)
 */

public class _Lambdas {
    public static void main(String[] args) {

        Integer count = 0;

        Function<String, String> upperCaseName = name -> { // 'name ->'  is called lambda

            // System.out.println(count);  violating -> Pure Function and No State law
            // count++; violating -> No side effects law

            return name.toUpperCase();
        };

        Function<String, String> lowerCaseName = String::toLowerCase;

        BiFunction<String, Integer, String> printAgeThenGetUpperCaseName = (name, age) -> {
            if(name.isEmpty()) throw new IllegalStateException("No name provided");
            System.out.println("Age :: " + age);

            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("alex"));


        System.out.println(lowerCaseName.apply("DON"));

        System.out.println(printAgeThenGetUpperCaseName.apply("BOB", 19));
    }
}
