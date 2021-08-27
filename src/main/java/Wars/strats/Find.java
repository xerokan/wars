package Wars.strats;

import Wars.moves.Down;
import Wars.moves.Left;
import Wars.moves.Right;
import Wars.moves.Up;
import Wars.units.Unit;

public class Find implements Strat{
    @Override
    public void execute(Unit unit) {
        unit.setBright();
        unit.setVec();
            if(unit.vec.x >= 0 && ((unit.vec.y >=0 && unit.vec.x >= unit.vec.y) || (unit.vec.y < 0 && unit.vec.x >= -unit.vec.y))){
            unit.setMove(new Right());
        } else if(unit.vec.x < 0 && ((unit.vec.y > 0 && -unit.vec.x>unit.vec.y) || (unit.vec.y < 0 && unit.vec.x < unit.vec.y))){
            unit.setMove(new Left());
        }else if (unit.vec.y >= 0 && ((unit.vec.x > 0 && unit.vec.y > unit.vec.x) || (unit.vec.x < 0 && unit.vec.y > -unit.vec.x))){
            unit.setMove(new Down());
        }else if(unit.vec.y < 0 && ((unit.vec.x > 0 && -unit.vec.y > unit.vec.x) || (unit.vec.x < 0 && unit.vec.y < unit.vec.x))){
            unit.setMove(new Up());
        }
        if(unit.move != null) {
            unit.move.move(unit);
        }
    }
}
