package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    @Test
    public void getHerd() {

        //arrange
        AnimalGroupName namez = new AnimalGroupName();
        //act
        //desired input based on the provided code
        //assert
        assertEquals("Crash", namez.getHerd("rhino"));
        assertEquals("Tower", namez.getHerd("giraffe"));
        assertEquals("Pride", namez.getHerd("lion"));
        assertEquals("Murder", namez.getHerd("crow"));
        assertEquals("Kit", namez.getHerd("pigeon"));
        assertEquals("Herd", namez.getHerd("deer"));
        assertEquals("Pack", namez.getHerd("dog"));
        assertEquals("Float", namez.getHerd("crocodile"));


    }

    @Test
    public void getHerdwierdCase() {
        //arrange
        AnimalGroupName namez = new AnimalGroupName();
        //act
        //desired input based on the provided code
        //assert
        assertEquals("Crash", namez.getHerd("Rhino"));
        assertEquals("Tower", namez.getHerd("Giraffe"));
        assertEquals("Pride", namez.getHerd("Lion"));
        assertEquals("Murder", namez.getHerd("Crow"));
        assertEquals("Kit", namez.getHerd("Pigeon"));
        assertEquals("Herd", namez.getHerd("Deer"));
        assertEquals("Pack", namez.getHerd("Dog"));
        assertEquals("Float", namez.getHerd("Crocodile"));

    }

    @Test
    public void getHerdNull() {
        //arrange
        AnimalGroupName namez = new AnimalGroupName();
        //act
        //desired input based on the provided code
        //assert
        assertEquals("unknown", namez.getHerd("null"));
        assertEquals("unknown", namez.getHerd(""));

    }
}