package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private static boolean isEmailValid(String email) {
        return email.contains("@") ? true : false;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.contains("+0") ? true : false;
    }

    private static boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 18 ? true : false;
    }

    public static boolean isCustomerValid(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhoneNumber())
                && isAdult(customer.getDob());
    }
}
