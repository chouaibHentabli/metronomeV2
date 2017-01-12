package ihm;

import Materiels.IMateriel;
import command.Command;
import command.SonorTic;
import command.SonorToc;
import controller.IController;
import engine.Engine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by chouaib on 30/12/16.
 */
public class Interface implements IInterface {

    @FXML
    private TextField tempo;
    @FXML
    private Text value;
    @FXML
    private Slider tempoSlider;
    @FXML
    private Rectangle ledtic;
    @FXML
    private Rectangle ledtoc;

    private IController controller;
    private Engine engine;
    private Led led;
    //commands
    private Command start, stop, inc, dec;
    private IMateriel materiel;
    //Sonor
    private Sonor sonor;

    @Override
    public void setController(IController c, IMateriel materiel) {
        this.controller = c;
        this.materiel = materiel;
    }

    @Override
    public void setEngine(Engine e) {
        this.engine = e;
    }


    @Override
    public void init() {
        sonor = new Sonor();
        tempoSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                System.out.println(new_val.doubleValue());
                materiel.getMoulette().setMoulette(new_val.intValue());
                //controleur.setTempo(new_val.intValue()+"");

            }
        });
    }

    @Override
    public void start() {
        materiel.getClavier().setValue(1);
        //start.execute();
    }

    @Override
    public void stop() {
        materiel.getClavier().setValue(2);
        //stop.execute();
    }

    @Override
    public void increment() {
        materiel.getClavier().setValue(3);
        //inc.execute();
    }

    @Override
    public void decrement() {
        materiel.getClavier().setValue(4);
        //dec.execute();
    }

    @Override
    public void setTempoText(int v) {
        this.value.setText(v + "");
    }

    @Override
    public void switchOnTic() {
        //active led
        led = new SimpleLed(ledtic, Color.LIMEGREEN);
        led.flash();
        //active sound
        Command sonorTic = new SonorTic(this.sonor);
        sonorTic.execute();
        System.out.println("Tic");
    }

    @Override
    public void switchOnToc() {
        //active led
        led = new SimpleLed(ledtoc, Color.BLUE);
        led.flash();
        //active sound
        Command sonorTic = new SonorToc(this.sonor);
        sonorTic.execute();
        System.out.println("Toc");
    }

    @Override
    public void updateTempo() {
        tempo.setText(engine.getTempo() + "");
    }

    @Override
    public void setStartCommand(Command commande) {
        start = commande;
    }

    @Override
    public void setStopCommand(Command commande) {
        stop = commande;
    }

    @Override
    public void setIncCommand(Command commande) {
        inc = commande;
    }

    @Override
    public void setDecCommand(Command commande) {
        dec = commande;
    }

}
