package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function <Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : INVALID_EMAIL;
    }

    static CustomerRegistrationValidator isPhoneNumberValid () {
        return customer -> customer.getPhoneNumber().contains("+0") ? SUCCESS : INVALID_PHONE_NUMBER;
    }

    static CustomerRegistrationValidator isAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ? SUCCESS : NOT_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return SUCCESS.equals(result) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE_NUMBER,
        NOT_ADULT
    }
}
