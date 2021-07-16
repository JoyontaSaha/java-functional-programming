package functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int imperativeIncrement  = incrementByOne(10);

        System.out.println("Imperative Approach");
        System.out.println("imperativeIncrement :: " + imperativeIncrement);

        int declarativeIncrement = incrementByOneFunction.apply(10);

        System.out.println("Declarative Approach");
        System.out.println("declarativeIncrement :: " + declarativeIncrement);
    }

    // imperative approach
    static int incrementByOne(int number) {
        return  number + 1;
    }

    // declarative approach
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
}
