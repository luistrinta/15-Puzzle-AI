import java.util.*;
public class heuristic extends Aux {
    static int heuristicSum(Tabela t_avaliar, Tabela t_final) {
        int[] arr = t_avaliar.arr;
        int[] arrf = t_final.arr;
        int counter = 0;
        for(int i = 0; i < 16; i++)
            if(arr[i] != arrf[i])
                counter++;
        return counter;
    }
}