package ex04;

/** Compute and display
 * results; contains implementation
 * static method main()
 * @author xone
 *@version4.0
 * @see Main#main
 */
public class Main {
    /** Executed when the program starts;
     * calls the {@linkplain Application#run()} method
     * @param args program launch parameters
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}