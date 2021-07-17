package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int imperativeIncrement  = incrementByOne(10);

        System.out.println("Imperative Approach");
        System.out.println("imperativeIncrement :: " + imperativeIncrement);

        int declarativeIncrement = incrementByOneFunction.apply(10);

        System.out.println("Declarative Approach");
        System.out.println("declarativeIncrement :: " + declarativeIncrement);

        int declarativeMultiply = multiplyByTenFunction.apply(2);

        System.out.println("Declarative Approach");
        System.out.println("declarativeMultiply :: " + declarativeMultiply);


        System.out.println("Declarative Approach.....Function Chaining");
        System.out.println("addByOneThenMultiplyByTenFunction :: " + addByOneThenMultiplyByTenFunction.apply(2));

        System.out.println("Imperative Approach");
        System.out.println("addByOneThenMultiply :: " + addByOneThenMultiply(4, 20));

        System.out.println("Declarative Approach");
        System.out.println("addByOneThenMultiplyBiFUnction :: " + addByOneThenMultiplyBiFUnction.apply(4, 20));



    }

    // imperative approach
    static int incrementByOne(int number) {
        return  number + 1;
    }

    // declarative approach
    // Function interface takes 1 argument and produces 1 result
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // declarative approach
    // Function interface takes 1 argument and produces 1 result
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    // declarative approach ....Function Chaining
    // Function interface takes 1 argument and produces 1 result
    static Function<Integer, Integer> addByOneThenMultiplyByTenFunction = incrementByOneFunction.andThen(multiplyByTenFunction);

    // imperative approach
    static int addByOneThenMultiply (int number, int multiplyBy) {
        return (number + 1) * multiplyBy;
    }

    // declarative approach
    // BiFunction interface takes 2 argument and produces 1 result
    static BiFunction<Integer, Integer, Integer> addByOneThenMultiplyBiFUnction = (number, multiplyBy) -> (number + 1) * multiplyBy;
}
