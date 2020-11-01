package sort;

public class BubbleSort {


  public static void sort(int[] arr){

    boolean swap = false;

    for(int i = 0; i < arr.length -1; i++){
      for(int j = i+1; j < arr.length; j++){
        if(arr[i] > arr[j]){
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;

          swap = true;
        }
      }


      if(!swap){

      }
    }

  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9};


    sort(arr);

    System.out.println(arr);
  }
}
