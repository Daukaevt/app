package hexlet.code.games;


import java.util.Random;

import static hexlet.code.CONST.*;

public class Progression {

    /**
     * game missing number question.
     * @return missing number question string.
     */
    public static String askMissingNumber() {
        return "What number is missing in the progression?";
    }

    /**
     * missing number question params.
     * @return missing number question params string.
     */
    public static String findMissingNumberInRange() {
        Random rnd = new Random(); //instance of random class
        int firstRangeNum = rnd.nextInt(0, MAXRND);
        int stepRange = rnd.nextInt(1, MAXSTEP);
        int indexedRange = rnd.nextInt(0, PROGRESSION_LENGTH);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            str = i == indexedRange
                    ? str.append(" ..") : str.append(" ").append(firstRangeNum);
            firstRangeNum += stepRange;
        }
        return str.toString();

    }

    /**
     * check if user input answer is correct.
     * @param quest find Missing Number question params.
     * @param inputAnswer user input answer.
     * @return correct/incorrect string.
     */
    public static String checkAnswer(
            final String quest, final String inputAnswer) {
        var string = quest.split(" ");
        var answerInt = 0;
        for (int i = 1; i < string.length; i++) {
            if (string[i].equals("..") && i > 2) {
                /*
                * second int in progression.
                 */
                var int2 = Integer.parseInt(string[2]);
                /*
                 * first int in progression.
                 */
                var int1 = Integer.parseInt(string[1]);
                var stepProgression = int2 - int1;
                answerInt = Integer.parseInt(string[i - 1]) + stepProgression;
            } else if (string[i].equals("..") && i <= 2) {
                var stepProgression = Integer
                        .parseInt(string[PROGRESSION_LENGTH])
                        - Integer
                        .parseInt(string[PROGRESSION_LENGTH - 1]);
                answerInt = Integer.parseInt(string[i + 1]) - stepProgression;
            }
        }
        String incorrectStr = "'" + inputAnswer
                + WRONG + answerInt + "'";
        if (String.valueOf(answerInt).equals(inputAnswer)) {
            return CORRECT;
        }
        return incorrectStr;
    }
}
