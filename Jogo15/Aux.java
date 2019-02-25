import java.util.*;
public class Aux extends Tabela
{
    static void BFS(Tabela t_inicial, Tabela t_final)
    {
        //variavel de incrememnto do numero de nos
        Queue<Tabela> queue = new LinkedList<>();
        queue.add(t_inicial);
        boolean flag = true;
        int counter = 0;
        while(flag)
        {
            counter++;
            Tabela t = queue.poll();
            Tabela valor = copyTabela(t);
            String[] s = checkMoves(valor);
            for(String str : s)
            {
                if(str != null)
                {
                    Tabela t2 = moveTabela(str, valor);
                    queue.add(t2);
                }
            }
            if(equalsTabela(valor, t_final))
            {
                flag = false;
                System.out.println("Done in " + counter + " steps!");
                System.out.println("Path:" + valor.path);
                System.out.println("Path length:" + valor.path.length());
            }
        }
    }
    static boolean testSolvability(Tabela t)
    {
        return true;
    }
    static boolean isRight(int[] arr)
    {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //Verificar se tem 16 elementos
        if(arr.length != 16)return false;
        //Verificar se os elemnentos são entre 0 e 15
        for(int i = 0; i <= 15; i++)if(arr[i] != i) return false;
        return true;
    }
}