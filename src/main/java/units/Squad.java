package units;

import java.util.ArrayList;
import java.util.HashSet;

public class Squad extends HashSet<Unit> implements Voisko {
    private Voisko voisko;
    public Squad() {
        super();
    }

    @Override
    public boolean add(Unit unit) {
        return this.add(unit);
    }

    public void remove(Unit unit){
         this.remove(unit);
    }


    @Override
    public void execute() {
        voisko.execute();
    }

    public void setVoisko(Voisko strat) {
        voisko = strat;
    }
}
