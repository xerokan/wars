package units;


import units.Landshaft.Land;
import units.Landshaft.Landshaft;

import java.util.Observable;

public class Capitan extends Unit {
    public String command;


    public Capitan(Land land) {
    this.land = land;
    }

    public void takeLandInform(){
        setChanged();
        this.squad.landshaft.add(this.checkPlace());
        this.notifyObservers("land");
    }

    public void giveAComand  (String com){
        this.command = com;
        setChanged();
        this.notifyObservers(command);
    }

    @Override
    public void update(Observable may, Object arg){
        giveAComand((String)arg);
    }
}
