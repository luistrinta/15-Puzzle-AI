public class Parity{


 static boolean checkParity(int[][] values,int linha,int coluna){

//Obtemos matriz ordenada
   while(linha!=3){
     int nextline = linha+1;
     int temp = values[linha][coluna];
    values[linha][coluna] = values[nextline][coluna];
    values[nextline][coluna]=temp;
    linha++;

  }

   while(coluna!=3){
      int nextcol = coluna+1;
      int temp = values[linha][coluna];
     values[linha][coluna] = values[linha][nextcol];
     values[linha][nextcol]=temp;
     coluna++;

        }

      int[] arr = getArray(values);

      boolean finalCount = finalCounter(arr);

      return finalCount;
   }


   static int[] getArray(int[][] values){
     int[] arr = new int[16];
     int counter =0;
     for (int i =0;i< 4 ;i++ ) {
       for (int j =0;j < 4 ;j++ ) {
           arr[counter]=values[i][j];
           counter++;
       }
     }
     return arr;
   }



 static boolean finalCounter(int[] arr){
   int counter = 0;
   for(int i =0 ; i < arr.length ; i++){
       int number = arr[i];
       for(int j = i ; j < arr.length;j++){
         if(number > arr[j] && arr[j] != 0)
           counter++;
         }
       }
       if(counter%2 == 0)
       return true;

       else return false;
     }
 }
