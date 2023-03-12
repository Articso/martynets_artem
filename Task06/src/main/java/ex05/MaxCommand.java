package ex05;

import java.util.concurrent.TimeUnit;
import ex02.ViewResult;
import ex04.Command;
/** Task used
 * thread handler;
 * Worker Thread pattern
 * @author xone
 * @version1.0
 * @seeCommand
 * @seeCommandQueue
 */
public class MaxCommand implements Command /*, Runnable */ {
    /** Stores the result of processing the collection */
    private int result = -1;
    /** Result ready flag */
    private int progress = 0;
    /** Serves a collection of objects {@linkplain ex02.Item2d} */
    private ViewResult viewResult;
    /** Returns the field {@linkplain MaxCommand#viewResult}
     * @return value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /** Sets the {@linkplain MaxCommand#viewResult} field
     * @param viewResult value for {@linkplain MaxCommand#viewResult}
     * @return new value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    /** Initializes the field {@linkplain MaxCommand#viewResult}
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Returns the result
     * @return field {@linkplain MaxCommand#result}
     */
    public int getResult() {
        return result;
    }
    /** Checks if the result is ready
     * @return false - if the result is found, otherwise - true
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }
    /** Used by the thread handler {@linkplain CommandQueue};
     * Worker Thread pattern
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        int hexResult = 0;
        int octResult = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(hexResult).getHex() <
                    viewResult.getItems().get(idx).getHex()) {
                hexResult = idx;
            }
            if (viewResult.getItems().get(octResult).getOct() <
                    viewResult.getItems().get(idx).getOct()) {
                octResult = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max done. Item #" + hexResult +
                " (Hex) found: " + viewResult.getItems().get(hexResult));
        System.out.println("Max done. Item #" + octResult +
                " (Oct) found: " + viewResult.getItems().get(octResult));
        progress = 100;
    }
/**
 @Override
 public void run() {
 execute();
 }
 /**/
}
