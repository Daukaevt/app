package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void haveName() {
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, "+sc.next()+"!");
        sc.close();
    }
}
