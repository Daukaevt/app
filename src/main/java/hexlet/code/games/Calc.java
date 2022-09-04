package hexlet.code.games;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.syntaxchecker.ParseException;
import java.util.Random;
import static hexlet.code.CONST.*;

public class Calc {
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
        Random rnd = new Random(); //instance of random class
        int firstRND = rnd.nextInt(0, MAXRND);
        int secondRND = rnd.nextInt(0, MAXRND);
        int mathOperation = rnd.nextInt(0, MAXMATHOPERATIONS);
        var mathOprtr = switch (mathOperation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        };
        return firstRND + mathOprtr + secondRND;
    }
    /**
     * Calc game main logic.
     * @param quest
     * @param inputAnswer
     * @return correct/incorrect String.
     */
    public static String checkAnswer(
            final String quest, final String inputAnswer) {
        Expression expr = new Expression(quest);
        double d = expr.calculate();
        int number = 0;
        String incorrectStr = "'" + inputAnswer
                + "' is wrong answer ;(. Correct answer was '" + (int) d + "'";
        try {
            number = Integer.parseInt(inputAnswer);
        } catch (NumberFormatException ex) {
            return incorrectStr;
            //ex.printStackTrace();
        }
        if ((double) number == d) {
            return CORRECT;
        }
        return incorrectStr;
    }

}
