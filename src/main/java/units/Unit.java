package units;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Unit extends Observable implements Observer, Voisko {
    private Voisko voisko;
    public int[] land = new int[4];
    private boolean capCon;
    private boolean unitCon;
    public int view = 2;
    public int hear = 4;

    public  Unit(Observable obs, int[][] pos){
        obs.addObserver(this);
        this.unitCon = false;
    }

    public Unit() {

    }

    public void setCapCon(boolean capCon){
        this.capCon = capCon;
    }

    public void checkPlace(int right,int left, int down,int up){
        land[0] = right;
        land[1] = left;
        land[2] = down;
        land[3] = up;
    }

    @Override
    public void update(Observable cap, Object arg){
        System.out.println(this.land);
    }

    public boolean tryToCon(Squad squad){
        if (this.unitCon == false){
            Iterator iter = squad.iterator();
            while (iter.hasNext()){
                if ((((Unit) iter.next()).capCon == true) || (((Unit) iter.next()).unitCon == true)){
                    ((Unit) iter.next()).addObserver(this);
                    this.unitCon = true;
                    return true;
                }
            }
            while (iter.hasNext()){

            }

        }
    }


    @Override
    public void execute() {
        voisko.execute();
    }

    public void setVoisko(Voisko strat) {
        voisko = strat;
    }
}

