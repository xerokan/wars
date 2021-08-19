package units.Landshaft;

import javafx.css.StyleableProperty;

public class Dot {
    final int x;
    final int y;
    private boolean type;


    public Dot(int x, int y, boolean type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void setType(boolean type){
        this.type = type;
    }

    public boolean getType(){
        return this.type;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

