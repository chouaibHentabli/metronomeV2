package command;

import controller.IController;


/**
 * Created by chouaib on 30/12/16.
 */
public class MarkTempo implements Command {
    IController controleur;

    @Override
    public void execute() {
        controleur.MarkTemps();
    }

    public MarkTempo(IController controleur) {
        this.controleur = controleur;
    }
}
