package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;
import static hexlet.code.games.Even.GAMES;

public class GCD {
    /**
     * init correct answers count.
     */
    private static int count = 0;
    /**
     * correct string const.
     */
    public static final String CORRECT = "Correct!";
    /**
     * wrong string const.
     */
    public static final String WRONG =
            "' is wrong answer ;(. Correct answer was '";
    /**
     * start GCD game logic.
     * @param scName username.
     */
    public static void play(final String scName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(askFindGCD());
        for (int i = 0; i < GAMES; i++) {
            var quest = makeExpression();
            Engine.makeQuest(quest);
            String userInput =  scanner.next();
            String correct = checkUserInput(quest, userInput);
            Engine.checkInputAnswer(correct);
        }
        if (count == GAMES) {
            Engine.congratulate(scName);
        }
        scanner.close();
    }
    /**
     * find gcd question params.
     * @return params string.
     */
    private static String makeExpression() {
        Random rnd = new Random(); //instance of random class
        int firstRND = rnd.nextInt(0, Even.MAXRND);
        int secondRND = rnd.nextInt(0, Even.MAXRND);
        return firstRND + " " + secondRND;
    }

    /**
     * GCD game find gcd question.
     * @return find gcd string.
     */
    public static String askFindGCD() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * check if user input answer is correct.
     * @param quest find gcd question params.
     * @param inputAnswer user input answer.
     * @return correct/incorrect string.
     */
    public static String checkUserInput(
            final String quest, final String inputAnswer) {
        String[] str = quest.split(" ");
        var firstInt = Integer.parseInt(str[0]);
        var secondInt = Integer.parseInt(str[1]);
        int[] arr = {firstInt, secondInt};
        Arrays.sort(arr);
        var remainder = arr[0];
        do {
            remainder = arr[1] % arr[0];
            arr[1] = arr[0];
            arr[0] = remainder;
        } while (remainder != 0);
        String incorrectStr = "'" + inputAnswer
                + WRONG + arr[1] + "'";
        if (String.valueOf(arr[1]).equals(inputAnswer)) {
            count++;
            return CORRECT;
        }
        return incorrectStr;
    }
}
