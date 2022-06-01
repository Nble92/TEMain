package com.techelevator;

public class CheckingAccount extends BankAccount {

    private int overDraftFee = 10;
    private int withdrawBalanceLimit = -100;
    private int newBalance;

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }


    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
        this.newBalance = balance;
    }


    @Override
    public int withdraw(int amountToWithdraw) {
//checks to see if the balance is negative
        if ((getBalance() - amountToWithdraw) > withdrawBalanceLimit) {


            //scenario where the balance is negative after withdraw
            //if everything is good
            super.withdraw(amountToWithdraw);
            if (getBalance() < 0) {
                amountToWithdraw = overDraftFee;
                super.withdraw(amountToWithdraw);
            }



    }
        return getBalance();
    }
}

