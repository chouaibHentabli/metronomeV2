package Materiels;

/**
 * Created by irifi on 04/01/17.   
 */
public class Materiel implements IMateriel{

    IMoulette moulette = new Moulette();
    IAfficheur afficheur = new Afficheur();
    Clavier clavier = new ClavierImpl();

    @Override
    public IAfficheur getAfficheur() {
        return afficheur;
    }

    @Override
    public Clavier getClavier() {
        return clavier;
    }

    @Override
    public IMoulette getMoulette() {
        return moulette;
    }
}
