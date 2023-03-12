package ex04;

import ex02.Item2d;
import ex02.View;
import ex02.ViewResult;
/** Console command
 * Change item;
 * command template
 * @author xone
 * @version1.0
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {
    /** An object that implements the {@linkplain View} interface;
     * serves a collection of objects {@linkplain ex02.Item2d}
     */
    private View view;
    /** Returns the field {@linkplain ChangeConsoleCommand#view}
     * @return value {@linkplain ChangeConsoleCommand#view}
     */
    public View getView() {
        return view;
    }
    /** Sets the {@linkplain ChangeConsoleCommand#view} field
     * @param view value for {@linkplain ChangeConsoleCommand#view}
     * @return new value {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
    }
    /** Initializes the field {@linkplain ChangeConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (Item2d item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}
