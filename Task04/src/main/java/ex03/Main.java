package ex03;

import ex02.View;
/** Calculate and display results<br>
 * Contains the implementation of the static method main()
 * @author xone
 *@version3.0
 * @see Main#main
 */
public class Main extends ex02.Main {
    /** Initializes the field {@linkplain} */
    public Main(View view) {
        super(view);
    }
    /** Executed when the program starts;
     * calls {@linkplain ex02.Main#menu menu()} method
     * @param args - program launch parameters
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}