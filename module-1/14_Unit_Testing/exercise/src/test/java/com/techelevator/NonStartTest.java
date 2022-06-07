package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {

    @Test
    public void getPartialString() {
        //arrange

        NonStart noStar = new NonStart();
        //act
        //assert
        assertEquals("ohnoble", noStar.getPartialString("john", "noble"));
        assertEquals("teventrange", noStar.getPartialString("steven", "strange"));

    }
    @Test
    public void getPartialStringEdge() {
        //arrange

        NonStart noStar = new NonStart();
        //act
        //assert
        assertEquals("oamba", noStar.getPartialString("Mo", "Bamba"));
        assertEquals("trange", noStar.getPartialString(null, "strange"));

    }



}