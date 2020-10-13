package backtrackingAlgorithm;


import java.util.ArrayList;
import java.util.List;

class EightQueenslcci {

    //路径
    private int[]   queens; //已摆放的queen

    //选择
    private int[]   cols; //不能摆放的列
    private int[]   left; //
    private int[]   right;

    private int n;

    List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        cols = new int[n];
        left = new int[2*n-1];
        right = new int[2*n-1];

        output = new ArrayList<>();

        backtrack(n);

        return output;
    }



    public void backtrack(int row){

        for(int col = 0; col < n; col++){
            if(row == n){
                formatOutput();
                return;
            }
            if(isSafe(row, col)){
                choose(row, col);

                    backtrack(row + 1);

                cancel(row, col);
            }
        }
    }


    public void choose(int row, int col){
        queens[row] = col;
        cols[col] = 1;
        left[row - col + n -1 ] = 1;
        right[row + col] = 1;
    }

    public void cancel(int row, int col){
        queens[row] = 0;
        cols[col] = 0;
        left[row - col + n -1 ] = 0;
        right[row + col] = 0;
    }

    public boolean isSafe(int row, int col){
        if(cols[col] == 1){
            return false;
        }

        if(left[row - col + n -1 ] == 1){
            return false;
        }

        if(right[row + col] == 1){
            return false;
        }

        return true;

    }


    public void formatOutput(){
        for(int i = 0; i < n; i++){
            int pos = queens[i];
            List<String> row = new ArrayList<>();
            for(int j = 0; j < pos; j++){
                row.add(".");
            }
            row.add("Q");
            for(int k = pos+1; k < n; k++){
                row.add(".");
            }

            output.add(row);
        }
    }
}



