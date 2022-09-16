package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.games.Even.GAMES;

public class Progression {
    /**
     * init correct answers count.
     */
    private static int count = 0;
    /**
     * max random progression step.
     */
    public static final int MAXSTEP = 10;
    /**
     * max progression line length.
     */
    public static final int PROGRESSION_LENGTH = 10;
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
     * start Progression game logic.
     * @param scName username.
     */
    public static void play(final String scName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(askMissingNumber());
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
    public static String makeExpression() {
        Random rnd = new Random(); //instance of random class
        int firstRangeNum = rnd.nextInt(0, Even.MAXRND);
        int stepRange = rnd.nextInt(1, MAXSTEP);
        int indexedRange = rnd.nextInt(0, PROGRESSION_LENGTH);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == indexedRange) {
                stringBuilder.append(" ..");
            } else {
                stringBuilder.append(" ").append(firstRangeNum);
            }
            firstRangeNum += stepRange;
        }
        return stringBuilder.toString();

    }

    /**
     * check if user input answer is correct.
     * @param quest find Missing Number question params.
     * @param inputAnswer user input answer.
     * @return correct/incorrect string.
     */
    public static String checkUserInput(
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
            count++;
            return CORRECT;
        }
        return incorrectStr;
    }

}
