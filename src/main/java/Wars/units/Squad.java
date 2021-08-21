package Wars.units;

import Wars.Comands;
import Wars.Landshaft.Landshaft;
import Wars.Landshaft.Mapping;
import Wars.UStrats.Move;

import java.util.HashSet;

public class Squad extends HashSet<Unit> implements Voisko {
    public Capitan cap;
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
        unit.tryToCon();
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

    @Override
    public void setMove (Move move) {
        this.cap.changeCap();
        this.cap.setMove(move);
        this.cap.notifyObservers(move);
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
        for (Unit unit : this) {
            unit.tryToCon();
        }
        for (int i =0; i<this.size();i++) {
            for (Unit unit : this) {
                if (unit.unitCon == false && unit.capCon == false) {
                    unit.tryToCon();
                }
            }
        }
        return true;
    }

    public void move(){
        this.cap.changeCap();
        this.cap.notifyObservers(Comands.Move);
        this.cap.move();
    }
}
