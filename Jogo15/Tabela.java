import java.util.*;

class Tabela{
  public int[] arr;// = new int[16];
  public String path="";

    public Tabela(){
      arr = new int[16];
      path = "";
    }

    public Tabela(int[] v){
      arr = v;
      path = "";
    }

    public Tabela(Tabela t){

      arr = new int[t.arr.length];
      path=t.path;
    }



  public  static void scanTabela(Tabela t){

        Scanner scan = new Scanner(System.in);

        for(int i =0;i< 16 ; i++){
        t.arr[i]=scan.nextInt();
        }

      }

//Cria uma nova tabela

   public static Tabela copyTabela(Tabela t){
      Tabela t_final= new Tabela();

      for(int i =0 ; i< 16;i++){
        t_final.arr[i]=t.arr[i];
      }
      t_final.path=t.path;

      return t_final;

    }


//retorna as posiçoes possiveis que aquela peça pode assumir

    static String[] checkMoves(Tabela t){
      String[] str=new String[4];

      //Descobrir pos do 0
      int pos=0;
      for(int i =0;i < 16 ; i++){
        if(t.arr[i]==0){
          pos =i;
        }
      }
      int i =0;

      if(pos != 12 && pos != 13 && pos != 14 && pos != 15){
      str[i]="baixo";
      i++;
      }
      if(pos != 0 && pos != 1 && pos != 2 && pos != 3){
        str[i]="cima";
        i++;
        }
      if(pos != 0 && pos != 4 && pos != 8 && pos != 12){
        str[i]="esquerda";
        i++;
        }
      if(pos!=3 && pos!=7 && pos!=11 && pos!=15){
        str[i]="direita";
        i++;
        }

      return str;
    }


//retorna as novas tabelas
  static  Tabela moveTabela(String s, Tabela t){
    Tabela t_final = new Tabela(Arrays.copyOf(t.arr , t.arr.length));
    t_final.path = t.path;
      int pos=0;

      for(int i =0;i < 16 ; i++){
        if(t.arr[i]==0){
          pos =i;
        }
      }
      int ti;


      switch(s){
          case "cima":
              ti = t_final.arr[pos-4];
              t_final.arr[pos-4]=0;
              t_final.arr[pos]=ti;
              t_final.path +="C";
              break;

          case"baixo":
              ti = t_final.arr[pos+4];
              t_final.arr[pos+4]=0;
              t_final.arr[pos]=ti;
              t_final.path +="B";
              break;

          case "esquerda":
              ti = t_final.arr[pos-1];
              t_final.arr[pos-1]=0;
              t_final.arr[pos]=ti;
              t_final.path +="E";
              break;

          case "direita":
              ti = t_final.arr[pos+1];
              t_final.arr[pos+1]=0;
              t_final.arr[pos]=ti;
              t_final.path +="D";
              break;

            }

      return t_final;
    }

static boolean equalsTabela(Tabela t1,Tabela t2){

        for(int i =0; i< 16 ; i++){
          if(t1.arr[i] != t2.arr[i])
          return false;
        }
        return true;
}


public static void printTabela(Tabela t){

  for(int i =0;i< 4 ; i++)
    System.out.print(t.arr[i] + " ");
    System.out.println();

  for(int i =4;i< 8 ; i++)
    System.out.print(t.arr[i] + " ");
    System.out.println();

  for(int i =8;i< 12 ; i++)
    System.out.print(t.arr[i] + " ");
    System.out.println();

  for(int i =12;i< 16 ; i++)
    System.out.print(t.arr[i] + " ");
    System.out.println();


}

}
