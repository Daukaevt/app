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

}
