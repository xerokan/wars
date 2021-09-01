import Wars.Landshaft.Mapping;
import Wars.units.Capitan;
import Wars.units.Squad;
import Wars.units.Unit;

public class Start {

    public static void main(String[] args) {
        Mapping.create(20, 20);
        Squad squad = new Squad();
        Capitan cap = new Capitan(Mapping.getDotXY(10,10));
        squad.add(cap);
        Unit unit = new Unit(Mapping.getDotXY(10,6));
        Unit unit1 = new Unit(Mapping.getDotXY(7,5));
        Unit unit2 = new Unit(Mapping.getDotXY(12,11));
        squad.add(cap);
        squad.add(unit);
        squad.add(unit1);
        squad.add(unit2);
        squad.setFindLand();
        Mapping.show();
        for (int i = 0; i < 100;  i++) {
            squad.go();
            squad.show();
            System.out.println();
        }
    }
}

