package controller;

import engine.Engine;
import ihm.IInterface;
import ihm.Interface;

import java.util.Observable;

/**
 * Created by chouaib on 30/12/16.
 */
public class Controller implements IController {

    Engine engine;
    //ihm view;
    IInterface view;

    public Controller() {
        engine = new Engine(this);

    }


    public Engine getEngine() {
        return engine;
    }

    public IInterface getView() {
        return view;
    }

    public void setView(IInterface v) {
        view = v;
        view.setEngine(engine);
    }

    @Override
    public void MarkMeasure() {
        if (view != null)
            view.switchOnToc();
    }

    @Override
    public void MarkTemps() {
        if (view != null)
            view.switchOnTic();
    }

    @Override
    public void incrementMeasure() {
        if (engine.getTempsPm() < 7) {
            engine.setNbTempsPm(engine.getTempsPm() + 1);
        }
        System.out.println("nombre measure " + engine.getTempsPm());
    }

    @Override
    public void decrementMeasure() {
        if (engine.getTempsPm() > 2) {
            engine.setNbTempsPm(engine.getTempsPm() - 1);
        }
        System.out.println("nombre messure " + engine.getTempsPm());
    }

    @Override
    public void updateTempo() {
        if (view != null)
            view.updateTempo();
    }

    @Override
    public void start() {
        if (!engine.getRunning()) {
            engine.setRunning(true);
        }
    }

    @Override
    public void stop() {
        if (engine.getRunning()) {
            engine.setRunning(false);
        }
    }

    @Override
    public void setTempo(String value) {
        int temp;
        temp = Integer.parseInt(value);
        engine.setTempo(temp);
    }


    @Override
    public void update(Observable o, Object arg) {

    }


    @Override
    public void tic() {

    }
}
