package hexlet.code;

import java.util.Scanner;

public class Even {
    private static String correct = "Correct!";
    private static String inCorrect = "Incorrect!";
    static int count = 0;

    public static void askEvenOrNot() {
        final int firstInt = 15;
        final int secondInt = 6;
        final int thirdInt = 7;
        final int winCount = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!\n"
                + "May I have your name?");
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(
                "Answer 'yes' if the number is even, otherwise answer 'no'.\n"
                + "Question:  " + firstInt);
        System.out.println(checkEven(firstInt, sc.next()));
        System.out.println("Question:  " + secondInt);
        System.out.println(checkEven(secondInt, sc.next()));
        System.out.println("Question:  " + thirdInt);
        System.out.println(checkEven(thirdInt, sc.next()));
        if (count == winCount) {
            System.out.println("Congratulations, " + name + "!");
        }
        sc.close();
    }

    public static String checkEven(final int nextInt, final String answer) {
        System.out.println("Question:  " + nextInt);
        var num = nextInt % 2 == 0;
        if (answer.equals("yes") && num || answer.equals("no") && !num) {
            count++;
            return correct;
        }
        return inCorrect;
    }
}
