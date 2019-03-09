import java.util.*;

public class Aux extends Tabela {

    static void BFS(Tabela t_inicial, int[] t_final) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Queue < Tabela > queue = new LinkedList < > ();
        HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

        int counter = 0;
        int counter2 =0;
        queue.add(t_inicial);
        
        while (!queue.isEmpty()) {

            Tabela valor = queue.poll();


            String key = Arrays.toString(getArr(valor));
            if (!map.containsKey(key)) {
                map.put(key, valor);
                counter2++;
                String[] s = checkMoves(valor);

                for (String str : s) {
                    if (str != null) {
                        Tabela t2 = moveTabela(str, valor);


                        if (equalsTabela(t2.arr, t_final)) {
        
                long stop_Time = System.currentTimeMillis();
                long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long actualMemUsed = afterUsedMem - beforeUsedMem;
                long tempo_exec = (stop_Time - start_Time);
                System.out.println("Execution time: " + tempo_exec + "ms");
                if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                System.out.println("Path:" + t2.path);
                System.out.println("Path length:" + (t2.path.length() - 1));
                System.out.println(" nº nos criados : " + counter);
                System.out.println(" nº nos visitados : "+ counter2);
                return;
            }


                        if (!(Arrays.equals(getPai(t2), getPai(valor))))
                            queue.add(t2);
                            counter++;
                    }
                }

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


    static void DFS(Tabela t_inicial, int[] t_final) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Stack < Tabela > stk = new Stack < > ();

        int counter = 0;
        int counter2 =0;

        stk.push(t_inicial);
        boolean flag = true;
        while (!stk.isEmpty()) {

            Tabela valor = stk.pop();
            counter2++;
            if(valor.path.length() < 80) {

                String[] s = checkMoves(valor);

                for (String str : s) {
                    if (str != null) {
                        
                        if(str.charAt(0) != reversed(valor.path.charAt(valor.path.length() - 1))) {
                            Tabela t2 = moveTabela(str, valor);
                if (equalsTabela(t2.arr, t_final)) {
        
                long stop_Time = System.currentTimeMillis();
                long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                long actualMemUsed = afterUsedMem - beforeUsedMem;
                long tempo_exec = (stop_Time - start_Time);
                System.out.println("Execution time: " + tempo_exec + "ms");
                if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                System.out.println("Path:" + t2.path);
                System.out.println("Path length:" + (t2.path.length() - 1));
                   System.out.println(" nº nos criados : " + counter);
                System.out.println(" nº nos visitados : "+ counter2);                
                return;
            }
                            stk.push(t2);
                            counter++;
                        }
                    }
                }

            }


           
        }
    }

    static String[] auxDFS(Tabela t_inicial, Tabela t_final, int depth) {
        Stack < Tabela > queue = new Stack < > ();
        HashMap < String, Tabela > map = new HashMap < String, Tabela > ();
        int counter = 0;
        int counter2 =0;
        queue.push(t_inicial);
        String[] v = {"1", "", "0","0"};
        while (!queue.isEmpty()) {
            Tabela valor = queue.pop();
            counter2++;
            String key = Arrays.toString(getArr(valor));
            if(valor.path.length() <= depth) {

                String[] s = checkMoves(valor);
                for (String str : s) {
                    if (str != null) {
                        if(str.charAt(0) != reversed(valor.path.charAt(valor.path.length() - 1))) {
                            Tabela t2 = moveTabela(str, valor);
                            if (!(Arrays.equals(getPai(t2), getPai(valor))))
                                queue.push(t2);
                            counter++;
                        }
                    }
                }

            }

            if (equalsTabela(valor.arr, t_final.arr)) {
                v[2] = Integer.toString(counter);
                v[3] = Integer.toString(counter2);
                v[1] = valor.path;
                return v;
            }
        }
        v[2] = Integer.toString(counter);
        v[0] = "0";
        return v;
    }
    public static void IDFS(Tabela t_inicial, Tabela t_final) {
        long start_Time = System.currentTimeMillis();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        int counter = 1, counter2 =1,i = 0, fours = 1, f1 = 1;
        String[] v = auxDFS(t_inicial, t_final, 0);
        while(v[0] == "0") {
            v = auxDFS(t_inicial, t_final, i);
            counter = counter + Integer.parseInt(v[2]);
            counter2 += Integer.parseInt(v[3]);
            i++;
        }
        long stop_Time = System.currentTimeMillis();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem - beforeUsedMem;
        long tempo_exec = (stop_Time - start_Time);
        System.out.println("Execution time: " + tempo_exec + "ms");
        if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
        else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
        System.out.println("Path:" + v[1]);
        System.out.println("Path length:" + ( v[1].length() - 1));
           System.out.println(" nº nos criados : " + counter);
                System.out.println(" nº nos visitados : "+ counter2);
        return;
    }

    //Heuristicas

    public static int heuristicSum(int[] t_avaliar, int[] t_final) {

        int counter = 0;
        for(int i = 0; i < 16; i++)
            if(t_avaliar[i] != t_final[i])
                counter++;
        return counter;
    }
    public static int heuristicManhattan(int[] t_avaliar, int[] t_final) {

        int counter = 0;
        int pos = 0, j;
        for(int i = 0; i < 16; i++) {
            for(j = 0; j < 16; j++) {
                if(t_avaliar[i] == t_final[j]) {
                    pos = j;
                    break;
                }
            }
            int ii = i + 1;
            int poss = pos + 1;
            int pos1[] = {(ii % 4 != 0) ? ii / 4 + 1 : ii / 4, ii % 4 == 0 ? 4 : ii % 4};
            int pos2[] = {(poss % 4 != 0) ? poss / 4 + 1 : poss / 4, poss % 4 == 0 ? 4 : poss % 4};
            counter = counter + (pos1[0] >= pos2[0] ? pos1[0] - pos2[0] : pos2[0] - pos1[0])
                      + (pos1[1] >= pos2[1] ? pos1[1] - pos2[1] : pos2[1] - pos1[1]);
        }
        return counter;
    }

    //----------------------------

    //Heuristicas utilizadas : Sum of Different Tiles e Manhattan Distance

    static class SumComparator implements Comparator<Tabela> {

        //Override do metodo compare do Comparator
        public int compare(Tabela t1, Tabela t2) {
            if (heuristicSum(t1.arr, t1.solution) > heuristicSum(t2.arr, t2.solution))
                return 1;
            else if (heuristicSum(t1.arr, t1.solution) < heuristicSum(t2.arr, t2.solution))
                return -1;
            return 0;
        }
    }

    static class ManhattanComparator implements Comparator<Tabela> {

        //Override do metodo compare do Comparator
        public int compare(Tabela t1, Tabela t2) {
            if (heuristicManhattan(t1.arr, t1.solution) > heuristicManhattan(t2.arr, t2.solution))
                return 1;
            else if (heuristicManhattan(t1.arr, t1.solution) < heuristicManhattan(t2.arr, t2.solution))
                return -1;
            return 0;
        }
    }

    static class A_starComparator_Manhattan implements Comparator<Tabela> {

        //Override do metodo compare do Comparator
        public int compare(Tabela t1, Tabela t2) {
                    if (heuristicManhattan(t1.arr, t1.solution) + (t1.path.length() - 1) > heuristicManhattan(t2.arr, t2.solution) + (t2.path.length() - 1)) 
                return 1;
                return -1;
                  
        }
    }

     static class A_starComparator_TileSum implements Comparator<Tabela> {

        //Override do metodo compare do Comparator
        public int compare(Tabela t1, Tabela t2) {
                    if (heuristicSum(t1.arr, t1.solution) + (t1.path.length() - 1) > heuristicSum(t2.arr, t2.solution) + (t2.path.length() - 1)) 
                return 1;
                return -1;
                  
        }
    }



        public static void greedy_Alg_Manhattan(Tabela t_inicial, int[] t_final ) {

            long start_Time = System.currentTimeMillis();
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            PriorityQueue < Tabela > queue = new PriorityQueue <Tabela>(new ManhattanComparator());
            HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

            int counter = 0;
            int counter2 =0;

            queue.add(t_inicial);
            boolean flag = true;
            while (!queue.isEmpty()) {

                Tabela valor = queue.poll();


                String key = Arrays.toString(getArr(valor));
                if (!map.containsKey(key)) {
                    map.put(key, valor);
                    counter2++;
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


                if (equalsTabela(valor.arr, t_final)) {
                    long stop_Time = System.currentTimeMillis();
                    long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    long actualMemUsed = afterUsedMem - beforeUsedMem;
                    long tempo_exec = (stop_Time - start_Time);
                    System.out.println("Execution time: " + tempo_exec + "ms");
                    if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                    else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                    System.out.println("Path:" + valor.path);
                    System.out.println("Path length:" + (valor.path.length() - 1));
                    System.out.println(" nº nos criados: " + counter);
                    System.out.println(" nª nos visitados: " + counter2);
                    return;
                }
            }
        }



        public static void greedy_Alg_TileSum(Tabela t_inicial, int[] t_final) {

            long start_Time = System.currentTimeMillis();
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            PriorityQueue < Tabela > queue = new PriorityQueue <Tabela>(new SumComparator());
            HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

            int counter = 0;
            int counter2 =0;
            queue.add(t_inicial);

            while (!queue.isEmpty()) {

                Tabela valor = queue.poll();

                String key = Arrays.toString(getArr(valor));
                if (!map.containsKey(key)) {
                    map.put(key, valor);
                    counter2 ++;

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


                if (equalsTabela(valor.arr, t_final)) {
                    long stop_Time = System.currentTimeMillis();
                    long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    long actualMemUsed = afterUsedMem - beforeUsedMem;
                    long tempo_exec = (stop_Time - start_Time);
                    System.out.println("Execution time: " + tempo_exec + "ms");
                    if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                    else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                    System.out.println("Path:" + valor.path);
                    System.out.println("Path length:" + (valor.path.length() - 1));
                    System.out.println(" nº nos criados: " + counter);
                    System.out.println(" nº nos visitados: " + counter2);
                    return;
                }
            }
        }



        public static void a_star_M(Tabela t_inicial, int[] t_final ) {

            long start_Time = System.currentTimeMillis();
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            PriorityQueue < Tabela > queue = new PriorityQueue <Tabela>(new A_starComparator_Manhattan());
            HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

            int counter = 0;
            int counter2 =0;
            queue.add(t_inicial);
            boolean flag = true;
            while (!queue.isEmpty()) {

                Tabela valor = queue.poll();
                counter2 ++;

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


                if (equalsTabela(valor.arr, t_final)) {
                    long stop_Time = System.currentTimeMillis();
                    long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    long actualMemUsed = afterUsedMem - beforeUsedMem;
                    long tempo_exec = (stop_Time - start_Time);
                    System.out.println("Execution time: " + tempo_exec + "ms");
                    if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                    else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                    System.out.println("Path:" + valor.path);
                    System.out.println("Path length:" + (valor.path.length() - 1));
                    System.out.println(" nº nos criados : " + counter);
                    System.out.println(" nº nos visitados : "+ counter2);
                    return;
                }
            }
        }


         public static void a_star_TS(Tabela t_inicial, int[] t_final ) {

            long start_Time = System.currentTimeMillis();
            long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            PriorityQueue < Tabela > queue = new PriorityQueue <Tabela>(new A_starComparator_TileSum());
            HashMap < String, Tabela > map = new HashMap < String, Tabela > ();

            int counter = 0;
            int filhos =0;
            queue.add(t_inicial);
            boolean flag = true;
            while (!queue.isEmpty()) {

                Tabela valor = queue.poll();
                filhos ++;

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


                if (equalsTabela(valor.arr, t_final)) {
                    long stop_Time = System.currentTimeMillis();
                    long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    long actualMemUsed = afterUsedMem - beforeUsedMem;
                    long tempo_exec = (stop_Time - start_Time);
                    System.out.println("Execution time: " + tempo_exec + "ms");
                    if(actualMemUsed < 1000000)System.out.println("Memory used : " + actualMemUsed / 1000 + "Kb");
                    else System.out.println("Memory used : " + actualMemUsed / 1000000 + "MB");
                    System.out.println("Path:" + valor.path);
                    System.out.println("Path length:" + (valor.path.length() - 1));
                       System.out.println(" nº nos criados : " + counter);
                System.out.println(" nº nos visitados : "+ filhos);
                    return;
                }
            }
        }

    }




