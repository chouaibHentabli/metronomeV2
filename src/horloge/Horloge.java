package horloge;

import command.Command;

import java.util.Timer;

/**
 * Created by chouaib on 30/12/16.
 */
public class Horloge implements IHorloge {
    Timer timer;

    @Override
    public void activerApresDelai(Command cmd, long delaiEnSecondes) {

    }

    @Override
    public void activerPeriodiquement(Command cmd,long periodEnSecondes) {
        timer=new Timer();
        TachePeriodique tache=new TachePeriodique(cmd);
        //long tempsMillisecondes = this.tempsEnMilliSecondes(periodEnSecondes);
        //System.out.println(tempsMillisecondes);
        timer.schedule(tache, 0, periodEnSecondes);
    }

    @Override
    public void desactiver() {
        timer.cancel();
        timer.purge();
    }
    /**
     * Renvoi le temps "tempsEnSeconde" en milli secondes
     * @param tempsEnSeconde
     * @return
     */
    private long tempsEnMilliSecondes(float tempsEnSeconde) {
        return (long) (1000 * tempsEnSeconde);
    }
}
