/**
 * Created by N1kita on 22.05.2017.
 */
public class ShowCryHelpCommand implements Command {

    HelperReceiver helperReceiver;

    public ShowCryHelpCommand(HelperReceiver helperReceiver){
        this.helperReceiver = helperReceiver;
    }

    public void execute() {
        helperReceiver.showCryHelpMessage();
    }
}
