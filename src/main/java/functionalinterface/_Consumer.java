package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "+09999");

        System.out.println("Imperative Approach");
        greetCustomer(customer);


        System.out.println("Declarative Approach");
        greetCustomerConsumer.accept(customer);

    }

    // Declarative Approach
    // Consumer Functional Interface
    // 1 argument no return
    private static Consumer<Customer> greetCustomerConsumer  = customer -> System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + customer.getCustomerPhoneNumber());


    // Imperative Approach
    private static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getCustomerName() + " . Thank you for registering phone number : " + customer.getCustomerPhoneNumber());
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
