package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void getAccountHolderName() {
    }

    @Test
    public void getAccountNumber() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void deposit() {
    }

    @Test
    public void withdraw() {
        // arrange
        BankAccount bankAccount = new BankAccount("Test", "1234", 100);

        //act
        int newBalance = bankAccount.withdraw(10);

        //assert
        assertEquals(90, newBalance);

    }

    @Test
    public void transferTo() {
        //arrange
        BankAccount source = new BankAccount("Test1", "1234", 100);
        BankAccount destination = new BankAccount("Test2", "1235", 100);

        //act
        int newBalance = source.transferTo(destination, 10);

        // assert
        //checking to see if the destination received money and that the source sent money
        assertEquals(90,newBalance);
        assertEquals(110,destination.getBalance());
    }

    @Test
    public void transferTo_over500() {
        //arrange
        BankAccount source = new BankAccount("Test1", "1234", 600);
        BankAccount destination = new BankAccount("Test2", "1235", 100);

        //act
        int newBalance = source.transferTo(destination, 510);

        // assert
        //checking to see if the destination received money and that the source sent money
        assertEquals(600,newBalance);
        assertEquals(90,destination.getBalance());
    }
}