package adapter;

import command.Poll;
import controller.Controller;
import horloge.*;
import Materiels.IMateriel;

/**
 * Created by anis on 30/12/16.
 */
public class Adapter implements IAdapter {

    private int mouletteOldValue = 120;
    private Controller controller;
    private Poll poll;
    private IHorloge horloge = new Horloge();
    private IMateriel materiel;

    public Adapter(IMateriel materiel, Controller controller) {
        this.materiel = materiel;
        this.controller = controller;
        this.poll = new Poll(this);
        System.out.println("");
        horloge.activerPeriodiquement(poll, 337);
    }


    @Override
    public void poll() {
        switch (materiel.getClavier().touchepressee()) {
            case 1:
                controller.start();
                break;
            case 2:
                controller.stop();
                break;
            case 3:
                controller.incrementMeasure();
                break;
            case 4:
                controller.decrementMeasure();
                break;
            default:
                break;
        }
        materiel.getClavier().reset();
        if (mouletteOldValue != materiel.getMoulette().getValue()) {
            mouletteOldValue = materiel.getMoulette().getValue();
            controller.setTempo(materiel.getMoulette().getValue() + "");
        }


    }
}
