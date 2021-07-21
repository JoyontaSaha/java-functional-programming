package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alex", "alex@gmail.com", "+088737", LocalDate.of(2000, 1, 1));

        Customer customer2 = new Customer("Roy", "roygmail.com", "+88737", LocalDate.of(2020, 1, 1));

        System.out.println("isCustomerValid ::  " + CustomerValidatorService.isCustomerValid(customer));

        System.out.println("isCustomerValid ::  " +getValidationResult(customer));

        System.out.println("isCustomerValid ::  " +getValidationResult(customer2));


    }

    private static ValidationResult getValidationResult(Customer customer) {
        return isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
    }
}
