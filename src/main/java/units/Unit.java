package units;

import units.Landshaft.Dot;
import units.Landshaft.Landshaft;

import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    private Voisko voisko;
    public Dot position;
    public Squad squad;
    public boolean capCon;
    private boolean unitCon;
    public Landshaft land;
    public int view = 2;
    public int hear = 4;

    public  Unit(Dot position){
        this.unitCon = false;
        this.position = position;
        this.capCon = false;
    }

    public Unit() {

    }

    public void setCapCon(boolean capCon){
        this.capCon = capCon;
    }

//    public Landshaft checkPlace(){
//        this.land.add(map.getDot(this.position.x+1, this.position.y));
//        this.land.add(map.getDot(this.position.x-1, this.position.y));
//        this.land.add(map.getDot(this.position.x, this.position.y+1));
//        this.land.add(map.getDot(this.position.x, this.position.y-1));
//        return  this.land;
//    }

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
//            this.squad.landshaft.add(this.checkPlace());
        }
    }

    public boolean tryToCon(Squad squad) {
        setChanged();
        this.notifyObservers("delete");
        this.deleteObservers();
        if (Math.sqrt(Math.pow(this.position.getX()-squad.cap.position.getX(),2)+ Math.pow(this.position.getY()-squad.cap.position.getY(),2))<=this.view){
            this.capCon=true;
            squad.cap.addObserver(this);
            return true;
        }
        for (Unit unit : squad){
            if (!(unit instanceof Capitan) && (unit.capCon == true || unit.unitCon == true) && (Math.sqrt(Math.pow(this.position.getX()-unit.position.getX(),2)+ Math.pow(this.position.getY()-unit.position.getY(),2))<=this.view)) {
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

