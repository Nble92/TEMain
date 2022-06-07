package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {

    @Test
    public void getLucky() {

        //arrange
        Lucky13 lucky = new Lucky13();
        //act
        int[] numbas = {0,2,3};
        //assert
        assertFalse(lucky.getLucky(numbas));

    }

    @Test
    public void getLuckyHappy() {

        //arrange
        Lucky13 lucky = new Lucky13();
        //act
        int[] numbas = {0,2,9};
        //assert
        assertTrue(lucky.getLucky(numbas));

    }
    @Test
    public void getLuckyEdge() {

        //arrange
        Lucky13 lucky = new Lucky13();
        //act
        int[] numbas = {-1,2,-3,33};
        //assert
        assertTrue(lucky.getLucky(numbas));

    }
}