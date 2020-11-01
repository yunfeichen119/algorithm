package sort;

public class SelectSort {

  public static void sort(int[] arr){

    for(int i = 0; i < arr.length -1 ; i++){

      int min = arr[i];
      int minIndex = i;

      for(int j = i+1; j < arr.length; j++){
        if(arr[j] < min){
          min = arr[j];
          minIndex = j;
        }
      }

      if(i != minIndex){
        arr[minIndex] = arr[i];
        arr[i] = min;
      }

    }

  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9};


    sort(arr);

    System.out.println(arr);
  }

}
