package Wars.Landshaft;

public class Dot {
    private final int x;
    private final int y;
    public double bright;
    public int type;


    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.bright = 10;
        this.type = 0;
    }

    public TypeOfDots getTypeMap(){
        return Mapping.getDotType(this);
    }

    public TypeOfDots getTypeLand(Landshaft land){
        return land.get(this);
    }

    public void setTypeMap(TypeOfDots type){
        Mapping.map1.put(this, type);
    }

    public String getDotShowMap(){
        switch (this.getTypeMap()){
            case Visible: return " ";
            case Unit: return "+";
            case Capitan: return "*";
            default: return "x";
        }
    }

    public String getDotShowLand(Landshaft land){
        switch (this.getTypeLand(land)){
            case Visible: return " ";
            case Unit: return "+";
            case Capitan: return "*";
            default: return "x";
        }
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

