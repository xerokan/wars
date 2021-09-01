package Wars.moves;

import Wars.Landshaft.Dot;
import Wars.Landshaft.Mapping;
import Wars.units.Unit;

public class Down implements Move{

    public Dot down(Unit unit) {
       return Mapping.getDotXY(unit.position.getX(), unit.position.getY()+1);
    }

    @Override
    public Dot move(Unit unit) {
       return down(unit);
    }
}
