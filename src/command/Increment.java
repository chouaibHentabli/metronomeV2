package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class Increment implements Command {
    IController controleur;

    public Increment(IController controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
        controleur.incrementMeasure();
    }
}
