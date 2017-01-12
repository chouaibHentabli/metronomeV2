package command;

import engine.Engine;

/**
 * Created by chouaib on 30/12/16.
 */
public class Tic implements Command {

    Engine engine;

    public Tic(Engine e) {
        this.engine = e;
    }

    @Override
    public void execute() {
        engine.tic();
    }
}
