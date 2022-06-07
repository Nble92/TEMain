package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

//ask Tom why this works
    public BankCustomer(){
        this.accounts = new ArrayList<>();

    }
    public BankCustomer(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[]{});
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }
    public boolean isVip(){
        boolean vIp = false;
        int total = 0;
        for (Accountable accntble : accounts) {
            total += accntble.getBalance();
        }
        if (total >= 25000){
            vIp = true;
        }


        return vIp;
    }
}
