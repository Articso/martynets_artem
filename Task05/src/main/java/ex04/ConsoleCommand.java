package ex04;

/** Interface
 * console command;
 * command template
 * @author xone
 * @version1.0
 */
public interface ConsoleCommand extends Command {
    /** Command hotkey;
     * command template
     * @return hotkey character
     */
    public char getKey();
}