package vn.funix.fx19878.java.asm2.models;
import java.util.*;
import java.util.ArrayList;

public class Bank {
    private final String id ;
    private final List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();

        this.id=String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (Objects.equals(customerId, customer.getCustomerId())) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(String customerId, Account account) {
        for(int i=0;i<customers.size()-1;i++) {
            if(Objects.equals(customerId, customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
            }
        }
    }

}
