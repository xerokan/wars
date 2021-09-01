package Wars.moves;

import Wars.Landshaft.Dot;
import Wars.Landshaft.Mapping;
import Wars.units.Unit;

public class Right implements Move {

    public Dot right(Unit unit) {
       return Mapping.getDotXY(unit.position.getX()+1, unit.position.getY());
    }

    @Override
    public Dot move(Unit unit) {
       return right(unit);
    }

}
