package Wars.Landshaft;

public class Dot {
    final int x;
    final int y;
    private int type;
    public double bright;


    public Dot(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.bright = 2;
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

    public static double distance(Dot dot1, Dot dot2){
     return Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot2.getY(), 2));
    }
}

