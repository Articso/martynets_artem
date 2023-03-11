package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.Menu;
import ex04.ViewConsoleCommand;
/** Compute and display
 * results; contains an implementation
 * static method main()
 * @author xone
 * @version 5.0
 * @see Main#main
 */
public class Main {
    /** An object that implements the {@linkplain View} interface;
     * maintains a collection of objects {@linkplain ex02.Item2d};
     * initialized with Factory Method
     */
    private View view = new ViewableResult().getView();
    /** Class object {@linkplain Menu};
     * macro command (Command template)
     */
    private Menu menu = new Menu();
    /** Handling user commands */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }
    /** Executed when the program starts
     * @param args program launch parameters
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}