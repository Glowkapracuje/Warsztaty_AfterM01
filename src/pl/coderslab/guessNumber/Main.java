package pl.coderslab.guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String HELLO_TEXT = "Hello! Let's start a game!";
    private static final String GUESS_NUMBER = "Guess a number..";
    private static final String ALLERT_TOO_SMALL = "Your number is too small!";
    private static final String ALLERT_TOO_BIG = "Your number is too big!";
    private static final String ALLERT_NO_NUMBER = "Type a number, not a letter!";
    private static final String WIN_TEXT = "You won! Let's play again! :)";
    private static final String TRY_AGAIN = "Try again!";


    public static void main(String[] args){

//        comparisonEngine();

    }



    //    DRAW A RANDOM NUMBER
    public static int randGenerator(){

        int range = 100;
        Random generate = new Random();
        return generate.nextInt(range)+1; //+1 because start with 1, not 0.

    }




}