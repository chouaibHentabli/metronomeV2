package Materiels;

/**
 * Created by irifi on 04/01/17.
 */
public class Moulette implements IMoulette {

    int Value;

    public Moulette(){
        this.Value = 120;
    }
    @Override
    public void setMoulette(int value) {
        this.Value = value;
    }

    @Override
    public int getValue() {
        return Value;
    }
}
