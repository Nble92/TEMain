package com.techelevator;

public class ExceptionsLecture {
//static is connect to the class not the instance

    private static LectureHelper helper = new LectureHelper();

    public static void main(String[] args) throws RangeException {
        // count from 1 to 10
        printCount(1, 20);

        // what happens if the end number is less than the start number?
        printCount(15, 5);
    }

    private static void printCount(int start, int end) {
        System.out.println();
        System.out.println("start: " + start + " / end: " + end);
        try {//trying to excecute code below
            String countString = helper.count(start, end);

            System.out.println("CountString: " + countString);
            //you can have two exceptions on one line
        } catch (IllegalArgumentException ex) { // catches exception
            //code runs at the end of
        } finally {
            //finally always happens
            System.out.println("BingBong");
        }
    }
}
