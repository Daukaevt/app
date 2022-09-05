package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        userDialog();
    }

    private static void userDialog() {
        int intScan;
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        Scanner scan = new Scanner(System.in);
        var strScan = scan.next();
        try {
            intScan = Integer.parseInt(strScan);
        } catch (NumberFormatException ex) {
            intScan = 0; // to exit
        }
        System.out.println("Your choice: " + intScan);

        switch (intScan) {
            case CONST.EVEN, CONST.CALC, CONST.GCD,
                    CONST.PROGRESSION, CONST.PRIME ->
                        Engine.makeDialog(intScan);
            case CONST.GREET -> Cli.haveName();
            default -> {
            }
        }
        scan.close();
    }
}
