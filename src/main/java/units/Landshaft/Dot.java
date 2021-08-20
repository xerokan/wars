package units.Landshaft;

import javafx.css.StyleableProperty;

public class Dot {
    final int x;
    final int y;
    private int type;


    public Dot(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

