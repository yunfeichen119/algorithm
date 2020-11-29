package leetCode;

public class SolutionOffer62 {

  public int lastRemaining(int n, int m) {

    int[] space = new int[n];

    int del = 0;
    int counter = 0;

    while (true) {

      for (int i = 0; i < n; i++) {
        if (space[i] == 0) {
          counter++;
          if (counter == m) {
            counter = 0;
            space[i] = 1;
            del++;
            if (del == n - 1) {
              return getZeroIndex(space);
            }
          }
        }
      }
    }
  }


  public int getZeroIndex(int[] space){
    for(int i = 0; i < space.length; i++){
      if(space[i] == 0){
        return i;
      }
    }
    return 0;
  }

}
