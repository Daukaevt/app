package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;


public class Cli {
    /**
     * Even game id.
     */
    private static final int EVEN = 2;
    /**
     * Calc game id.
     */
    public static final int CALC = 3;
    /**
     * GCD game id.
     */
    public static final int GCD = 4;
    /**
     * Progression game id.
     */
    public static final int PROGRESSION = 5;
    /**
     * Progression game id.
     */
    public static final int PRIME = 6;
    /**
     * System.in scanner per user dialog game.
     * @param intScan game id.
     */
    public static void haveName(final int intScan) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        var scName = sc.next();
        System.out.println("Hello, " + scName + "!");
        switch (intScan) {
            case EVEN -> Even.play(scName);
            case CALC -> Calc.play(scName);
            case GCD -> hexlet.code.games.GCD.play(scName);
            case PROGRESSION -> Progression.play(scName);
            case PRIME -> Prime.play(scName);
            default -> {
            }
        }
        sc.close();
    }
}
