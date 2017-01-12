package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class Decrement implements Command {
    IController controleur;

    public Decrement(IController controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
        controleur.decrementMeasure();
    }
}
