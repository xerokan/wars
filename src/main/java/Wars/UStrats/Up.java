package Wars.UStrats;

import Wars.Landshaft.Mapping;
import Wars.units.Unit;

public class Up implements Move{

    public void up(Unit unit) {
        unit.setPosition(Mapping.getDot(unit.position.getX(), unit.position.getY()-1));
    }

    @Override
    public void move(Unit unit) {
        up(unit);
    }
}
