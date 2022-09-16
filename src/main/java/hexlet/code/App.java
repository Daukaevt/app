package hexlet.code;

import java.util.Scanner;

public class App {
    /**
     * max game id.
     */
    private static final int MAXID = 6;

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
        if (0 < intScan && intScan <= MAXID) {
            Cli.haveName(intScan);
        }
        scan.close();
    }
}
