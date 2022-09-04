package hexlet.code.games;

import java.util.Random;

import static hexlet.code.CONST.MAXRND;

public class Progression {
    public static String askMissingNumber() {
        return "What number is missing in the progression?";
    }

    public static String findMissingNumberInRange() {
        Random rnd = new Random(); //instance of random class
        int firstRangeNum = rnd.nextInt(0, MAXRND);
        int stepRange = rnd.nextInt(1, 10);
        int indexedRange = rnd.nextInt(0, 10);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str = i == indexedRange
                    ? str.append(" ..") : str.append(" " + firstRangeNum);
            firstRangeNum += stepRange;
        }
        return str.toString();

    }
}
