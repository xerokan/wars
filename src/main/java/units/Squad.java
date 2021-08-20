package units;

import units.Landshaft.Landshaft;
import units.Landshaft.Mapping;

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

    @Override
    public Landshaft checkLand(){
        this.landshaft.clear();
        this.tryToCon();
        this.cap.changeCap();
        this.cap.notifyObservers(Comands.Land);
        this.landshaft.addAll(this.cap.checkLand());
        return this.landshaft;
    }

    @Override
    public boolean add(Unit unit) {
        unit.squad = this;
        if (unit.capCon == true) {
            cap.addObserver(unit);
        } else
           if (unit.tryToCon() == false){
               System.out.println("Unit added without connection");
           }
         return super.add(unit);
    }


    public void add(Capitan cap) {
       this.cap  = cap;
       cap.squad = this;
         super.add(cap);
    }


    public boolean remove(Unit unit){
        unit.deleteObservers();
        this.cap.deleteObserver(unit);
        return super.remove(unit);
    }


    public void setVoisko(Voisko strat) {
        voisko = strat;
    }

    @Override
    public void show(){
        this.checkLand();
        for (int i = 0; i <= Mapping.x; i++){
            for (int j = 0; j <= Mapping.y; j++){
               if (this.landshaft.contains(Mapping.getDot(j,i))){
                   System.out.print(Mapping.getDot(j,i).getType()+"   ");
               }else System.out.print("X   ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean tryToCon() {
        for (Unit unit : this){
            unit.tryToCon();
        }
        return true;
    }
}
