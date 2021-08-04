package units;


import java.util.Observable;

public class Capitan extends Unit {
    public String command;

    public  Capitan(Mayor mayor){
        this.number = count;
        Unit.count ++;
        mayor.addObserver(this);
    }

    public Capitan() {

    }


    public void giveAComand  (String com){
        this.command = com;
        setChanged();
        this.notifyObservers(command);
    }

    @Override
    public void update(Observable may, Object arg){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Капитан"+this.number+" приказ принял \n");
        giveAComand((String)arg);
        System.out.println("Отряд Капитана"+this.number);
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
}
