package Wars.units;

import Wars.Comands;
import Wars.Landshaft.Dot;
import Wars.Landshaft.Landshaft;
import Wars.Landshaft.Mapping;
import Wars.UStrats.Move;

import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    protected Move move;
    public Dot position;
    public Squad squad;
    protected boolean capCon;
    protected boolean unitCon;
    public Landshaft land = new Landshaft();
    final int view = 3;

    public Unit(Dot position) {
        super();
        this.unitCon = false;
        this.capCon = false;
        this.position = position;
        Mapping.getDot(this.position.getX(), this.position.getY()).setType(2);
    }

    @Override
    public Landshaft checkLand() {
        this.land.add(this.position);
        this.land.add(Mapping.getDot(this.position.getX() + 1, this.position.getY()));
        this.land.add(Mapping.getDot(this.position.getX(), this.position.getY() + 1));
        this.land.add(Mapping.getDot(this.position.getX() - 1, this.position.getY()));
        this.land.add(Mapping.getDot(this.position.getX(), this.position.getY() - 1));
        return this.land;
    }
    @Override
    public boolean tryToCon() {
        this.deleteObservers();
        this.capCon = false;
        this.unitCon = false;
        if (Math.sqrt(Math.pow(this.position.getX() - squad.cap.position.getX(), 2) + Math.pow(this.position.getY() - squad.cap.position.getY(), 2)) <= this.view) {
            this.capCon = true;
            squad.cap.addObserver(this);
            return true;
        }
        for (Unit unit : squad) {
            if (!(unit instanceof Capitan) && (unit != this) && (unit.capCon == true || unit.unitCon == true) && (Math.sqrt(Math.pow(this.position.getX() - unit.position.getX(), 2) + Math.pow(this.position.getY() - unit.position.getY(), 2)) <= this.view)) {
                unit.addObserver(this);
                this.unitCon = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable cap, Object arg) {
        if (arg == Comands.Delete) {
            this.deleteObservers();
        }
        if (arg == Comands.Land) {
            this.setChanged();
            this.notifyObservers(arg);
            this.squad.landshaft.addAll(this.checkLand());
        }
        if (arg instanceof Move){
            this.setChanged();
            this.setMove((Move) arg);
            this.notifyObservers(this.move);
        }
        if (arg == Comands.Move){
            this.setChanged();
            this.notifyObservers(Comands.Move);
            this.move();

        }
    }

    @Override
    public synchronized void deleteObservers(){
        this.setChanged();
        this.notifyObservers(Comands.Delete);
        super.deleteObservers();
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

    @Override
    public void setMove(Move move){
        this.move = move;
    }

    public void setPosition(Dot dot){
        if (dot != null && dot.getType() == 0) {
            dot.setType(2);
            this.position.setType(0);
            this.position = dot;
        }
        return;
    }

    public void  move(){
        this.move.move(this);
    }
}