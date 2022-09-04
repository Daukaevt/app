package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.CONST.*;

/**
 *  2 - Even game class.
 */
public class Even {
    /**
     * init correct answers count.
     */
    private static int count = 0;

    /**
     * Even game if even question.
     * @return if even question String.
     */
    public static String askIfEvenString() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static int intRandom() {
        Random rnd = new Random(); //instance of random class
        return rnd.nextInt(0, MAXRND);
    }

    /**
     * checking if random number even or not.
     * @param nextInt random number
     * @param answer yes/no user answer
     * @return returns correct string from CONST.
     */
    public static String checkEven(final int nextInt, final String answer) {
        var num = nextInt % 2 == 0;
        if (answer.equals("yes") && num || answer.equals("no") && !num) {
            //count++;
            return CORRECT;
        }
        return INCORRECT;
    }
}
