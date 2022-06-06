package com.techelevator;

public class ExceptionsLecture {

    // To trigger a NPE
    //private static LectureHelper helper = null;
    private static LectureHelper helper = new LectureHelper();

    public static void main(String[] args) throws RangeException{
        // count from 1 to 10
        printCount(1, 20);

        // what happens if the end number is less than the start number?
        printCount(15, 5);

        System.out.println("I'm Done!!!!!!!");
    }

//    private static void printCount(int start, int end) {
//        System.out.println();
//        System.out.println("start: " + start + " / end: " + end);
//        try {
//            String countString = helper.count(start, end);
//            System.out.println("CountString: " + countString);
//        } catch (RangeException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    private static void printCount(int start, int end) throws RangeException {
        System.out.println();
        System.out.println("start: " + start + " / end: " + end);
        try {
            String countString = helper.count(start, end);
            System.out.println("CountString: " + countString);
        } catch (IllegalArgumentException  ex) {
            System.out.println("Got IAE " + ex);
        } catch ( RangeException ex) {
            System.out.println("Got Range exception" + ex);
        } finally {
            System.out.println("Finally!!!!!!");
        }
    }

}
