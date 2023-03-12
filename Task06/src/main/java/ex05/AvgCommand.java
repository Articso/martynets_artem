package ex05;

import java.util.concurrent.TimeUnit;
import ex02.Item2d;
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
public class AvgCommand implements Command /*, Runnable */ {
    /** Stores the result of processing the collection */
    private double result = 0.0;
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
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Returns the result
     * @return field {@linkplain MaxCommand#result}
     */
    public double getResult() {
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
        System.out.println("Average executed...");
        result = 0.0;
        double hexResult = 0.0;
        double octResult = 0.0;
        int idx = 1, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            hexResult += item.getHex();
            octResult += item.getOct();
            progress = idx * 100 / size;
            if (idx++ % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }
            try {

                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        double avgHex = hexResult / size;
        double avgOct = octResult / size;
        System.out.println("Average done. Result (Hex) = " + String.format("%.2f",avgHex) + ", Result (Oct) = " + String.format("%.2f",avgOct));
        progress = 100;
    }
/**
 @Override
 public void run() {
 execute();
 }
 /**/
}
