package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

import static hexlet.code.games.Even.GAMES;
import static hexlet.code.games.Even.MAXRND;

public class Prime {
    /**
     * init correct answers count.
     */
    private static int count = 0;
    /**
     * correct string const.
     */
    public static final String CORRECT = "Correct!";
    /**
     * start Prime game logic.
     * @param scName username.
     */
    public static void play(final String scName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(askIfPrime());
        for (int i = 0; i < GAMES; i++) {
            var quest = makeExpression();
            Engine.makeQuest(quest);
            String userInput =  scanner.next();
            String correct = checkUserInput(quest, userInput, scName);
            Engine.checkInputAnswer(correct);
        }
        if (count == GAMES) {
            Engine.congratulate(scName);
        }
        scanner.close();
    }
    /**
     * ask Prime game question.
     * @return if prime question string.
     */
    public static String askIfPrime() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     * get params for the game question (ask if prime).
     * @return rnd int to string.
     */
    public static String makeExpression() {
        var rnd = Engine.random(MAXRND);
        return String.valueOf(rnd);
    }

    /**
     * check if user input answer is correct.
     *
     * @param quest       if prime question params.
     * @param inputAnswer user input answer.
     * @param scName username.
     * @return get correct/incorrect answer.
     */
    public static String checkUserInput(
            final String quest, final String inputAnswer, final String scName) {
        boolean prime = true;
        var correctAnswer = "yes";
        int intQuest = Integer.parseInt(quest);
        for (int i = 2; i < intQuest; i++) {
            if (intQuest % i == 0) {
                correctAnswer = "no";
                prime = false;
                break;
            }
        }
        if (prime && inputAnswer.equals("yes")
                || !prime && inputAnswer.equals("no")) {
            count++;
            return CORRECT;
        }
        return  "'" + inputAnswer
                + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'.\nLet's try again, " + scName;
    }
}
