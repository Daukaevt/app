package hexlet.code;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.syntaxchecker.ParseException;

import java.util.Random;

import static hexlet.code.CONST.*;

public class Calc {
    public static String askResultString() {
        return "What is the result of the expression?";
    }

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

    public static String checkAnswer(
            final String quest, final String inputAnswer) {
        Expression expr = new Expression(quest);
        double d = expr.calculate();
        int number = 0;
        try {
            number = Integer.parseInt(inputAnswer);
        } catch (NumberFormatException ex) {
            return INCORRECT;
            //ex.printStackTrace();
        }
        if ((double) number == d) {
            return CORRECT;
        }
        return INCORRECT;
    }

}
