import units.*;
import units.Landshaft.Dot;
import units.Landshaft.Landshaft;

public class Start {

    public static void main(String[] args) {
        Landshaft land = new Landshaft(10,10);
        Squad squad = new Squad();
        Capitan cap = new Capitan(land.getDotByXY(9,3));
        squad.add(cap);
        Unit unit = new Unit(land.getDotByXY(0,9));
        Unit unit1 = new Unit(land.getDotByXY(9,5));
        Unit unit2 = new Unit(land.getDotByXY(9,7));
        squad.add(cap);
        squad.add(unit);
        squad.add(unit1);
        squad.add(unit2);
        System.out.println(squad);
        squad.remove(unit1);
    }
}
