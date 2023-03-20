package vn.funix.fx19878.java.asm2.models;

import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String customerId) {
        super(name, customerId);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium(){
        for (Account account : accounts) {
            if (account.isPremium())
                return true;
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Account account : accounts) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }

    public double getBalance() {
        double total=0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void displayInformation() {
        String isPre;
        int count = 0;
        if(isPremium())
            isPre="Premium";
        else
            isPre="Normal";

        System.out.printf("%-15s | % -20s | %-15s | %-20s\n",getCustomerId(),getName(),isPre,getBalance());
        for (Account account : accounts) {
            System.out.printf("%-15s | % -20s\n", count++, account.toString());
        }
    }
}
