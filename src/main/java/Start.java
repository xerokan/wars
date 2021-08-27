import Wars.Landshaft.Mapping;
import Wars.units.Capitan;
import Wars.units.Squad;
import Wars.units.Unit;

public class Start {

    public static void main(String[] args) {
        Mapping.create(20, 20);
        Squad squad = new Squad();
        Capitan cap = new Capitan(Mapping.getDot(10,10));
        squad.add(cap);
        Unit unit = new Unit(Mapping.getDot(10,6));
        Unit unit1 = new Unit(Mapping.getDot(7,5));
        Unit unit2 = new Unit(Mapping.getDot(12,11));
        squad.add(cap);
        squad.add(unit);
        squad.add(unit1);
        squad.add(unit2);
        squad.setFindLand();
        for (int i = 0; i < 100;  i++) {
            squad.go();
            squad.show();
            System.out.println();
        }
    }
}

