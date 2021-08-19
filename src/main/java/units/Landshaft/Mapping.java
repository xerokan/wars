package units.Landshaft;

public class Mapping {
    static Dot[][] map;

    public static void create(int x, int y){
        map = new Dot[x][y];
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                Dot dot = new Dot(i,j,false);
                map[i][j] = dot;
                if (dot.y == dot.x){
                    dot.setType(true);
                }
            }
        }
    }

    public static Dot getDot(int x, int y){
        return map[x][y];
    }

}
