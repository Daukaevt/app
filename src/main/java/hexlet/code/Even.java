package hexlet.code;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.CONST.*;

/**
 *  2 - Even game class.
 */
public class Even {
    /**
     * init current answers count.
     */
    private static int count = 0;
    /**
     * Even game intaractive dialog.
     */
    public static void askEvenOrNot() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!\n"
                + "May I have your name?");
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(
                "Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < MAXGAMES; i++) {
            var intRandom = intRandom();
            System.out.println("Question:  " + intRandom);
            System.out.println(checkEven(intRandom, sc.next()));
        }
        if (count == WINCOUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
        sc.close();
    }

    private static int intRandom() {
        Random rnd = new Random(); //instance of random class
        int intRandom = rnd.nextInt(0, MAXRND);
        return intRandom;
    }

    /**
     * checking if random number even or not.
     * @param nextInt random number
     * @param answer yes/no user answer
     * @return returns correct string from CONST.
     */
    public static String checkEven(final int nextInt, final String answer) {
        System.out.println("Question:  " + nextInt);
        var num = nextInt % 2 == 0;
        if (answer.equals("yes") && num || answer.equals("no") && !num) {
            count++;
            return CORRECT;
        }
        return INCORRECT;
    }
}
