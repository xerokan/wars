package Wars.strats;

import Wars.Landshaft.Dot;
import Wars.moves.Down;
import Wars.moves.Left;
import Wars.moves.Right;
import Wars.moves.Up;
import Wars.units.Unit;

public class Find implements Strat {
    @Override
    public void execute(Unit unit) {
        unit.setBright();
        unit.setVec();
        if (unit.vec.x >= 0 && ((unit.vec.y >= 0 && unit.vec.x >= unit.vec.y) || (unit.vec.y < 0 && unit.vec.x >= -unit.vec.y))) {
            unit.setMove(new Right());
        } else if (unit.vec.x < 0 && ((unit.vec.y > 0 && -unit.vec.x > unit.vec.y) || (unit.vec.y < 0 && unit.vec.x < unit.vec.y))) {
            unit.setMove(new Left());
        } else if (unit.vec.y >= 0 && ((unit.vec.x > 0 && unit.vec.y > unit.vec.x) || (unit.vec.x < 0 && unit.vec.y > -unit.vec.x))) {
            unit.setMove(new Down());
        } else if (unit.vec.y < 0 && ((unit.vec.x > 0 && -unit.vec.y > unit.vec.x) || (unit.vec.x < 0 && unit.vec.y < unit.vec.x))) {
            unit.setMove(new Up());
        }
        if (unit.move != null) {
            Unit closestUnit = null;
            double dst = Unit.hear * unit.squad.size();
            for (Unit unit1 : unit.squad) {
                if (unit1 != unit && Dot.distance(unit.move.move(unit), unit1.position) <= unit.hear) {
                    unit.setPosition(unit.move.move(unit));
                    return;
                }
                if (Dot.distance(unit.position, unit1.position) < dst) {
                    closestUnit = unit1;
                    dst = Dot.distance(unit.position, unit1.position);
                }
            }
            unit.changeMove(closestUnit);
            unit.setPosition(unit.move.move(unit));
        }
    }
}
