package Wars.units;

import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Landshaft;
import Wars.Landshaft.Mapping;
import Wars.Landshaft.Vec;
import Wars.UStrats.*;

import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    protected Move move;
    public Vec vec;
    public double bright;
    public Dot position;
    public Squad squad;
    public Observable obs;
    protected boolean capCon;
    protected boolean unitCon;
    public Landshaft land = new Landshaft();
    final static int view = 3;

    public Unit(Dot position) {
        super();
        this.bright=0;
        this.unitCon = false;
        this.capCon = false;
        this.position = position;
        Mapping.getDot(this.position.getX(), this.position.getY()).setType(2);
        this.vec = new Vec(0,0);
    }

    public void findWay(){

    }



    @Override
    public Landshaft checkLand() {
        this.land.clear();
        this.land.add(this.position);
        this.land.add(Mapping.getDot(this.position.getX() + 1, this.position.getY()));
        this.land.add(Mapping.getDot(this.position.getX(), this.position.getY() + 1));
        this.land.add(Mapping.getDot(this.position.getX() - 1, this.position.getY()));
        this.land.add(Mapping.getDot(this.position.getX(), this.position.getY() - 1));
        return this.land;
    }

    public boolean tryToConCap() {
        this.setChanged();
        this.notifyObservers(Comands.Delete);
        super.deleteObservers();
        if (Dot.distance(this.position, this.squad.cap.position)<= this.view) {
            this.capCon = true;
            this.unitCon = false;
            squad.cap.addObserver(this);
            if(this.obs != null) {
                this.obs.deleteObserver(this);
            }
            this.obs = squad.cap;
            return true;
        }
        return false;
    }

    public boolean tryToConUnit(){
        this.setChanged();
        this.notifyObservers(Comands.Delete);
        super.deleteObservers();
        for (Unit unit : squad) {
            if (!(unit instanceof Capitan) && (unit != this) && (unit.capCon == true || unit.unitCon == true) && (Dot.distance(this.position, unit.position)) <= this.view) {
                unit.addObserver(this);
                this.unitCon = true;
                this.obs = unit;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean tryToCon(){
       if (this.tryToConCap()) {
           return true;
       }else if(tryToConUnit()){
           return true;
       }
       this.capCon = false;
       this.unitCon = false;
       return false;
    }

    @Override
    public void update(Observable cap, Object arg) {
        if (arg == Comands.Delete) {
            this.unitCon = false;
            this.capCon = false;
            this.notifyObservers(Comands.Delete);
            super.deleteObservers();
        }
        if (arg == Comands.Land) {
            this.setChanged();
            this.notifyObservers(arg);
            this.squad.landshaft.addAll(this.checkLand());
        }
        if (arg == Comands.Go){
            this.setChanged();
            this.notifyObservers(Comands.Go);
            this.go();

        }
    }


    @Override
    public void show(){
        for (int i = 0; i <= Mapping.x; i++){
            for (int j = 0; j <= Mapping.y; j++){
                if (this.land.contains(Mapping.getDot(j,i))){
                    System.out.print(Mapping.getDot(j,i).getType()+"   ");
                }else System.out.print("X   ");
            }
            System.out.println();
        }
    }

    public void setMove(Move move){
        this.move = move;
    }

    public void setPosition(Dot dot){
        if (dot != null && dot.getType() == 0) {
            dot.setType(2);
            this.position.setType(0);
            this.position = dot;
            dot.bright = this.bright;
            this.squad.chain = true;
            this.vec = new Vec(0,0);
            this.checkLand();
        }
        return;
    }


    public void go(){
        if(this.vec.x >= 0 && this.vec.x >= this.vec.y){
            this.setMove(new Right());
        } else if(this.vec.x < 0 && -this.vec.x >= this.vec.y){
            this.setMove(new Left());
        }else if (this.vec.y >= 0 && this.vec.y > this.vec.x){
            this.setMove(new Down());
        }else if(this.vec.y < 0 && -this.vec.y > this.vec.x){
            setMove(new Up());
        }
        if(this.move != null) {
            this.move.move(this);
        }
    }
}