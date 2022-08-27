package hexlet.code;

import java.util.Scanner;


public class Cli {

    /**
     * System.in scanner per user dialog game.
     */
    public static void haveName() {
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, " + sc.next() + "!");
        sc.close();
    }
}
