package units;


import units.Landshaft.Dot;
import units.Landshaft.Landshaft;
import units.Landshaft.Mapping;

import java.util.Observable;

public class Capitan extends Unit {


    public Capitan(Dot dot) {
        super(dot);
        this.position = dot;
        Mapping.getDot(this.position.getX(), this.position.getY()).setType(3);
    }

    public void changeCap(){
        this.setChanged();
    }

    @Override
    public void update(Observable may, Object arg){
    }
}
