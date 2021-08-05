package units;

import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    private Voisko voisko;
    public int view = 2;
    public int hear = 4;

    public  Unit(Observable obs){
        obs.addObserver(this);
    }

    public Unit() {

    }


    @Override
    public void update(Observable cap, Object arg){
        System.out.println(arg) ;
    }

    @Override
    public void execute() {
        voisko.execute();
    }

    public void setVoisko(Voisko strat) {
        voisko = strat;
    }
}

