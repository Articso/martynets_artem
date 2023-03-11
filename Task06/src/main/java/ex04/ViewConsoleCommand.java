package ex04;

import ex02.View;
/** Console command
 *View;
 * command template
 * @author xone
 * @version1.0
 */
public class ViewConsoleCommand implements ConsoleCommand {
    /** An object that implements the {@linkplain View} interface;
     * serves a collection of objects {@linkplain ex02.Item2d}
     */
    private View view;
    /** Initializes the field {@linkplain SaveConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'v';
    }
    @Override
    public String toString() {
        return "'v'iew";
    }
    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}
