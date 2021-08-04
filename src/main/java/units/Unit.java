package units;

import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer {
    protected static int count = 0;
    public int number;
    public int view = 2;
    public int hear = 4;

    public  Unit(Observable obs){
        this.number = count;
        Unit.count ++;
        obs.addObserver(this);
    }

    public Unit() {

    }


    @Override
    public void update(Observable cap, Object arg){
        System.out.println("Я" + this.number + "-ый" + " двигаюсь "+ arg+ "\n") ;
    }
}
