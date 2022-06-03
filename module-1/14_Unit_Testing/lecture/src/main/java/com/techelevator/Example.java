package com.techelevator;

public class Example {
    public static void main(String[] args) {
        CheckingAccount checkingAccount1 = new CheckingAccount("Tom", "1234", 100);
        CheckingAccount checkingAccount2 = new CheckingAccount("Mary", "1235", 200);

        checkingAccount1.transferTo(checkingAccount2, 10);

        System.out.println("Tom has $" + checkingAccount1.getBalance());
        System.out.println("Mary has $" + checkingAccount2.getBalance());

    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public int divide(int a, int b) {
        return a / b;
    }

}

