import units.Capitan;
import units.Mayor;
import units.Squad;
import units.Unit;

public class Start {

    public static void main(String[] args) {
        Squad squad = new Squad(3);
        Squad squad1 = new Squad(5);
        Squad squad2 = new Squad(2);
        squad.findMayor().giveAComand("Налево");
    }
}
