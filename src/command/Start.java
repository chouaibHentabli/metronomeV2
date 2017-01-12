package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class Start implements Command {
    IController controleur;

    public Start(IController controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
        controleur.start();
    }
}
