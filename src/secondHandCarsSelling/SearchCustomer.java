package secondHandCarsSelling;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchCustomer {

    public static Customer search (List<Customer> customers, int customerID){
        for (Customer customer : customers){
            if (customer.getCustomerID() == customerID){
                try {
                    Customer customer1 = (Customer)customer.clone();
                    return customer1;
                } catch (CloneNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    public static List<Customer> search (List<Customer> customers, String customerName) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                foundCustomers.add(customer);
            }
        }
        if (foundCustomers.isEmpty()) {
            System.out.println("Customer not found");
        }

        return foundCustomers;
    }
}
