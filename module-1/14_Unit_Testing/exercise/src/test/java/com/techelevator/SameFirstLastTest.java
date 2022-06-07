package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {

    @Test
    public void isItTheSame() {
        //arrange
        SameFirstLast firLst = new SameFirstLast();

        //act
        //assert
        assertFalse(firLst.isItTheSame(new int[]{1,2,3}));
        assertTrue(firLst.isItTheSame(new int[]{1,2,3,1}));
        assertTrue(firLst.isItTheSame(new int[]{1,2,1}));
    }


}