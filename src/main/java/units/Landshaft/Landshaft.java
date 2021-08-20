package units.Landshaft;

import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.HashSet;

public class Landshaft extends HashSet<Dot>{

    public Landshaft(){
        super();
    }

    @Override
    public boolean add(Dot dot){
        if (dot == null){
            return false;
        }
       return super.add(dot);
    }

    public Dot getDotByXY(int x, int y){
        for (Dot dot : this){
            if (dot.getX() == x && dot.getY() == y){
                return dot;
            }
        }
        return null;
    }
}

