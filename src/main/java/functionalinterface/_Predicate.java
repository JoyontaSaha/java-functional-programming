package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("Imperative Approach");

        System.out.println(isPhoneNumberValid("077777"));
        System.out.println(isPhoneNumberValid("0099999999"));

        System.out.println("Declarative Approach");
        System.out.println(isPhoneNumberValidPredicate.test("077777"));
        System.out.println(isPhoneNumberValidPredicate.test("0099999999"));

    }

    // Declarative Approach
    // Predicate Functional Interface
    // 1 argument 1 boolean return
    private static Predicate<String> isPhoneNumberValidPredicate  = phoneNumber -> phoneNumber.startsWith("00") && phoneNumber.length() == 10;


    // Imperative Approach
    private static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("00") && phoneNumber.length() == 10;
    }
}
