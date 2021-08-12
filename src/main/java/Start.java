import units.*;
import units.Landshaft.Land;

public class Start {

    public static void main(String[] args) {
        Land land1 = new Land(1,0,0,1);
        Land land2 = new Land(1,0,0,0);
        Land land3 = new Land(0,0,0,0);
        Land land4 = new Land(0,1,1,1);
        Squad squad = new Squad();
        Capitan cap = new Capitan(land1);
        Unit unit1 = new Unit(land2, false);
        Unit unit2 = new Unit(land3, false);
        Unit unit3 = new Unit(land4, true);
        squad.add(cap);
        squad.add(unit1);
        squad.add(unit2);
        squad.add(unit3);
        squad.checkPlace();
        unit3.checkPlace();
    }
}
