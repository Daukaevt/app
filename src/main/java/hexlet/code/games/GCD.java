package hexlet.code.games;

import java.util.Arrays;

import java.util.Random;

import static hexlet.code.CONST.*;

public class GCD {

    /**
     * GCD game find gcd question.
     * @return find gcd string.
     */
    public static String askFindGCD() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * find gcd question params.
     * @return params string.
     */
    public static String findGCD() {
        Random rnd = new Random(); //instance of random class
        int firstRND = rnd.nextInt(0, MAXRND);
        int secondRND = rnd.nextInt(0, MAXRND);
        return firstRND + " " + secondRND;
    }

    /**
     * check if user input answer is correct.
     * @param quest find gcd question params.
     * @param inputAnswer user input answer.
     * @return correct/incorrect string.
     */
    public static String checkAnswer(
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
            return CORRECT;
        }
        return incorrectStr;
    }
}
