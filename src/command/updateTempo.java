package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class updateTempo implements Command {
    IController controleur;

    @Override
    public void execute() {
        controleur.updateTempo();
    }

    public updateTempo(IController c) {
        this.controleur = c;
    }
}
