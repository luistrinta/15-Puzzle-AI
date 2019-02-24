import java.util.*;

public class Aux extends Tabela{

static void BFS(Tabela t_inicial,Tabela t_final){

          //variavel de incrememnto do numero de nos
          Queue<Tabela> queue = new LinkedList<>();

          queue.add(t_inicial);

          boolean flag = true;
          int counter=0;
          while(flag){
            counter++;
            Tabela t = queue.remove();
            Tabela valor = copyTabela(t);
            String[] s = moveTabela(valor);

          for(String str : s){
            if(str != null){
              Tabela t2 = new_Tabela(str,valor);
              queue.add(t2);
              //printTabela(t2);
              //System.out.println("-----------------");
                             }
                           }


                  if(equalsTabela(valor,t_final)){
                    flag = false;
                    System.out.println("Done in "+counter+" steps!");
                    System.out.println("Path "+valor.path);
                  }

            }

                }
              }
