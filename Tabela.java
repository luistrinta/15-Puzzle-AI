import java.util.*;

public class Tabela {
    public int[] arr;
    public String path = "";
    public int[] pai;

    public Tabela() {
        arr = new int[16];
        path = "";
        //   = "";
        pai = new int[16];
    }

    public Tabela(int[] v) {
        arr = v;
        path = "";
        //   = "";
        pai = new int[16];
    }

    public Tabela(Tabela t) {

        arr = t.arr;
        path = t.path;
        //   = t.;
        pai = getPai(t);
    }

    // public static String get(Tabela t) {
    //     return t.;
    // }

    public static int[] getPai(Tabela t) {
        return t.pai;
    }

    public static int[] getArr(Tabela t) {
        return t.arr;
    }


    public static void scanTabela(Tabela t) {

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 16; i++) {
            t.arr[i] = scan.nextInt();
        }
        t.pai = null;

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
                //  t_final. = "C";
                t_final.pai = getArr(t);
                break;

            case "B":
                ti = t_final.arr[pos + 4];
                t_final.arr[pos + 4] = 0;
                t_final.arr[pos] = ti;
                t_final.path += "B";
                //t_final. = "B";
                t_final.pai = getArr(t);
                break;

            case "E":
                ti = t_final.arr[pos - 1];
                t_final.arr[pos - 1] = 0;
                t_final.arr[pos] = ti;
                t_final.path += "E";
                //t_final. = "E";
                t_final.pai = getArr(t);
                break;

            case "D":
                ti = t_final.arr[pos + 1];
                t_final.arr[pos + 1] = 0;
                t_final.arr[pos] = ti;
                t_final.path += "D";
                //t_final. = "D";
                t_final.pai = getArr(t);
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
