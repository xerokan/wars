package Wars.Landshaft;

import java.util.HashMap;

public class Landshaft extends HashMap<Dot, TypeOfDots> {

    public Landshaft(){
        super();
    }

    @Override
    public TypeOfDots put(Dot dot, TypeOfDots type){
        if (dot == null){
            return null;
        }
       return super.put(dot, type);
    }

    public Dot getDotByXY(int x, int y){
        for (Dot dot : this.keySet()){
            if (dot.getX() == x && dot.getY() == y){
                return dot;
            }
        }
        return null;
    }
}

