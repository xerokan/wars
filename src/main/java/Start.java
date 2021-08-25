import Wars.Landshaft.Mapping;
import Wars.UStrats.Left;
import Wars.UStrats.Right;
import Wars.units.Capitan;
import Wars.units.Squad;
import Wars.units.Unit;

public class Start {

    public static void main(String[] args) {
        Mapping.create(10, 10);
        Squad squad = new Squad();
        Capitan cap = new Capitan(Mapping.getDot(0,1));
        squad.add(cap);
        Unit unit = new Unit(Mapping.getDot(0,7));
        Unit unit1 = new Unit(Mapping.getDot(0,6));
        Unit unit2 = new Unit(Mapping.getDot(0,3));
        squad.add(cap);
        squad.add(unit);
        squad.add(unit1);
        squad.add(unit2);
        squad.show();
        Mapping.showBright();
        squad.checkLand();
        Mapping.showBright();
        }
    }

