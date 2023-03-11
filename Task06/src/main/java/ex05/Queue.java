package ex05;

import ex04.Command;
/** Is
 * Techniques for placement
 * and extract tasks
 * thread handler;
 * Worker Thread pattern
 * @author xone
 * @version1.0
 * @seeCommand
 */
public interface Queue {
    /** Adds a new task to the queue;
     * Worker Thread pattern
     * @param cmd task
     */
    void put(Command cmd);
    /** Removes a task from the queue;
     * Worker Thread pattern
     * @return task to be deleted
     */
    Command take();
}
