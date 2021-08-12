package units.Landshaft;

import java.util.HashSet;

public class Landshaft extends HashSet<Land> {

    public Landshaft(){
        super();
    }

    @Override
    public boolean add(Land land){
        return super.add(land);
    }

    public boolean remove(Land land){
       return super.remove(land);
    }

}
