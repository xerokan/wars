import units.*;
import units.Landshaft.Dot;
import units.Landshaft.Landshaft;
import units.Landshaft.Mapping;

public class Start {

    public static void main(String[] args) {
        Mapping.create(10, 10);
        Squad squad = new Squad();
        Capitan cap = new Capitan(Mapping.getDot(8,3));
        squad.add(cap);
        Unit unit = new Unit(Mapping.getDot(7,8));
        Unit unit1 = new Unit(Mapping.getDot(7,5));
        Unit unit2 = new Unit(Mapping.getDot(8,1));
        squad.add(cap);
        squad.add(unit);
        squad.add(unit1);
        squad.add(unit2);
        System.out.println(squad);
        squad.show();
        System.out.println();
        unit.position = Mapping.getDot(1,2);
        squad.show();
    }
}
