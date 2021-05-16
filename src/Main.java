import java.util.Scanner;
import javaClasses.userInput;

class Main {

    public static void showTitle() {
        System.out.println(" /$$$$$$$$     /$$$$$                      /$$$$$ /$$$$$$$  /$$$$$$$$        /$$       /$$");
        System.out.println("| $$__   $$   |__  $$                     |__  $$| $$__  $$|__  $$__/       | $$      | $$");
        System.out.println("| $$  \\  $$      | $$                        | $$| $$  \\ $$   | $$  /$$$$$$ | $$$$$$$ | $$  /$$$$$");
        System.out.println("| $$$$$$$$       | $$      /$$$$$$           | $$| $$$$$$$    | $$ |____  $$| $$__  $$| $$ /$$__ $$");
        System.out.println("| $$__   $$ /$$  | $$     |______/      /$$  | $$| $$         | $$  /$$$$$$$| $$  \\ $$| $$| $$$$$$$");
        System.out.println("| $$  \\  $$| $$  | $$                  | $$  | $$| $$         | $$ /$$__  $$| $$  | $$| $$| $$____/");
        System.out.println("| $$$$$$$$/|  $$$$$$/                  |  $$$$$$/| $$         | $$|  $$$$$$$| $$$$$$$/| $$|  $$$$$$");
        System.out.println("|________/  \\______/\t\t\t\t    \\______/ |__/         |__/ \\_______/|_______/ |__/ \\______/");
    }

    public static int showMenu() {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Start The Simulation!");
            System.out.println("2. Close App");
            System.out.print("Choice >> ");
            try {
                choice = scan.nextInt();
            } catch ( Exception ex ) {
                choice = -1;
            }
            scan.nextLine();
        } while ( choice != 1 && choice != 2 );
        return choice;
    }

    public static void simulate() {
        Scanner scan = new Scanner(System.in);
        int first, second;
        do {
            System.out.print("Input the first number [1-100](inclusive): ");
            try {
                first = scan.nextInt();
            } catch ( Exception ex ) {
                first = -1;
            }
            scan.nextLine();
        } while ( first < 1 || first > 100 );
        do {
            System.out.print("Input the second number [1-100](inclusive): ");
            try {
                second = scan.nextInt();
            } catch ( Exception ex ) {
                second = -1;
            }
            scan.nextLine();
        } while ( second < 1 || second > 100 );

        userInput stuff = new userInput(first, second);
        printTable(stuff);
        scan.nextLine();

        printOps(stuff);
        scan.nextLine();

        boolean p1 = false, p2 = false;
        boolean trigger = true;
        while ( trigger ) {
            trigger = false;
            System.out.print("Give me value for p1 [true | false]:  ");
            try {
                p1 = scan.nextBoolean();
            } catch ( Exception ex ) {
                trigger = true;
            }
            scan.nextLine();
        }
        trigger = true;
        while ( trigger ) {
            trigger = false;
            System.out.print("Give me value for p2 [true | false]:  ");
            try {
                p2 = scan.nextBoolean();
            } catch ( Exception ex ) {
                trigger = true;
            }
            scan.nextLine();
        }

        printLogic( p1, p2 );
        scan.nextLine();
    }

    public static void printDivider( int length ) {
        System.out.print("+");
        for ( int i = 0 ; i < length-2 ; i++ ) System.out.print("=");
        System.out.println("+");
    }

    public static void printLogic ( boolean p1, boolean p2 ) {
        printDivider(69);
        System.out.printf("+%-67s+\n", "Logical Table");
        printDivider(69);
        char s1 = p1 ? 'T' : 'F';
        char s2 = p2 ? 'T' : 'F';
        System.out.printf("+ %s = %c , %s = %c %-50s+\n", "P1", s1, "P2", s2, " ");
        printDivider(69);
        System.out.printf("+ %-14s | %-14s | %-14s | %-14s +\n", "!P1", "!P2", "&&", "||" );
        printDivider(69);
        System.out.printf("+ %-14s | %-14s | %-14s | %-14s +\n", p1 ? "false" : "true", p2 ? "false" : "true", p1 && p2 ? "true" : "false" , p1 || p2 ? "true" : "false" );
        printDivider(69);
        System.out.println("Press enter to proceed...");
    }

    public static void printTable ( userInput answer ) {
        printDivider(126);
        System.out.printf("+ %-18s | %-18s | %-18s | %-18s | %-38s +\n", "+ (String type)", "(Character Type)", "* (Integer type)", "/ (Floating Type", "input1 == input2 (Boolean Type)");
        printDivider(126);
        System.out.printf("+ %-18s | %-18s | %-18d | %-18.3f | %-38s +\n", answer.getPlus(), answer.getFirstChar() + " " + answer.getSecondChar(),
                answer.getMultiplication(), answer.getDivision(), answer.isSame() ? "True" : "False" );
        printDivider(126);
        System.out.println("Press enter to proceed...");
    }

    public static void printOps ( userInput answer ) {
        printDivider(56);
        System.out.printf("+%-54s+\n", "Data Type : Integer");
        printDivider(56);
        System.out.printf("+ %-8s | %-8s | %-8s | %-8s | %-8s +\n", "+", "-", "*", "/", "%");
        printDivider(56);
        System.out.printf("+ %-8d | %-8d | %-8d | %-8d | %-8d +\n",
                answer.getAddition(), answer.getSubtraction(), answer.getMultiplication(), answer.getIntegerDivision(), answer.getRemainder());
        printDivider(56);
        System.out.println("Press enter to proceed...");
    }

    public static void quit() {
        System.out.println("Thank you for using the apps!!");
    }

    public static void main ( String[] args ) {
        while ( true ) {
            showTitle();
            int choice;
            choice = showMenu();
            System.out.println(choice);
            if ( choice == 1 ) {
                simulate();
            } else {
                quit();
                break;
            }
        }
    }
}
