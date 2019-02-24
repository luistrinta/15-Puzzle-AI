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
boolean init = testSolvability(t_inicial);
boolean fin = testSolvability(t_final);
if(init && fin){
BFS(t_inicial,t_final);
}
else{
  if(!init)
  System.out.println("Este tabuleiro é impossivel");

  else System.out.println("Esta solução é impossível");
}
}
}
