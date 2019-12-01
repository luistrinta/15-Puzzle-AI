import java.util.*;

public class Tabela {
    public int[] arr;
    public String path = " ";
    public int[] pai;
    public int cost;
    public int[] solution;

    public Tabela() {
        arr = new int[16];
        path = " ";
        pai = new int[16];
        cost = 0;
        solution = new int[16];
    }

    public Tabela(int[] v) {
        arr = v;
        path = " ";
        pai = new int[16];
        cost = 0;
        solution = new int[16];
    }

    public Tabela(Tabela t) {

        arr = t.arr;
        path = t.path;
        pai = getPai(t);
        cost = t.cost;
        solution = t.solution;
    }


    public static int getCost(Tabela t) {
        return t.cost;
    }

    public static int[] getPai(Tabela t) {
        return t.pai;
    }

    public static int[] getArr(Tabela t) {
        return t.arr;
    }

    public static char reversed(char t){
        if(t == 'E')return 'D';
        if(t == 'D')return 'E';
        if(t == 'C')return 'B';
        if(t == 'B')return 'C';
        return ' ';

    }
    public static void scanTabelas(Tabela t_inicial, Tabela t_final) {

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 16; i++) {
            t_inicial.arr[i] = scan.nextInt();
        }
        t_inicial.pai = null;


        for (int i = 0; i < 16; i++) {
            t_final.arr[i] = scan.nextInt();
        }
        t_final.pai = null;

        t_inicial.solution = t_final.arr;
    }


    //retorna as posiçoes possiveis que aquela peça pode assumir

    static String[] checkMoves(Tabela t) {
        String[] str = new String[4];

        //Descobrir pos do 0
        int pos = 0;
        for (int i = 0; i < 16; i++) {
            if (t.arr[i] == 0) {
                pos = i;
            }
        }
        int i = 0;

        if (pos != 12 && pos != 13 && pos != 14 && pos != 15) {
            str[i] = "B";
            i++;
        }
        if (pos != 0 && pos != 1 && pos != 2 && pos != 3) {
            str[i] = "C";
            i++;
        }
        if (pos != 0 && pos != 4 && pos != 8 && pos != 12) {
            str[i] = "E";
            i++;
        }
        if (pos != 3 && pos != 7 && pos != 11 && pos != 15) {
            str[i] = "D";
            i++;
        }

        return str;
    }


    //retorna as novas tabelas
    static Tabela moveTabela(String s, Tabela t) {
        Tabela t_final = new Tabela(Arrays.copyOf(t.arr, t.arr.length));
        t_final.path = t.path;
        int pos = 0;

        for (int i = 0; i < 16; i++) {
            if (t.arr[i] == 0) {
                pos = i;
            }
        }
        int ti;


        switch (s) {
        case "C":
            ti = t_final.arr[pos - 4];
            t_final.arr[pos - 4] = 0;
            t_final.arr[pos] = ti;
            t_final.path += "C";
            t_final.pai = getArr(t);
            t_final.solution = t.solution;
            break;

        case "B":
            ti = t_final.arr[pos + 4];
            t_final.arr[pos + 4] = 0;
            t_final.arr[pos] = ti;
            t_final.path += "B";
            t_final.pai = getArr(t);
            t_final.solution = t.solution;
            break;

        case "E":
            ti = t_final.arr[pos - 1];
            t_final.arr[pos - 1] = 0;
            t_final.arr[pos] = ti;
            t_final.path += "E";
            t_final.pai = getArr(t);
            t_final.solution = t.solution;
            break;

        case "D":
            ti = t_final.arr[pos + 1];
            t_final.arr[pos + 1] = 0;
            t_final.arr[pos] = ti;
            t_final.path += "D";
            t_final.pai = getArr(t);
            t_final.solution = t.solution;
            break;

        }

        return t_final;
    }

    static boolean equalsTabela(int[] t1, int[] t2) {
        if (t1 == null || t2 == null) return false;


        for (int i = 0; i < 16; i++) {
            if (t1[i] != t2[i])
                return false;
        }
        return true;
    }

    public static void printTabela(Tabela t) {

        for (int i = 0; i < 4; i++)
            System.out.print(t.arr[i] + " ");
        System.out.println();

        for (int i = 4; i < 8; i++)
            System.out.print(t.arr[i] + " ");
        System.out.println();

        for (int i = 8; i < 12; i++)
            System.out.print(t.arr[i] + " ");
        System.out.println();

        for (int i = 12; i < 16; i++)
            System.out.print(t.arr[i] + " ");
        System.out.println();


    }

}
