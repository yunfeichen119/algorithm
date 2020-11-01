package sort;

import java.util.Arrays;

public class BucketSort {


  private static final InsertSort insertSort = new InsertSort();


  public static void sort(int[] source){

    int bucketSize = 5;

    int min = source[0];
    int max = source[0];

    for(int val : source){
      if(min > val){
        min = val;
      }
      if(max < val){
        max = val;
      }
    }

    int bucketStep = ((max - min) / bucketSize) + 1;

    int[][] buckets = new int[bucketSize][0];


    for(int val : source){
      int bucketIndex = (val - min) / bucketStep;
      buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], val);
    }

    for(int[] bucket : buckets){
      if(0 != bucket.length){
        insertSort.sort(bucket);
      }
    }


    int appendIndex = 0;
    for(int[] bucket : buckets){
      if(0 != bucket.length){
        for(int val : bucket){
          source[appendIndex] = val;
          appendIndex++;
        }
      }
    }


  }



  public static int[] arrayAppend(int[] arr, int val){
    int[] newArray = Arrays.copyOf(arr, arr.length+1);
    newArray[arr.length] = val;
    return newArray;
  }


  public static void main(String[] args){
    int[] arr = new int[]{6,5,1,4,9,5,4};


    sort(arr);

    System.out.println(arr);
  }

}
