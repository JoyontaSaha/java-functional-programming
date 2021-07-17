package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "+09999");

        System.out.println("Imperative Approach");
        greetCustomer(customer);


        System.out.println("Declarative Approach");
        greetCustomerConsumer.accept(customer);

        System.out.println("Imperative Approach");
        greetCustomerV2(customer, true);


        System.out.println("Declarative Approach");
        greetCustomerBiConsumer.accept(customer, false);
    }

    // Declarative Approach
    // Consumer Functional Interface
    // 1 argument no return
    private static Consumer<Customer> greetCustomerConsumer  = customer -> System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + customer.getCustomerPhoneNumber());

    // Declarative Approach
    // BiConsumer Functional Interface
    // 2 arguments no return
    private static BiConsumer<Customer, Boolean> greetCustomerBiConsumer  = (customer, showPhoneNumber) -> System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + (showPhoneNumber ? customer.getCustomerPhoneNumber() : "*******"));


    // Imperative Approach
    private static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + customer.getCustomerPhoneNumber());
    }

    // Imperative Approach
    private static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + (showPhoneNumber ? customer.getCustomerPhoneNumber() : "*******"));
    }

    static class  Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerPhoneNumber() {
            return customerPhoneNumber;
        }
    }
}
