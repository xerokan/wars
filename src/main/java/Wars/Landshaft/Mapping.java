package Wars.Landshaft;

import Wars.units.Squad;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
    static Dot[][] map;
    public static int x;
    public static  int y;
    public static Map<Dot, TypeOfDots> map1;

    public static void create(int x, int y){
        map = new Dot[x][y];
        map1 = new HashMap<Dot, TypeOfDots>();
        Mapping.x = x-1;
        Mapping.y = y-1;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                Dot dot = new Dot(i,j);
                map[i][j] = dot;
                map1.put(dot, TypeOfDots.Visible);
            }
        }
    }

    public static Dot getDotXY(int x, int y){
        if ((x <= Mapping.x && x >= 0) && (y <= Mapping.y && y >= 0)) {
            return map[x][y];
        } else return null;
    }

    public static TypeOfDots getDotType(Dot dot){
       return map1.get(dot);
    }


    public static void show(){
        for (int i = 0; i <= x; i++){
            for (int j = 0; j <= y; j++){
                System.out.print(Mapping.getDotXY(j,i).getDotShowMap()+" ");
            }
            System.out.println();
        }
    }

    public static Landshaft getAllDots() {
        Landshaft land = new Landshaft();
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                land.put(Mapping.getDotXY(j, i), Mapping.getDotXY(j,i).getTypeMap());
            }
        }
        return land;
    }

    public static void setMapBright(Squad squad){
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (squad.contains(map[j][i]) == false && map[j][i].bright <= 10) {
                    map[j][i].bright += 1;
                }
            }
        }
    }

    public static void showBright(){
        for (int i = 0; i <= x; i++){
            for (int j = 0; j <= y; j++){
                System.out.print(Mapping.getDotXY(j,i).bright+"   ");
            }
            System.out.println();
        }
    }

}
