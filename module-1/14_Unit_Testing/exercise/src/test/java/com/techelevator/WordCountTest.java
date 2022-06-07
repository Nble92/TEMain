package com.techelevator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void getCount() {
        WordCount wCount = new WordCount();
        String[] input = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put( "black", 1);
        expected.put("sheep",1);


        Map<String, Integer> result = wCount.getCount(input);
        assertEquals(expected.entrySet(),result.entrySet());
    }
    @Test
    public void getCount2() {
        WordCount wCount = new WordCount();
        String[] input = {};
        Map<String, Integer> expected = new HashMap<>();
        ;


        Map<String, Integer> result = wCount.getCount(input);
        assertEquals(expected.entrySet(),result.entrySet());
    }
}