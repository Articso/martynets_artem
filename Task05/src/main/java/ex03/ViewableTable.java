package ex03;

import ex02.ViewableResult;
import ex02.View;
/** ConcreteCreator
 * (design template
 *Factory Method)<br>
 * Declares a method,
 * "fabricating" objects
 * @author xone
 * @version1.0
 * @seeViewableResult
 * @seeViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /** Creates a viewable {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}