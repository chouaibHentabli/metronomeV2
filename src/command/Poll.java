package command;

import adapter.IAdapter;
import javafx.application.Platform;

/**
 * Created by chouaib on 30/12/16.
 */
public class Poll implements Command {
    IAdapter adapterButton;

    public Poll(IAdapter adapterButton) {
        this.adapterButton = adapterButton;
    }

    @Override
    public void execute() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                adapterButton.poll();
            }
        });

    }
}
