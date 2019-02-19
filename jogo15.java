import java.util.*;

public class jogo15 extends Search{

  public static Scanner scan = new Scanner(System.in);

   public static void printTable(int[][] values){
    System.out.println("|"+values[0][0]+"|"+values[0][1]+"|"+values[0][2]+"|"+values[0][3]+"|");
    System.out.println("|"+values[1][0]+"|"+values[1][1]+"|"+values[1][2]+"|"+values[1][3]+"|");
    System.out.println("|"+values[2][0]+"|"+values[2][1]+"|"+values[2][2]+"|"+values[2][3]+"|");
    System.out.println("|"+values[3][0]+"|"+values[3][1]+"|"+values[3][2]+"|"+values[3][3]+"|");

  }
  public static void main(String[] args) {

    int[][] values = new int[4][4];
    //scan line 1
    System.out.println("first line:");
    for(int i =0 ; i < 4 ; i++){
      values[0][i]=scan.nextInt();
    }
    // scan line 2
    System.out.println("second line:");
    for(int i =0 ; i < 4 ; i++){
      values[1][i]=scan.nextInt();
    }
    // scan line 3
    System.out.println("third line:");
    for(int i =0 ; i < 4 ; i++){
      values[2][i]=scan.nextInt();
    }
    // scan line 4
    System.out.println("fourth line:");
    for(int i =0 ; i < 4 ; i++){
      values[3][i]=scan.nextInt();
    }

    //search for 0 existence and sees if it is solvable
    boolean result = Blanksearch(values);
    if(result){
    System.out.println("Solvable");

    //print the table if it works
    printTable(values);

  }
  else
  System.out.println("Unsolvable");

}
}
