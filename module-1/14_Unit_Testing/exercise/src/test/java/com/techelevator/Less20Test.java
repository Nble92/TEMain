package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {

    @Test
    public void isLessThanMultipleOf20() {

        //arrange
        Less20 lT = new Less20();
        //act
        //assert
        assertTrue(lT.isLessThanMultipleOf20(18));
        assertFalse(lT.isLessThanMultipleOf20(17));
        assertFalse(lT.isLessThanMultipleOf20(15));
        assertFalse(lT.isLessThanMultipleOf20(12));
        assertTrue(lT.isLessThanMultipleOf20(39));
        assertTrue(lT.isLessThanMultipleOf20(58));

    }

    @Test
    public void isLessThanMultipleOf20Edge() {

        //arrange
        Less20 lT = new Less20();
        //act
        //assert
        assertFalse(lT.isLessThanMultipleOf20(-2));
        assertFalse(lT.isLessThanMultipleOf20(0));

    }
}