import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * The Main class implements a menu-driven application that allows the user to interact with a View object
 * and perform various actions such as viewing the current state, generating a new state, saving the current state,
 * and restoring the last saved state.
 */
public class Main {
    private View view;
    /**
     * Constructs a Main object with a View object.
     * @param view the View object used in this application
     */
    public Main(View view) {
        this.view = view;
    }
    /**
     * Displays a menu and waits for the user to enter a command. Executes the corresponding action based on the user's input.
     * Valid commands are: 'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore.
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
                    view.viewShow();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        view.viewShow();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }
    /**
     * The entry point of the application.
     * Creates a new instance of the Main class and calls its menu method.
     * @param args The command-line arguments, which are not used.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}