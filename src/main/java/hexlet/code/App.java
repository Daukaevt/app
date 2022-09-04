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
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit""");
        Scanner scan = new Scanner(System.in);
        var intScan = scan.nextInt();
        System.out.println("Your choice: " + intScan);

        switch (intScan) {
            case CONST.EVEN:
                case CONST.CALC:
                    case CONST.GCD:
                        case CONST.PROGRESSION: Engine.makeDialog(intScan);
                break;
            case CONST.GREET: Cli.haveName();
                break;
            default:
                //
        }
        scan.close();
    }
}
