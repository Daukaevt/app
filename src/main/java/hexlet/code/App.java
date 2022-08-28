package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit""");
        Scanner scan = new Scanner(System.in);
        var strScan = scan.next();
        System.out.println("Your choice: " + strScan.toString());
        switch (strScan) {
            case "1": Cli.haveName(); break;
            case "2": Even.askEvenOrNot(); break;
            default: break;
        }
        scan.close();
    }
}
