/**
 * Created by N1kita on 22.05.2017.
 */
public class ShowColorfulHelpCommand implements Command {
    HelperReceiver helperReceiver;

    public ShowColorfulHelpCommand(HelperReceiver helperReceiver){
        this.helperReceiver = helperReceiver;
    }

    public void execute() {
        helperReceiver.showColorfulHelpMessage();
    }
}
