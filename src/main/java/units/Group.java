package units;

import java.util.HashSet;

public class Group extends HashSet<Squad> implements Voisko {
    private Voisko voisko;

    public Group(){
        super();
    }

    @Override
     public boolean add(Squad squad){
        return this.add(squad);
     }

    public boolean remove(Squad squad){
        return this.remove(squad);
     }


    @Override
    public void execute() {
        voisko.execute();
    }

    public void setVoisko(Voisko strat) {
        voisko = strat;
    }
}
