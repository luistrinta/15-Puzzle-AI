import java.util.*;
public class Aux extends Tabela {
    static void BFS(Tabela t_inicial, Tabela t_final) {
        //variavel de incrememnto do numero de nos
        Queue<Tabela> queue = new LinkedList<>();
        queue.add(t_inicial);
        boolean flag = true;
        int counter = 0;
        while(flag) {
            counter++;
            Tabela t = queue.poll();
            Tabela valor = copyTabela(t);
            String[] s = checkMoves(valor);
            for(String str : s) {
                if(str != null) {
                    Tabela t2 = moveTabela(str, valor);
                    queue.add(t2);
                }
            }
            if(equalsTabela(valor, t_final)) {
                flag = false;
                System.out.println("Done in " + counter + " steps!");
                System.out.println("Path:" + valor.path);
                System.out.println("Path length:" + valor.path.length());
            }
        }
    }
    static boolean testSolvability(Tabela t) {
        //https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
        int puzzle[] = t.arr;
        int parity = 0;
        int matrixWid = (int) Math.sqrt(puzzle.length);
        int row = 0;
        int blankRow = 0; // numero 0

        //Verificar se tem 16 peças e se são entre 0 e 15
        
        if(puzzle.length != 16)return false;

        int arr1[]=t.arr.clone();
        Arrays.sort(arr1);
        for(int i = 0; i <= 15; i++)if(arr1[i] != i) {
            return false;
        }


        for (int i = 0; i < puzzle.length; i++) {
            if (i % matrixWid == 0) row++; //avança para a próxima linha
            if (puzzle[i] == 0) blankRow = row; // Guarda linha onde está o 0
            for (int j = i + 1; j < puzzle.length; j++) {
                if (puzzle[i] > puzzle[j] && puzzle[j] != 0) {
                    parity++;
                }
            }
        }
        if (blankRow % 2 == 0) { //0 numa linha impar a contar da ultima
            return parity % 2 == 0;
        } else { 
            return parity % 2 != 0;
        }
    }
    static boolean isRight(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //Verificar se tem 16 elementos
        if(arr.length != 16)return false;
        //Verificar se os elemnentos são entre 0 e 15
        for(int i = 0; i <= 15; i++)if(arr[i] != i) return false;
        return true;
    }
}