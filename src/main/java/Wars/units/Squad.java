package Wars.units;

import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Landshaft;
import Wars.Landshaft.Mapping;
import Wars.Landshaft.TypeOfDots;
import Wars.strats.Find;
import Wars.strats.Land;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Squad extends HashSet<Unit> implements Voisko {
    protected boolean chain;
    public Capitan cap;
    public Landshaft landshaft = new Landshaft();
    protected Landshaft findLand;

    public Squad() {
        super();
    }

    @Override
    public Landshaft checkLand(){
        Set old = new HashSet<Dot>();
        for (Dot dot : this.landshaft.keySet()){
            if (dot.bright >= 5){
                old.add(dot);
            }
        }
        this.landshaft.keySet().removeAll(old);
        this.cap.changeCap();
        this.cap.notifyObservers(Comands.Land);
        this.cap.strat = new Land();
        for (Unit unit : this){
            if(unit.strat instanceof Land){
                unit.strat.execute(unit);
            }
        }
        Mapping.setMapBright(this);
        return this.landshaft;
    }

    @Override
    public boolean add(Unit unit) {
        unit.squad = this;
        this.chain = true;
        super.add(unit);
        this.tryToCon();
         return true;
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

    public void go () {
        this.cap.changeCap();
        this.cap.notifyObservers(Comands.Find);
        this.cap.strat = new Find();
        for (Unit unit : this){
            if(unit.strat != null) {
                unit.strat.execute(unit);
            }
        }
        this.disconnect();
        this.tryToCon();
        this.checkLand();
    }

    @Override
    public void disconnect(){
        for (Unit unit : this){
            unit.disconnect();
        }
    }

    @Override
    public void show(){
        for (int i = 0; i <= Mapping.x; i++){
            for (int j = 0; j <= Mapping.y; j++){
               if (this.landshaft.keySet().contains(Mapping.getDotXY(j,i))){
                   System.out.print(this.landshaft.getDotByXY(j,i).getDotShowLand(this.landshaft)+ " ");
               }else System.out.print(". ");
            }
            System.out.println();
        }
    }

    public Dot findMid(){
        int x =0;
        int y =0;
        for (Unit unit : this){
            x += unit.position.getX();
            y += unit.position.getY();
        }
        return Mapping.getDotXY( Math.round(x/this.size()),Math.round(y/this.size()));
    }

    public void setFindLand(){
        this.findLand = new Landshaft();
        Dot mid = this.findMid();
        for (Dot dot : Mapping.getAllDots().keySet()){
            if (Dot.distance(mid,dot) < (this.size()*Unit.view)){
                this.findLand.put(dot, TypeOfDots.Unknown);
            }
        }

    }

    @Override
    public boolean tryToCon() {
        while (this.chain) {
            this.chain=false;
            for (Unit unit : this) {
                if (unit.unitCon == false && unit.capCon == false && !(unit instanceof Capitan)) {
                    if (unit.tryToCon()) {
                        this.chain = true;
                    }
                }
            }
        }
        return true;
    }

}
