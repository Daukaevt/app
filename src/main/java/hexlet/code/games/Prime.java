package hexlet.code.games;

import java.util.Random;

import static hexlet.code.CONST.*;

public class Prime {
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
    public static String getRndParams() {
        Random rnd = new Random(); //instance of random class
        return String.valueOf(rnd.nextInt(0, MAXRND));
    }

    /**
     * check if user input answer is correct.
     * @param quest if prime question params.
     * @param inputAnswer user input answer.
     * @return get correct/incorrect answer.
     */
    public static String checkAnswer(
            final String quest, final String inputAnswer) {
        boolean prime = true;
        int intQuest = Integer.parseInt(quest);
        for (int i = 2; i < intQuest; i++) {
            if (intQuest % i == 0) {
                prime = false;
            }
        }
        return prime && inputAnswer.equals("yes")
                || !prime && inputAnswer.equals("no") ? CORRECT : INCORRECT;
    }
}
