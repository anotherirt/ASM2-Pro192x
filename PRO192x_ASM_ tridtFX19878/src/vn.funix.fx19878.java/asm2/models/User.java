package vn.funix.fx19878.java.asm2.models;

import java.util.regex.Pattern;

public class User {
    private String name;
    private String customerId;

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public static boolean validateCustomerId(String idNumbers){
        Pattern pattern = Pattern.compile("^\\d{12}$");

        if(!(pattern.matcher(idNumbers).find())){
            return false;
        } else
            return true;
    }
    public void setCustomerId(String customerId) {
        if(validateCustomerId(customerId)){
            this.customerId = customerId;
        }
    }

}
