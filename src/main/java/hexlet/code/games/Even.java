package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Even {
    /**
     * init correct answers count.
     */
    private static int count = 0;
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;

    /**
     * start Even game logic.
     * @param scName username.
     */
    public static void play(final String scName) {
        Scanner scanner = new Scanner(System.in);
        String question =
                "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(question);
        for (int i = 0; i < GAMES; i++) {
            int nextRND = Engine.random(MAXRND);
            Engine.makeQuest(Integer.toString(nextRND));
            String userInput =  scanner.next();
            String correct = checkUserInput(nextRND, userInput, scName);
            Engine.checkInputAnswer(correct);
        }
        if (count == GAMES) {
            Engine.congratulate(scName);
        }
        scanner.close();
    }

    private static String checkUserInput(
            final int nextRND, final String userInput, final String scName) {
        var correctAnswer = correctAnswer(nextRND);
        if (userInput.equals(correctAnswer)) {
            count++;
            return "Correct!";
        }
        return "'" + userInput
                + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'.\nLet's try again, " + scName;
    }
    private static String correctAnswer(final int nextRND) {
        return nextRND % 2 == 0 ? "yes" : "no";
    }



}
