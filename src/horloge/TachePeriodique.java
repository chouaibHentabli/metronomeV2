package horloge;

import command.Command;

import java.util.TimerTask;

/**
 * Created by chouaib on 30/12/16.
 */
public class TachePeriodique extends TimerTask{

    private Command commande;
    @Override
    public void run() {
        commande.execute();
    }
    public TachePeriodique(Command c){
        super();
        commande=c;
    }
}
