package Wars.strats;

import Wars.units.Unit;

public class Land implements Strat{

    @Override
    public void execute(Unit unit) {
        unit.squad.landshaft.addAll(unit.land);
        unit.land.clear();
    }
}
