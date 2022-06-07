package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {

    @Test
    public void makeArray() {
        //arrange
        MaxEnd3 max = new MaxEnd3();
        //act
        int [] array = {1,2,3};
        max.makeArray(array);
        int [] result = max.makeArray(array);
        //assert
        assertArrayEquals(array,result);

    }
    @Test
    public void makeArray2() {
        //arrange
        MaxEnd3 max = new MaxEnd3();
        //act
        int [] array = {2,2,9};
        int [] result = max.makeArray(array);
        //assert
        assertArrayEquals(array,result);

    }
    @Test
    public void makeArrayEdge() {
        //arrange
        MaxEnd3 max = new MaxEnd3();
        //act
        int [] array = {-2,0,-2};
        int [] result = max.makeArray(array);
        //assert
        assertArrayEquals(array,result);

    }

}