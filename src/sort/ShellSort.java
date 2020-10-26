package sort;

public class ShellSort {

  public static void sort(int[] arr){

    int gap = arr.length / 2;

    while (gap >=1){
      for(int i = gap; i < arr.length; i+=gap){
        int tmp = arr[i];
        int tmpIndex = i;

        for(int j = i - gap; j >= 0; j -= gap){
          if(tmp < arr[j]){
            arr[j+gap] = arr[j];
            tmpIndex = j;
          }
        }

        arr[tmpIndex] = tmp;
      }

      gap = gap /2;
    }

  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9};


    sort(arr);

    System.out.println(arr);
  }


}
