package units;

import java.util.HashSet;
import java.util.Iterator;

public class Squad extends HashSet<Unit> {
    public static Mayor mayor;

    public Squad(int count) {
        if (mayor == null) {
            Mayor may = new Mayor();
            this.add(may);
            mayor = may;
            for (int i = 0; i < count; i++) {
                Unit unit = new Unit(may);
                this.add(unit);
            }
        } else {
            Capitan cap = new Capitan(mayor);
            this.add(cap);
            for (int i = 0; i < count; i++) {
                Unit unit = new Unit(cap);
                this.add(unit);
            }
        }
    }

    public Mayor findMayor(){
        return mayor;
    }
}
