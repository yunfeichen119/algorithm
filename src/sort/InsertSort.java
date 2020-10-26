package sort;

public class InsertSort {

  public static void sort(int[] arr){

    for(int i = 1; i < arr.length; i++){
      int tmp = arr[i];
      int tmpIndex = i;
      for(int j = i -1; j >= 0; j--){
        if(tmp < arr[j]){
          arr[j+1] = arr[j];
          tmpIndex = j;
        }
      }
      arr[tmpIndex] = tmp;
    }
  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9};


    sort(arr);

    System.out.println(arr);
  }

}
