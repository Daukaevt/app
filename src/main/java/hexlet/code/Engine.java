package hexlet.code;



import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Objects;
import java.util.Scanner;

import static hexlet.code.CONST.*;

public class Engine {
    /**
     * init current answers count.
     */
    private static int count = 0;

    /**
     * Even game interactive dialog.
     * @param inp user game choice.
     */
    @SuppressWarnings("checkstyle:AvoidNestedBlocks")
    public static void makeDialog(final int inp) {
        //Engine.sayHello();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!\n"
                + "May I have your name?");
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        var quest = "";
        for (int i = 0; i < MAXGAMES; i++) {
            switch (inp) {
                case EVEN:
                    /*
                      init game rules question.
                     */
                    String gameQuestion = Even.askIfEvenString();
                    quest = String.valueOf(Even.intRandom());
                    makeQuestion(i, gameQuestion, quest);
                    if (sc.hasNextLine()) {
                        String inputAnswer = sc.next();
                        var check = Even.checkEven(
                                Integer.parseInt(quest), inputAnswer);
                        validation(check, "");
                    }
                    break;
                case CALC:
                    gameQuestion = Calc.askResultString();
                    quest = Calc.makeExpression();
                    makeQuestion(i, gameQuestion, quest);
                    if (sc.hasNextLine()) {
                        System.out.print("Your answer: "); // diferent from even
                        String inputAnswer = sc.next();
                        var check = Calc.checkAnswer(quest, inputAnswer);
                        validation(check, name);
                    }
                    break;
                default: throw new IllegalStateException(
                        "Unexpected value from Engine");
            }
        }
        congratulate(name);
        sc.close();
    }

    /**
     * Validate if answer is correct.
     * @param check if correct string.
     * @param name user name string.
     */
    private static void validation(String check, final String name) {
        if (CORRECT.equals(check)) {
            count++;
        } else {
            if (!Objects.equals(name, "")) {
                check += TRYAGAIN + name + EXCLAMATION_POINT;
            }
        }
        System.out.println(check);
    }

    /**
     * ask uniq game question.
     * @param i game loop number int.
     * @param gameQuestion uniq game question string.
     * @param quest params of game question.
     */
    private static void makeQuestion(
            final int i, final String gameQuestion, final String quest) {
        if (i == 0) {
            System.out.println(gameQuestion);
        }
        System.out.println("Question:  " + quest);
    }

    /**
     * game points counter.
     * @param name user name string.
     */
    private static void congratulate(final String name) {
        if (count == WINCOUNT) {
            System.out.println(
                    "Congratulations, " + name + "!");
        }
    }

}
