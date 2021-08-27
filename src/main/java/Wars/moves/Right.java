package Wars.moves;

import Wars.Landshaft.Mapping;
import Wars.units.Unit;

public class Right implements Move {

    public void right(Unit unit) {
        unit.setPosition(Mapping.getDot(unit.position.getX()+1, unit.position.getY()));
    }

    @Override
    public void move(Unit unit) {
        right(unit);
    }

}
