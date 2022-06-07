package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {
//write test and cover as many bases as possible
    //happy paths, edgeCasses, etc.
    @Test
    public void getBits() {

        //arrange
        StringBits bitTest = new StringBits();


        //act
        String result = bitTest.getBits("Heeololeo");


        //assert
        assertEquals("Hello", result);


    }
    @Test
    public void getBits_singleChar() {

        //arrange
        StringBits bitTest = new StringBits();


        //act
        String result = bitTest.getBits("Hi");


        //assert
        assertEquals("H", result);

//might wanna check for null & empty strings
    }
    @Test
    public void getBits_testNull() {

        //arrange
        StringBits bitTest = new StringBits();


        //act
        String result = bitTest.getBits(null);


        //assert
        assertEquals("", result);

//might wanna check for null & empty strings
    }




}