package sort;

public class CountingSort {


  public static void sort(int[] source){
    if(null == source || source.length == 0){
      return;
    }

    int max = getMaxValue(source);

    int[] bucket = new int[max+1];


    for(int val : source){
      bucket[val]++;
    }

    int targetIndex = 0;
    for(int index = 0; index < bucket.length; index++){
      while(bucket[index] != 0){
        source[targetIndex] = index;
        targetIndex++;
        bucket[index]--;
      }
    }
  }

  private static int getMaxValue(int[] source){
    int max = source[0];

    for(int i = 1; i < source.length; i++){
      if(max < source[i]){
        max = source[i];
      }
    }

    return max;
  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9,5,4};


    sort(arr);

    System.out.println(arr);
  }

}
