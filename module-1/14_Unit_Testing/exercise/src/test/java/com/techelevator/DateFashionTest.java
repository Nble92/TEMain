package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {

    @Test
    public void getATableHappyPath() {

        //arrange
        DateFashion datetest = new DateFashion();
        //act

        //assert
        //hits all 3 normal result
        assertEquals(0, datetest.getATable(9,2));
        assertEquals(1, datetest.getATable(5,3));
        assertEquals(2, datetest.getATable(9,3));



    }
    @Test
    public void getATableEdge() {

        //arrange
        DateFashion datetest = new DateFashion();
        //act

        //assert
        //this tests outside of the given parameters. I can assume this is okay
        //based on the instructions
        assertEquals(2, datetest.getATable(20,5));
        assertEquals(0, datetest.getATable(84,-5));

    }



}