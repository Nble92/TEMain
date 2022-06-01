package com.techelevator;

public class SavingsAccount extends BankAccount {

    private int serviceCharge = 2;
    private int newBalance;


    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }


    @Override
    public int withdraw(int amountToWithdraw) {
        if ((getBalance() - amountToWithdraw) -serviceCharge >= 0) {

                super.withdraw(amountToWithdraw);
            if (getBalance() < 150 ){
            amountToWithdraw = serviceCharge;
            super.withdraw(amountToWithdraw);
            }
        }
        return newBalance;
    }
}