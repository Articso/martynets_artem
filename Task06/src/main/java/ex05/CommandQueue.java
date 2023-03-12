package ex05;

import java.util.Vector;
import ex04.Command;
/** Creates a handler
 * thread executing
 * objects with an interface
 *Command; sample
 * Worker Thread
 * @author xone
 * @version1.0
 * @seeCommand
 */
public class CommandQueue implements Queue {
    /** Task queue */
    private Vector<Command> tasks;
    /** Wait flag */
    private boolean waiting;
    /** Completion flag */
    private boolean shutdown;
    /** Sets the termination flag */
    public void shutdown() {
        shutdown = true;
    }
    /** Initialize {@linkplain CommandQueue#tasks}
     * {@linkplainCommandQueue#waiting}
     * {@linkplain CommandQueue#waiting};
     * creates a thread for class {@linkplain CommandQueue.Worker}
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }
    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }
    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command)tasks.remove(0);
    }
    /** Serves the queue
     * tasks; sample
     * Worker Thread
     * @author xone
     * @version1.0
     * @see Runnable
     */
    private class Worker implements Runnable {
        /** Retrieves from the queue
         * ready to run
         * tasks; sample
         *WorkerThread*/
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();

            }
        }
    }
}
