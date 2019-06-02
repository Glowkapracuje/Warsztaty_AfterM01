package pl.coderslab.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    private static final String HELLO_TEXT = "Hello! Let's start a game!";
    private static final String GUESS_NUMBER = "Guess a number, from 1 - ";
    private static final String ALLERT_NO_NUMBER = "Type a number, not a letter!";
    private static final String ALLERT_OUT_OF_RANGE = "Type a number from range: 1 -";
    private static final String ALLERT_NUMBER_APPEARED = "This number has already appeared";
    private static final String OK_TYPE_NUMBER = "Type the number!";
    private static final String OK_NEXT_NUMBER = "Ok, type the next number!";
    private static final String OK_WIN_TEXT = "You won! Matched numbers:";
    private static final String TRY_AGAIN = "Try again!";
    private static final String PC_NUMBERS = "My numbers are:";
    private static final String USR_NUMBERS = "Your numbers are:";
    private static final int RANGE = 49;


    public static void main(String[] args) {

        System.out.println(String.join(" ", HELLO_TEXT, GUESS_NUMBER + RANGE));
        comparison();

    }


    //    CREATE & COMPARE NUMBER ARRAYS AND DISPLAY RESULT
    static void comparison() {
        Integer[] userNumbers = scanUserNumbers();
        Integer[] pcNUmbers = createPcNumbers();
        int matchedNumbers = 0;


        for (int row : userNumbers) {
            for (int col : pcNUmbers) {
                if (row == col) {
                    matchedNumbers = matchedNumbers + 1;
                }
            }
        }
        if (matchedNumbers >= 3) {
            System.out.println(OK_WIN_TEXT + matchedNumbers);
        } else {
            System.out.println(TRY_AGAIN);
        }
    }


    //    PC NUMBERS ARRAY - CREATE AND RETURN FIRST SIX NUMBERS
    static Integer[] createPcNumbers() {
        Integer[] array = new Integer[RANGE];
        for (int row = 0; row < array.length; row++) {
            array[row] = row + 1;
        }

        Collections.shuffle(Arrays.asList(array));

        Integer[] arrayFirstSix = Arrays.copyOf(array, 6);
        Collections.sort(Arrays.asList(arrayFirstSix));
        System.out.println(PC_NUMBERS);
        System.out.println(Arrays.toString(arrayFirstSix));
        return arrayFirstSix;
    }


    //    SCAN A NUMBER FROM CONSOLE
    static int scanInt() {
        Scanner scann = new Scanner(System.in);
        while (!scann.hasNextInt()) {
            System.out.println(ALLERT_NO_NUMBER);
            scann.nextLine();
        }
        return scann.nextInt();

    }


    //    GET AND CREATE ARRAY WITH USER NUMBERS
    static Integer[] scanUserNumbers() {
        Scanner scann = new Scanner(System.in);
        int scannedNumber = 0;

        System.out.println(OK_TYPE_NUMBER);

        Integer[] intsToArray = new Integer[6];
        for (int row = 0; row < intsToArray.length; row++) {


            scannedNumber = scanInt();
            while (!(scannedNumber > 0 && scannedNumber <= RANGE)) {
                System.out.println(String.join(" ", ALLERT_OUT_OF_RANGE + RANGE, TRY_AGAIN));
                scannedNumber = scanInt();
            }
            while (hasNumberAppeared(intsToArray, scannedNumber)) {
                System.out.println(String.join(" ", ALLERT_NUMBER_APPEARED, TRY_AGAIN));
                scannedNumber = scanInt();
            }
            System.out.println(OK_NEXT_NUMBER);
            intsToArray[row] = scannedNumber;


        }
        Arrays.sort(intsToArray);
        System.out.println(USR_NUMBERS);
        System.out.println(Arrays.toString(intsToArray));
        return intsToArray;

    }


    //    CHECK, HAS THE NUMBER ALREADY APPEARED?
    static boolean hasNumberAppeared(Integer[] array, Integer number) {
        for (int row = 0; row < array.length; row++) {
            if (array[row] == number) {
                return true;
            }

        }
        return false;
    }


}