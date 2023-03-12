package ex04;

import java.io.IOException;
import ex02.View;
/** Console command
 * save;
 * command template
 * @author xone
 * @version1.0
 */
public class SaveConsoleCommand implements ConsoleCommand {
    /** An object that implements the {@linkplain View} interface;
     * serves a collection of objects {@linkplain ex02.Item2d}
     */
    private View view;
    /** Initializes the field {@linkplain SaveConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 's';
    }
    @Override
    public String toString() {
        return "'s'ave";
    }
    @Override
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
