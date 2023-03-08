import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * This class implements a simple command line interface for interacting with a calculator.
 * The user can enter various commands to generate a random input, view the current result,
 * save the current result, and restore the last saved result.
 */
public class Main {
    private Calc calc = new Calc();
    /**
     * Displays a menu of available commands and prompts the user to enter a command.
     * Depending on the input, the corresponding method in the Calc class is called.
     * The menu is displayed until the user enters 'q' to quit.
     */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    calc.show();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    calc.init(Math.random() * 10000);
                    calc.show();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }

    /**
     * Main method that creates a new instance of the class and invokes the menu method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}