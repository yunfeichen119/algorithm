package leetCode;

public class Solution415 {


  public static String add(String num1, String num2){

    StringBuilder sb = new StringBuilder();

    byte plus = 0;
    int i, j;

    for(i = num1.length() - 1,  j = num2.length()-1; i >= 0 && j >= 0; i--,j--){
      char c1 = num1.charAt(i);
      char c2 = num2.charAt(j);

      int tmp = c1 - '0' + c2 - '0' + plus;
      if(tmp >= 10){
        plus = 1;
      }else{
        plus = 0;
      }

      char ch = (char)(tmp % 10 + '0');

      sb.append(ch);
    }

    while(i >= 0){

      char c1 = num1.charAt(i);
      int tmp = c1 - '0' + plus;
      if(tmp >= 10){
        plus = 1;
      }else{
        plus = 0;
      }

      char ch = (char)(tmp % 10 + '0');

      sb.append(ch);

      i--;
    }

    while(j >= 0){


      char c2 = num2.charAt(j);

      int tmp =  c2 - '0' + plus;
      if(tmp >= 10){
        plus = 1;
      }else{
        plus = 0;
      }

      char ch = (char)(tmp % 10 + '0');

      sb.append(ch);

      j--;
    }

    String result = sb.reverse().toString();

    return result;

  }



  public static void main(String[] args){
    String num1 = "1999";
    String num2 = "32";

    String result = add(num1, num2);

    System.out.println(result);
  }

}
