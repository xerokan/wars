package Wars.Landshaft;

public class ConAttrVec extends Vec{

    public ConAttrVec(Dot startDot, Dot endDot) {
        super(startDot, endDot);
        double size = Math.sqrt(Math.pow(startDot.getX() - endDot.getX(), 2) + Math.pow(startDot.getY() - endDot.getY(), 2));
        this.x = (size/5) * (((endDot.getX() - startDot.getX())/size));
        this.y = (size/5) * (((endDot.getY() - startDot.getY())/size));
    }
}
