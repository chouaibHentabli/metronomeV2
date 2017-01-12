package command;

import controller.IController;

/**
 * Created by chouaib on 30/12/16.
 */
public class MarkMeasure implements Command {
    IController controller;

    @Override
    public void execute() {
        controller.MarkMeasure();
    }

    public MarkMeasure(IController c) {
        this.controller = c;
    }
}
