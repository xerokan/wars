package Wars.units;


import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Mapping;

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
    public void setPosition(Dot dot){
        if (dot != null && dot.getType() == 0) {
            dot.setType(3);
            this.position.setType(0);
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
