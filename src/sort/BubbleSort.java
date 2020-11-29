package sort;

public class BubbleSort {


  public static void sort(int[] arr){

   for(int i = 0; i < arr.length -1; i++){
     boolean swap = false;
     for(int j = 0; j < arr.length-i-1; j++){
       if(arr[j] > arr[j+1]){
         int tmp = arr[j];
         arr[j] = arr[j+1];
         arr[j+1] = tmp;
         swap = true;
       }
     }

     if(!swap){
       return;
     }
   }

  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9};


    sort(arr);

    System.out.println(arr);
  }
}
