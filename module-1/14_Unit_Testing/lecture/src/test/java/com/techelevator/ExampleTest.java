package com.techelevator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
//"is" is a static method within core matchers.
import static org.junit.Assert.*;
//allows you to use Assert method easier to make assertions more legible.
public class ExampleTest {

    @Test
    public void isEven_withEvenValue_shouldReturnTrue() {
        //arrange
        //build a class to test

        // act
        //call the method

        // assert
        //checking the result
        assertTrue(new Example().isEven(6));

        //you can simplify by refactoring to inline variables;
        //love this shit!

    }

    @Test
    public void isEven_withOddValue_shouldReturnFalse() {
        //arrange
        Example example = new Example();
        boolean expected = false;

        // act
        boolean result = example.isEven(9);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void isEven() {
        // arrange
        Example example = new Example();

        //act
        // assert
        assertTrue(example.isEven(6));
        assertTrue(example.isEven(8));
        assertTrue(example.isEven(1008));

        assertFalse(example.isEven(5));
        assertFalse(example.isEven(7));
        assertFalse(example.isEven(1007));
    }

    @Test
    public void divide() {
        // arrange
        Example example = new Example();

        //act
        // assert
        assertEquals(7, example.divide(14, 2));
        assertEquals(7, example.divide(21, 3));
        assertEquals(2, example.divide(14, 7));
        assertEquals(10, example.divide(100, 10));
        // TODO: test drop remainder - separate test for this ???
        // using the phrase todo: highlights your code so you can look at it later
        assertEquals(10, example.divide(101, 10));
    }

    @Test(expected = ArithmeticException.class)
    public void divide_byZero() {
        // arrange
        Example example = new Example();

        //act
        // assert (in Test annotation)
        example.divide(101, 0);
    }


    @Test
    public void divide_assertThat() {
        // arrange
        Example example = new Example();

        //act
        // assert
        assertThat(example.divide(120, 10), is(equalTo(12)));
    }
}
