package Materiels;

/**
 * Created by irifi on 04/01/17.
 */
public class Afficheur implements IAfficheur {
    String value;

    public Afficheur(){
        this.value = "";
    }
    @Override
    public void setAfficheur(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
