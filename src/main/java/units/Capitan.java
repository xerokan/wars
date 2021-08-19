package units;


import units.Landshaft.Dot;
import units.Landshaft.Landshaft;

import java.util.Observable;

public class Capitan extends Unit {


    public Capitan(Dot dot) {
        super(dot);
        this.position = dot;
    }

    @Override
    public Landshaft checkLand(){
        this.setChanged();
        this.notifyObservers(Comands.Land);
        return super.checkLand();
    }

    @Override
    public void update(Observable may, Object arg){
    }
}
