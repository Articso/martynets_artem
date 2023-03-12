package ex04;

import ex02.View;
/** Console command
 * Generate;
 * command template
 * @author xone
 * @version1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** An object that implements the {@linkplain View} interface;
     * serves a collection of objects {@linkplain ex02.Item2d}
     */
    private View view;
    /** Initialize field {@linkplain GenerateConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'g';
    }
    @Override
    public String toString() {
        return "'g'enerate";
    }
    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}
