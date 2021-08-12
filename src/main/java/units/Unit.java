package units;

import units.Landshaft.Land;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    private Voisko voisko;
    public Land land;
    public Squad squad;
    public boolean capCon;
    private boolean unitCon;
    public int view = 2;
    public int hear = 4;

    public  Unit(Land land, Boolean capCon){
        this.unitCon = false;
        this.capCon = capCon;
        this.land = land;
    }

    public Unit() {

    }

    public void setCapCon(boolean capCon){
        this.capCon = capCon;
    }

    public Land checkPlace(){
        System.out.println("right = "+this.land.right+" left = "+this.land.left+" up = "+this.land.up+" down = "+ this.land.down);
        return this.land;
    }

    @Override
    public void update(Observable cap, Object arg){
        if (arg == "delete"){
            setChanged();
            this.notifyObservers(arg);
            this.deleteObservers();
            System.out.println("obs deleted");
        }
        if (arg == "land"){
            setChanged();
           this.notifyObservers(arg);
            this.squad.landshaft.add(this.checkPlace());
        }
    }

    public boolean tryToCon(Squad squad) {
        setChanged();
        this.notifyObservers("delete");
        this.deleteObservers();
        for (Unit unit : squad){
            if (!(unit instanceof Capitan) && (unit.capCon == true || unit.unitCon == true )){
                unit.addObserver(this);
                this.unitCon = true;
                return true;
            }
        }

        return false;
    }




    @Override
    public void execute() {
        voisko.execute();
    }

    public void setVoisko(Voisko strat) {
        voisko = strat;
    }
}

