package units.Landshaft;

import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.HashSet;

public class Landshaft extends HashSet<Dot>{

    public Landshaft(){
        super();
    }

    public Landshaft(int x, int y){
        super();
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                Dot dot = new Dot(i,j,false);
                this.add(dot);
                if (dot.y == dot.x){
                    dot.setType(true);
                }
            }
        }
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

