import java.util.*;
public class test extends heuristic {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //BFS test
        int[] t_arr = new int[16];
        int[] t2_arr = new int[16];

        Tabela t_inicial = new Tabela(t_arr);
        Tabela t_final = new Tabela(t2_arr);

        scanTabela(t_inicial);
        scanTabela(t_final);
        boolean init = testSolvability(t_inicial);
        boolean fin = testSolvability(t_final);
        if (init && fin) {
			System.out.print("\033[H\033[2J");
			//Runtime.getRuntime().exec("cls");
			System.out.printf("###################\n1.BFS\n2.DFS\n3.IDFS\n4.A*\n5.Greedy\n6.All\n\nOption:");
			Scanner scan = new Scanner(System.in);
			int option=scan.nextInt();
			//int option=6;
			switch ((int)option){
				case 1: System.out.printf("\n###################\n\n|__BFS__|\n");
						BFS(t_inicial, t_final);
						break;
				case 2: System.out.printf("\n###################\n\n|__DFS__|\n");
					   	/*System.out.printf("Insert depth\n");
						Scanner scan = new Scanner(System.in);*/
            			DFS(t_inicial, t_final, 80/*scan.nextInt())*/);
						break;
				case 3: System.out.printf("\n###################\n\n|__IDFS__|\n");
						IDFS(t_inicial,t_final);
						break;
				case 4:break;
				case 5:break;
				case 6: System.out.printf("\n###################\n\n|__BFS__|\n");
						BFS(t_inicial, t_final);
						System.out.printf("\n###################\n\n|__DFS__|\n");
            			DFS(t_inicial, t_final, 80);
            			System.out.printf("\n###################\n\n|__IDFS__|\n");
						IDFS(t_inicial,t_final);
			}
           
            
            

        } else {
            if (!init)
                System.out.println("Invalid puzzle grid");

            else System.out.println("Invalid puzzle solution");
        }
    }
}
