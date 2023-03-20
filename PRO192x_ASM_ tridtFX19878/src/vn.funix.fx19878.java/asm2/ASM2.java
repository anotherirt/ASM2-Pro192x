package vn.funix.fx19878.java.asm2;

import vn.funix.fx19878.java.asm2.models.Account;
import vn.funix.fx19878.java.asm2.models.Bank;
import vn.funix.fx19878.java.asm2.models.Customer;
import vn.funix.fx19878.java.asm2.models.User;

import java.util.*;
import java.util.regex.Pattern;

public class ASM2 {
    public static final String AUTHOR = "FX19878";
    public static final String VERSION = "V2.0.0";

    private static final Bank bank = new Bank();

    public static void main(String[] args) {
//        System.out.println(bank.getCustomers());
        handleFeature();
    }

    public static void handleFeature(){
        Scanner sc = new Scanner(System.in);
        subMenu();
//        try {
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addCustomers();
                    handleFeature();
                case 2:
                    addAccountForCus();
                    handleFeature();
                case 3:
                    showCustomersList();
                    handleFeature();
                case 0:
                    System.out.println("Cam on!! Hen gap lai.");
                    System.exit(0);
            }
//        } catch (NullPointerException e){
//            System.out.println("----------------");
//            System.out.println("Sai cu phap, vui long nhap lai!");
//            handleFeature();
//        }

    }
    public static void addCustomers(){
        Scanner sc = new Scanner(System.in);
        String name, cusId;
        System.out.println("Nhap ten khach hang: ");
        name = sc.next();
        System.out.println("Nhap so CCCD: ");
        cusId = sc.next();
        while (!User.validateCustomerId(cusId)) {
            System.out.println("So CCCD khong hop le, \nVui long nhap lai hoac nhap 'No' de thoat: ");
            System.out.println("Nhap so CCCD: ");
            cusId = sc.next();
                if (cusId.equals("No") || cusId.equals("no")) {
                    System.exit(0);
                }
        }

        Customer customer = new Customer(name, cusId);
        boolean isExisted = bank.isCustomerExisted(cusId);
        while(isExisted) {
            System.out.println("So CCCD da bi trung");
            System.out.println("Vui long nhap lai so CCCD: ");
            cusId = sc.next();
            isExisted = bank.isCustomerExisted(cusId);
        }
        bank.addCustomer(customer);
        System.out.println("Them khach hang thanh cong!");
    }

    public static void addAccountForCus(){
        Scanner sc = new Scanner(System.in);
        String cusId;
        String accNumbers;
        double balance;

        System.out.println("Nhap so CCCD cua khach hang: ");
        cusId = sc.nextLine();
        boolean isExisted = bank.isCustomerExisted(cusId);
        while(!isExisted) {
            System.out.println("So CCCD khong ton tai");
            addAccountForCus();
            isExisted = bank.isCustomerExisted(cusId);
        }

        System.out.println("Nhap so TK gom 6 chu so: ");
        accNumbers = sc.nextLine();
        Pattern pattern = Pattern.compile("^\\d{6}$");
        while (!(pattern.matcher(accNumbers).find())){
            System.out.println("So TK khong dung \nVui long nhap lai: ");
            accNumbers = sc.nextLine();
        }

        System.out.println("Nhap so du: ");
        balance = sc.nextDouble();
        while (balance <= 49999){
            System.out.println("So du toi thieu 50.000: ");
            System.out.println("Vui long nhap lai: ");
            balance = sc.nextDouble();
        }

        Account account = new Account(accNumbers, balance);
        bank.addAccount(cusId, account);
        System.out.println("Them tai khoan thanh cong!!");
    }

    public static void showCustomersList(){
        for(int i = 0; i <= bank.getCustomers().size(); i++) {
            bank.getCustomers().get(i).displayInformation();
        }

    }

    private static void subMenu(){
        System.out.println("+----------+----------------------+--------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@" + VERSION + "            |");
        System.out.println("+----------+----------------------+--------+");
        System.out.println(" 1. Them khach hang");
        System.out.println(" 2. Them tai khoan cho khach hang");
        System.out.println(" 3. Hien thi danh sach khach hang");
        System.out.println(" 4. Tim theo CCCD");
        System.out.println(" 5. Tim theo ten khach hang");
        System.out.println(" 0. Thoat");
        System.out.println("+----------+----------------------+--------+");
        System.out.println("Chuc nang: ");
    }

}
