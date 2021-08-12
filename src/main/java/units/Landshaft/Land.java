package units.Landshaft;

public class Land {
   public int right;
   public int left;
   public int up;
   public int down;

   public Land(int right, int left, int up, int down){
       this.down = down;
       this.left = left;
       this.right = right;
       this.up = up;
   }
}
