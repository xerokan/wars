package Wars.moves;

import Wars.Landshaft.Mapping;
import Wars.units.Unit;

public class Left implements Move {
    public void left(Unit unit) {
        unit.setPosition(Mapping.getDot(unit.position.getX()-1, unit.position.getY()));
    }

    @Override
    public void move(Unit unit) {
        left(unit);
    }
}
