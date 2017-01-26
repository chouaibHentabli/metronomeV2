package engine;

import command.*;
import controller.Controller;
import horloge.Horloge;
import horloge.IHorloge;

import java.util.Observable;

/**
 * Created by chouaib on 30/12/16.
 */
public class Engine extends Observable implements IEngine {

    //default value 120
    private int tempo = 120;
    private int measureIndex = 0;
    private Boolean running = false;
    //default value 4
    private int measure = 4;

    private Controller controller;
    private IHorloge horloge;


    public Engine(Controller c) {
        this.controller = c;
        horloge = new Horloge();
        measureIndex = measure;
    }


    /**
     * @param bpm Flapping by minute
     * @return Flapping by milliseconde
     */
    private Long getPeriodMSFromBPM(int bpm) {
        float periodMinute = 1.0f / Float.valueOf(bpm);
        Long periodMS = Long.valueOf((int) (periodMinute * 60 * 1000));
        return periodMS;
    }


    @Override
    public int getTempo() {
        return tempo;
    }

    @Override
    public void setTempo(int t) {
        Command tic = new Tic(this);
        Command UpdateTempo = new updateTempo(controller);
        this.tempo = t;
        if (getRunning()) {
            horloge.desactiver();
            horloge.activerPeriodiquement(tic, getPeriodMSFromBPM(getTempo()));
        }
        //horloge.activerApresDelai(tic,getTempo());
        UpdateTempo.execute();
    }

    @Override
    public int getTempsPm() {
        return measure;
    }

    @Override
    public void setNbTempsPm(int t) {
        this.measure = t;
    }

    @Override
    public Boolean getRunning() {
        return this.running;
    }

    @Override
    public void setRunning(Boolean m) {
        System.out.println("IEngine on : " + m);
        if (m) {
            Command tic = new Tic(this);
            this.horloge.activerPeriodiquement(tic, getPeriodMSFromBPM(getTempo()));
            this.running = true;
        } else {
            //this.setTempo(Init);
            this.horloge.desactiver();
            this.running = false;
        }
    }

    @Override
    public void tic() {
        measureIndex--;
        if (measureIndex < 0) {
            measureIndex = measure;
            Command command = new MarkMeasure(controller);
            command.execute();
        } else {
            Command command = new MarkTempo(controller);
            command.execute();
        }
    }


}
