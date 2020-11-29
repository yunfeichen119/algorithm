package leetCode;

public class Solution6 {

  public static String convert(String s, int numRows) {
    boolean isFull = true;
    boolean isOdd  = (numRows %2) == 0;
    int maxMiddle = numRows / 2 + 1;
    int minMiddle = maxMiddle;
    if(isOdd){
      minMiddle = maxMiddle - 1;
    }

    String[] strArray = new String[numRows];

    int i = 0;

    while(i < s.length()){
      if(isFull){
        for(int innerK = 0; innerK < numRows && i < s.length(); innerK++,i++){
          strArray[innerK] = strArray[innerK] + s.charAt(i);
        }
        isFull = false;
      }else{
        if(isOdd){
          strArray[maxMiddle] = strArray[maxMiddle] + s.charAt(i);
          if(i < s.length() -1){
            i++;
            strArray[minMiddle] = strArray[minMiddle] + s.charAt(i);
          }
        }else{
          strArray[minMiddle] = strArray[minMiddle] + s.charAt(i);
        }
        isFull = true;
      }
    }


    StringBuilder sb = new StringBuilder();
    for(int k = 0; k < numRows; k++){
      sb.append(strArray[k]);
    }

    return sb.toString();
  }



  public static void main(String[] args){
    String s = "LEETCODEISHIRING";
    int numRows = 4;
    String result = convert(s, numRows);
    System.out.println(result);
  }
}
