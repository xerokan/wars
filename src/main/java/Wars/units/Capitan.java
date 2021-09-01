package Wars.units;


import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Mapping;
import Wars.Landshaft.TypeOfDots;

import java.util.Observable;

public class Capitan extends Unit {

    public Capitan(Dot dot) {
        super(dot);
        this.position = dot;
        Mapping.getDotXY(this.position.getX(), this.position.getY()).setTypeMap(TypeOfDots.Capitan);
    }

    public void changeCap(){
        this.setChanged();
    }

    @Override
    public void setPosition(Dot dot){
        if (dot != null && dot.getTypeMap() == TypeOfDots.Visible) {
            dot.setTypeMap(TypeOfDots.Capitan);
            this.position.setTypeMap(TypeOfDots.Visible);
            this.position = dot;
            this.squad.chain = true;
            this.checkLand();
        }
        return;
    }

    @Override
    public void update(Observable may, Object arg){
    }

    @Override
    public boolean tryToCon() {
        return false;
    }

}
