/** ConcreteCreator
 * (design template
 *Factory Method)<br>
 * Declares a method,
 * "fabricating" objects
 * @author xone
 * @version1.0
 * @seeViewable
 * @seeViewableResult#getView()
 */
public class ViewableResult implements Viewable {
    /** Creates a viewable {@linkplain ViewResult} */
    @Override
    public View getView() {
        return new ViewResult();
    }
}