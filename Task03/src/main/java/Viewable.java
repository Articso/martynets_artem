/** Creator
 * (design template
 *Factory Method)<br>
 * Declares a method,
 * "fabricating" objects
 * @author xone
 * @version1.0
 * @seeViewable#getView()
 */
public interface Viewable {
    /** Creates an object that implements {@linkplain View} */
    public View getView();
}