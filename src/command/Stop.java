package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class Stop implements Command {
    IController controleur;

    public Stop(IController controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
        controleur.stop();
    }
}
