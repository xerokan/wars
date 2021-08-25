package Wars.units;

import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Landshaft;
import Wars.Landshaft.Mapping;
import Wars.UStrats.Move;

import java.util.HashSet;

public class Squad extends HashSet<Unit> implements Voisko {
    protected static boolean chain;
    public Capitan cap;
    public Landshaft landshaft = new Landshaft();
    protected Landshaft findLand;

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
        Mapping.setMapBright(this);
        for(Dot dot : this.landshaft){
            dot.bright = 0;
        }
        return this.landshaft;
    }

    @Override
    public boolean add(Unit unit) {
        unit.squad = this;
        this.chain=true;
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

    @Override
    public void go () {
        this.cap.changeCap();
        this.cap.notifyObservers(Comands.Go);
        this.cap.go();
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

    public Dot findMid(){
        int x =0;
        int y =0;
        for (Unit unit : this){
            x += unit.position.getX();
            y += unit.position.getY();
        }
        return Mapping.getDot( Math.round(x/this.size()),Math.round(y/this.size()));
    }

    public void setFindLand(){
        this.findLand = new Landshaft();
        Dot mid = this.findMid();
        for (Dot dot : Mapping.getAllDots()){
            if (Dot.distance(mid,dot) < (this.size()*Unit.view)){
                this.findLand.add(dot);
            }
        }

    }

    @Override
    public boolean tryToCon() {
        while (this.chain) {
            this.chain=false;
            for (Unit unit : this) {
                if (unit.unitCon == false && unit.capCon == false) {
                    if (unit.tryToCon()) {
                        this.chain = true;
                    }
                }
            }
        }
        return true;
    }

}
