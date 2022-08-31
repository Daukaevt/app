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
     */
    public static void makeDialog() {
        //Engine.sayHello();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!\n"
                + "May I have your name?");
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(Calc.askResultString()); // to add Even.String
        for (int i = 0; i < MAXGAMES; i++) {
            var quest = Calc.makeExpression();
            System.out.println("Question:  " + quest); // to add Even.intRandom
            if (sc.hasNextLine()) {
                System.out.print("Your answer: ");
                String inputAnswer = sc.next();
                var check = Calc.checkAnswer(quest, inputAnswer);
                if (CORRECT.equals(check)) {
                    count++;
                }
                System.out.println(check);
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

    private static int intRandom() {
        Random rnd = new Random(); //instance of random class
        return rnd.nextInt(0, MAXRND);
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
