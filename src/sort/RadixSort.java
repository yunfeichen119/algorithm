package sort;

import java.util.Arrays;

public class RadixSort {


  public static void sort(int[] sourceArray){

    int numMaxLen = getMaxNumLen(sourceArray);


    for(int loop = 0, mod = 10, div = 1; loop < numMaxLen; loop++, mod = mod * 10, div = div * 10){

      int buckets[][] = new int[10][0];

      //
      for(int val : sourceArray){
        int bucketIndex =  (val % mod) /div;
        buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], val);
      }

      //collect
      int pos = 0;
      for(int[] bucket : buckets){
        if(0 != bucket.length){
          for(int val : bucket){
            sourceArray[pos] = val;
            pos++;
          }
        }
      }



    }

  }

  public static int getMaxNumLen(int[] sourceArray){
    int max = sourceArray[0];

    for(int i = 0; i < sourceArray.length; i++){
      if(max < sourceArray[i]){
        max = sourceArray[i];
      }
    }

    int tmpMax = max;
    int length = 1;
    while(tmpMax > 10){
      tmpMax = tmpMax / 10;
      length++;
    }

    return length;

  }

  public static int[]  arrayAppend(int[] arr, int num){
    int[] tmp = Arrays.copyOf(arr, arr.length+1);
    tmp[arr.length] = num;
    return tmp;
  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9,5,4};


    sort(arr);

    System.out.println(arr);
  }

}
