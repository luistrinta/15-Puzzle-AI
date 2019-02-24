import java.util.*;
  public class test extends Aux{

    public static Scanner scan = new Scanner(System.in);

public static void main(String[] args) {
 //BFS test
 int[] t_arr = new int[16];
 int[] t2_arr = new int[16];

  Tabela t_inicial = new Tabela(t_arr);
  Tabela t_final =new Tabela(t2_arr);

  scanTabela(t_inicial);
  scanTabela(t_final);


BFS(t_inicial,t_final);


}
}
