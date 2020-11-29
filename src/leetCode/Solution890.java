package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution890 {

  public static List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> result = new ArrayList<>();

    for (String word : words) {
      boolean isOK = match(word, pattern);
      if(isOK){
        result.add(word);
      }
    }

    return result;

  }



  public static boolean match(String word, String pattern){
    if(word.length() != pattern.length()){
      return false;
    }

    Map<Character, Character> mapping = new HashMap<>();

    for(int i = 0; i < word.length(); i++){

      char w = word.charAt(i);
      char p = pattern.charAt(i);

      if(mapping.containsKey(p)){
        char val = mapping.get(p);

        if(val != w){
          return false;
        }
      }else{
        mapping.put(p, w);
      }

    }

    return true;
  }


  public static void main(String[] args){
    String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};

    String pattern = "abb";

    List<String> result = findAndReplacePattern(words, pattern);

    for (String tmp : result) {
      System.out.println(tmp);
    }


  }

}
