package com.techelevator;

public class MessageLibrary {

    public static String getCountOutOfRangeMessage(int start, int end) {
        return "end value (" + end + ") cannot be smaller than start value (" + start + ")";
    }
}
