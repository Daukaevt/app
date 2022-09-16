package hexlet.code.games;

import hexlet.code.Engine;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.Scanner;
import static hexlet.code.games.Even.GAMES;
import static hexlet.code.games.Even.MAXRND;

public class Calc {
    /**
     * init correct answers count.
     */
    private static int count = 0;
    /**
     * max games quantity.
     */
    public static final int MAXMATHOPERATIONS = 3;

    /**
     * start Calc game logic.
     * @param scName username.
     */
    public static void play(final String scName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(askResultString());
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
     * Calc game result question.
     * @return result question String.
     */
    public static String askResultString() {
        return "What is the result of the expression?";
    }
    /**
     * Calc game random logic.
     * @return question string.
     */
    public static String makeExpression() {
        int firstRND = Engine.random(MAXRND);
        int secondRND = Engine.random(MAXRND);
        int mathOperation = Engine.random(MAXMATHOPERATIONS);
        var mathOperator = switch (mathOperation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        };
        return firstRND + mathOperator + secondRND;
    }
    /**
     * Calc game main logic.
     * @param quest game quest expression.
     * @param inputAnswer user input answer.
     * @return correct/incorrect String.
     */
    public static String checkUserInput(
            final String quest, final String inputAnswer) {
        Expression expr = new Expression(quest);
        double d = expr.calculate();
        int number;
        String incorrectStr = "'" + inputAnswer
                + "' is wrong answer ;(. Correct answer was '" + (int) d + "'";
        try {
            number = Integer.parseInt(inputAnswer);
        } catch (NumberFormatException ex) {
            return incorrectStr;
            //ex.printStackTrace();
        }
        if ((double) number == d) {
            count++;
            return "Correct!";
        }
        return incorrectStr;
    }


}
