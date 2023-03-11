package ex04;

/** Command interface
 * or tasks;
 * templates: Command,
 * Worker Thread
 * @author xone
 * @version1.0
 */
public interface Command {
    /** Command execution; patterns: Command, Worker Thread */
    public void execute();
}