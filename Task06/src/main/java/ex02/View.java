package ex02;

import java.io.IOException;
/** Product
 * (design template
 *Factory Method)<br>
 * Interface "fabricable"
 * objects<br>
 * Declares methods
 * object display
 * @author xone
 * @version1.0
 */
public interface View {
    /** Displays the title */
    public void viewHeader();
    /** Displays the main part */
    public void viewBody();
    /** Displays the end */
    public void viewFooter();
    /** Displays the entire object */
    public void viewShow();
    /** Performs initialization */
    public void viewInit();
    /** Save data for later recovery */
    public void viewSave() throws IOException;
    /** Restore previously saved data */
    public void viewRestore() throws Exception;
}