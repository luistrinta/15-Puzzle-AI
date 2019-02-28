import java.util.*;

public class Aux extends Tabela {

    static void BFS(Tabela t_inicial, Tabela t_final) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Queue < Tabela > queue = new LinkedList < > ();
        HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

        int counter = 0;
        queue.add(t_inicial);
        boolean flag = true;
        while (flag) {

            Tabela valor = queue.poll();
            String key = Arrays.toString(getArr(valor));
            if (!map.containsKey(key)) {
                map.put(key, valor);

                String[] s = checkMoves(valor);

                for (String str : s) {
                    if (str != null) {
                        Tabela t2 = moveTabela(str, valor);
                        if (!(Arrays.equals(getPai(t2), getPai(valor))))
                            queue.add(t2);
                        counter++;
                    }
                }

            }


            if (equalsTabela(valor.arr, t_final.arr)) {
                flag = false;
                long stop_Time = System.currentTimeMillis();
                long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long actualMemUsed = afterUsedMem - beforeUsedMem;
                long tempo_exec = (stop_Time - start_Time);
                System.out.println("Execution time: " + tempo_exec + "ms");
                System.out.println("Memory used : " + actualMemUsed + " Bytes");
                System.out.println("Path:" + valor.path);
                System.out.println("Path length:" + valor.path.length());
                System.out.println(" nº Tabelas : " + counter);
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

        if (puzzle.length != 16) return false;

        int arr1[] = t.arr.clone();
        Arrays.sort(arr1);
        for (int i = 0; i <= 15; i++)
            if (arr1[i] != i) {
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

    static void DFS(Tabela t_inicial, Tabela t_final, int depth) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Stack < Tabela > queue = new Stack < > ();
        HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

        int counter = 0;
        queue.push(t_inicial);

        while (!queue.isEmpty()) {

            Tabela valor = queue.pop();
            String key = Arrays.toString(getArr(valor));
            if(valor.path.length() <= depth) {
                if (!map.containsKey(key)) {
                    map.put(key, valor);

                    String[] s = checkMoves(valor);

                    for (String str : s) {
                        if (str != null) {
                            Tabela t2 = moveTabela(str, valor);
                            if (!(Arrays.equals(getPai(t2), getPai(valor))))
                                queue.push(t2);
                            counter++;
                        }
                    }

                }
            }


            if (equalsTabela(valor.arr, t_final.arr)) {

                long stop_Time = System.currentTimeMillis();
                long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long actualMemUsed = afterUsedMem - beforeUsedMem;
                long tempo_exec = (stop_Time - start_Time);
                System.out.println("Execution time: " + tempo_exec + "ms");
                System.out.println("Memory used : " + actualMemUsed + " Bytes");
                System.out.println("Path:" + valor.path);
                System.out.println("Path length:" + valor.path.length());
                System.out.println(" nº Tabelas : " + counter);
                return;
            }
        }
        System.out.println("Não existe solução a esta profundidade");
    }
    static String[] auxDFS(Tabela t_inicial, Tabela t_final, int depth) {
        Stack < Tabela > queue = new Stack < > ();
        HashMap < String, Tabela > map = new HashMap < String, Tabela > ();
        int counter = 0;
        queue.push(t_inicial);
        String[] v={"1","","0"}; 
        while (!queue.isEmpty()) {
            Tabela valor = queue.pop();
            String key = Arrays.toString(getArr(valor));
            if(valor.path.length() <= depth) {
                if (!map.containsKey(key)) {
                    map.put(key, valor);
                    String[] s = checkMoves(valor);
                    for (String str : s) {
                        if (str != null) {
                            Tabela t2 = moveTabela(str, valor);
                            if (!(Arrays.equals(getPai(t2), getPai(valor))))
                                queue.push(t2);
                            counter++;
                        }
                    }
                }
            }
            if (equalsTabela(valor.arr, t_final.arr)) {
                v[2]=Integer.toString(counter);
                v[1]=valor.path;
                return v;
            }
        }
        v[2]=Integer.toString(counter);
        v[0]="0";
        return v;
    }
    public static void IDFS(Tabela t_inicial, Tabela t_final) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        int counter=1,i=0,fours=1,f1=1;
        String[] v= auxDFS(t_inicial, t_final, 0);
        while(v[0]=="0") {
            v=auxDFS(t_inicial, t_final, i);
            counter=counter+Integer.parseInt(v[2]);
            i++;
        }
        long stop_Time = System.currentTimeMillis();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem - beforeUsedMem;
        long tempo_exec = (stop_Time - start_Time);
        System.out.println("Execution time: " + tempo_exec + "ms");
        System.out.println("Memory used : " + actualMemUsed + " Bytes");
        System.out.println("Path:" + v[1]);
        System.out.println("Path length:" + v[1].length());
        System.out.println(" nº Tabelas : " + counter);
        return;
    }

}



