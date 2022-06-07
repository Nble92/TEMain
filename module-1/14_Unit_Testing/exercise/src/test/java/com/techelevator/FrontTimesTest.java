package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {

    @Test
    public void generateString() {

        //arrange
        FrontTimes frontT = new FrontTimes();
        //act
        String res = frontT.generateString("192005",3);
        //assert
        assertEquals("192192192",res);


        //act
         res = frontT.generateString("AZ",3);
        //assert
        assertEquals("AZAZAZ",res);


    }
    @Test
    public void generateStringEdge() {

        //arrange
        FrontTimes frontT = new FrontTimes();
        //act
        String res = frontT.generateString("A",3);
        //assert
        assertEquals("AAA",res);


        //act
        res = frontT.generateString("789999",-3);
        //assert
        assertEquals("",res);


    }


}