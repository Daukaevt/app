package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                0 - Exit""");
        Scanner scan = new Scanner(System.in);
        var strScan = scan.next();
        System.out.println("Your choice: " + strScan.toString());
        if (strScan.equals("1")) {
            Cli.haveName();
        }
        scan.close();
    }
}
