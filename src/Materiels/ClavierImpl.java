package Materiels;

import java.util.Scanner;

/**
 * Created by irifi on 04/01/17.   
 */
public class ClavierImpl implements Clavier {
    int clickedButton=-1;
    Scanner scanner;
    public ClavierImpl(){

    }
    @Override
    public int touchepressee() {
        return clickedButton;
    }



    @Override
    public void reset() {
        clickedButton = -1;
    }

    @Override
    public void setValue(int value) {
        this.clickedButton = value;
    }


}
