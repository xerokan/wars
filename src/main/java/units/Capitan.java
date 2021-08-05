package units;


import java.util.Observable;

public class Capitan extends Unit {
    public String command;

    public  Capitan(Mayor mayor){
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
        giveAComand((String)arg);
    }
}
