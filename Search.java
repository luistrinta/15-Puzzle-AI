public class Search extends Parity{

public static boolean Blanksearch(int[][] values){
  int coluna =0;
  int linha = 0;
  for(int i =0 ; i < 4 ;i++){
    for(int j =0 ; j < 4 ;j++){
        if(values[i][j] == 0){
          linha = i;
          coluna = j;
          boolean flag = checkParity(values,linha , coluna);

          return flag;
        }
      }
}
return false;
}




}
