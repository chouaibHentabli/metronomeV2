package horloge;

import command.Command;

/**
 * Created by chouaib on 30/12/16.
 */

/*
* Invoker
* */
public interface IHorloge {
    void activerApresDelai(Command cmd, long delaiEnSecondes);
    void activerPeriodiquement(Command cmd, long periodEnSecondes);
    void desactiver();
}
