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
    static int heuristicManhattan(Tabela t_avaliar, Tabela t_final) {
        int[] arr = t_avaliar.arr;
        int[] arrf = t_final.arr;
        int counter = 0;
        int pos = 0, j;
        for(int i = 0; i < 16; i++) {
            for(j = 0; j < 16; j++) {
                if(arr[i] == arrf[j]) {
                    pos = j;
                    break;
                }
            }
            int ii = i + 1;
            int poss = pos + 1;
            int pos1[] = {(ii%4!= 0) ? ii/4+1 : ii/4, ii%4==0 ? 4 : ii%4};
            int pos2[] = {(poss%4!= 0) ? poss/4+1 : poss/4, poss%4==0 ? 4 : poss%4};
            //System.out.printf("Numero %02d | Posição Array %02d | Coordenadas1 %02dx%02dy | Coordenadas2 %02dx%02dy\n", arr[i], poss, pos1[0], pos1[1], pos2[0], pos2[1]);
            //System.out.println(counter+" "+(pos1[0]>=pos2[0])+" "+ (pos1[0]>=pos2[0] ? pos1[0]-pos2[0] : pos2[0]-pos1[0])+"+"+(pos1[1]>=pos2[1] ? pos1[1]-pos2[1] : pos2[1]-pos1[1]));
            counter = counter + (pos1[0]>=pos2[0] ? pos1[0]-pos2[0] : pos2[0]-pos1[0])
            					  + (pos1[1]>=pos2[1] ? pos1[1]-pos2[1] : pos2[1]-pos1[1]);
        }
        return counter;
    }
}