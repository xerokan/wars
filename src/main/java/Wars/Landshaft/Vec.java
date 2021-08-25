package Wars.Landshaft;

public class Vec {
    public double x;
    public double y;

    public Vec(Dot startDot, Dot endDot){
        double size = Math.sqrt(Math.pow(startDot.getX() - endDot.getX(), 2) + Math.pow(startDot.getY() - endDot.getY(), 2));
        this.x = (endDot.bright/Math.pow(size,2)) * (((endDot.getX() - startDot.getX())/size));
        this.y = (endDot.bright/Math.pow(size,2)) * (((endDot.getY() - startDot.getY())/size));
    }

    public Vec(double x, double y){
        this.x = x;
        this.y = y;
    }



    public static Vec summ(Vec vec1, Vec vec2){
        Vec vec = new Vec( vec1.x + vec2.x, vec1.y + vec2.y);
        return vec;
    }
}
