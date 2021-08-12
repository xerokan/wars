package units;

import units.Landshaft.Landshaft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Squad extends HashSet<Unit> implements Voisko {
    private Voisko voisko;
    public  Capitan cap;
    public Landshaft landshaft = new Landshaft();

    public Squad() {
        super();
    }

    public Landshaft checkPlace(){
        cap.takeLandInform();
        System.out.println(this.landshaft) ;
        return this.landshaft;
    }


    @Override
    public boolean add(Unit unit) {
        if (unit.capCon == true) {
            cap.addObserver(unit);
        } else
           if (unit.tryToCon(this) == false){
               System.out.println("Unit added without connection");
           }
           unit.squad = this;
         return super.add(unit);
    }


    public void add(Capitan cap) {
       this.cap  = cap;
       cap.squad = this;
         super.add(cap);
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
