package ex04;

import ex02.View;
import ex03.ViewableTable;
/** Forms and displays
 * menu; implements the pattern
 *Singleton
 * @author xone
 * @version1.0
 */
public class Application {
    /** Reference to an instance of the Application class; singleton template
     * @see Application
     */
    private static Application instance = new Application();
    /** Private constructor; singleton template
     * @see Application
     */
    private Application() {}
    /** Returns a reference to an instance of the Application class;
     * singleton pattern
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }
    /** An object that implements the {@linkplain View} interface;
     * maintains a collection of objects {@linkplain ex02.Item2d};
     * initialized with Factory Method
     */
    private View view = new ViewableTable().getView();
    /** Class object {@linkplain Menu};
     * macro command (Command template)
     */
    private Menu menu = new Menu();
    /** Handling user commands
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}