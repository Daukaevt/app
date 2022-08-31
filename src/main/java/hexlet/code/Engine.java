package hexlet.code;


import java.util.Random;
import java.util.Scanner;

import static hexlet.code.CONST.*;

public class Engine {
    /**
     * init current answers count.
     */
    private static int count = 0;
    /**
     * init game rules question.
     */
    private static String gameQuestion = "";
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
                    gameQuestion = Even.askIfEvenString();
                    if (i == 0) {
                        System.out.println(gameQuestion); // to add Even.String
                    }
                    quest = String.valueOf(Even.intRandom());
                    System.out.println("Question:  " + quest); // to add Even.intRandom
                    if (sc.hasNextLine()) {
                        String inputAnswer = sc.next();
                        var check = Even.checkEven(Integer.parseInt(quest), inputAnswer);
                        if (CORRECT.equals(check)) {
                            count++;
                        }
                        System.out.println(check);
                    }
                    break;
                case CALC:
                    gameQuestion = Calc.askResultString();
                    if (i == 0) {
                        System.out.println(gameQuestion); // to add Even.String
                    }
                    quest = Calc.makeExpression();
                    System.out.println("Question:  " + quest); // to add Even.intRandom
                    if (sc.hasNextLine()) {
                        System.out.print("Your answer: "); // diferent from even
                        String inputAnswer = sc.next();
                        var check = Calc.checkAnswer(quest, inputAnswer);
                        if (CORRECT.equals(check)) {
                            count++;
                        } else {
                            check += "\nLet's try again, " + name + "!";
                        }
                        System.out.println(check);
                    }
                    break;
                default: throw new IllegalStateException(
                        "Unexpected value from Engine");
            }
        }
        congratulate(name);
        sc.close();
    }

    private static void congratulate(final String name) {
        if (count == WINCOUNT) {
            System.out.println(
                    "Congratulations, " + name + "!");
        }
    }

    /**
     * checking if random number even or not.
     * @param nextInt random number
     * @param answer yes/no user answer
     * @return returns correct string from CONST.
     */
    public static String checkEven(final int nextInt, final String answer) {
        var num = nextInt % 2 == 0;
        if (answer.equals("yes") && num || answer.equals("no") && !num) {
            count++;
            return CORRECT;
        }
        return INCORRECT;
    }

}
