import java.util.*;
public class Verifier1{
  static boolean isRight(int[] arr){
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    //Verificar se tem 16 elementos
    if(arr.length!=16)return false;
    //Verificar se os elemnentos são entre 0 e 15
    for(int i=0;i<=15;i++)if(arr[i]!=i) return false;
    return true;
  }
}
