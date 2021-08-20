package units.Landshaft;

public class Mapping {
    static Dot[][] map;
    public static int x;
    public static  int y;

    public static void create(int x, int y){
        map = new Dot[x][y];
        Mapping.x = x-1;
        Mapping.y = y-1;
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                Dot dot = new Dot(i,j,0);
                map[i][j] = dot;
                if (dot.y == dot.x){
                    dot.setType(1);
                }
            }
        }
    }

    public static Dot getDot(int x, int y){
        if ((x <= Mapping.x && x >= 0) && (y <= Mapping.y && y >= 0)) {
            return map[x][y];
        } else return null;
    }

    public static void show(){
        for (int i = 0; i <= x; i++){
            for (int j = 0; j <= y; j++){
                System.out.print(Mapping.getDot(j,i).getType()+"   ");
            }
            System.out.println();
        }
    }
}
