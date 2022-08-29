package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        userDialog();
    }

    private static void userDialog() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit""");
        Scanner scan = new Scanner(System.in);
        var strScan = scan.next();
        System.out.println("Your choice: " + strScan);
        switch (strScan) {
            case "1" -> Cli.haveName();
            case "2" -> Even.askEvenOrNot();
            default -> {
            }
        }
        scan.close();
    }
}
