package leetCode;

public class ReverseStringII {

  public static String reverseStr(String s, int k) {

    int len = s.length();

    StringBuilder sb = new StringBuilder();

    int subStart = 0;

    int subEnd = subStart + 2 * k - 1;

    if(subEnd > len - 1){
      subEnd = len -1 ;
    }

    while(true){

      if(subEnd - subStart + 1 < k){

        for(int i = subEnd; i >= subStart; i--){
          sb.append(s.charAt(i));
        }


      }else if(subEnd - subStart + 1 >= k){
        for(int i = subStart + k -1 ; i >= subStart; i--){
          sb.append(s.charAt(i));
        }

        for(int i = subStart + k; i <= subEnd; i++){
          sb.append(s.charAt(i));
        }
      }

      subStart = subEnd + 1;
      if(subStart > len - 1){
        break;
      }

      subEnd = subStart + 2 * k -1;

      if(subEnd > len - 1){
        subEnd = len -1 ;
      }


    }

    return sb.toString();

  }



  public static String reverseStrV2(String s, int k) {

    char[] arr = s.toCharArray();

    for(int start = 0; start < arr.length; start += 2 * k){
      int i = start;
      int j = Math.min(start + k - 1, arr.length -1);
      while (i < j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }

    return new String(arr);
  }


  public static void main(String[] args){
    String s = "abcdefg";
    int k = 2;

    String str = reverseStr(s, k);

    System.out.println(str);
  }

}
