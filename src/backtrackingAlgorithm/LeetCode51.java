package backtrackingAlgorithm;

/*
N皇后
https://leetcode-cn.com/problems/n-queens/
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    int[] queens;
    int[] cols;
    int[] left;
    int[] right;
    List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        cols = new int[n];
        left = new int[2*n+1];
        right = new int[2*n+1];
        output = new ArrayList<>();
        backtrack(0);
        return output;
    }


    public void backtrack(int row){
        for(int col = 0; col < n; col++){
            if(isSafe(row, col)){
                addQueen(row, col);
                if(row + 1 == n){
                    formatOutput();
                }else{
                    backtrack(row+1);
                }
                removeQueen(row, col);
            }

        }
    }


    public void addQueen(int row, int col){
        queens[row] = col;
        cols[col] = 1;
        left[row+col] = 1;
        right[row-col+n-1] = 1;
    }

    public void removeQueen(int row, int col){
        queens[row] = 0;
        cols[col] = 0;
        left[row+col] = 0;
        right[row-col+n-1] = 0;
    }

    public boolean isSafe(int row, int col){
        if(cols[col] == 0 && left[row+col] == 0 && right[row-col+n-1]==0){
            return true;
        }
        return false;
    }

    public void formatOutput(){
        List<String> ret = new ArrayList<>();
        for(int index = 0; index < n; index++){
            StringBuilder sb = new StringBuilder();
            int col = queens[index];
            for(int i = 0; i < col; i++){
                sb.append(".");
            }
            sb.append("Q");
            for(int i = col + 1; i < n; i++){
                sb.append(".");
            }
            ret.add(sb.toString());
        }
        output.add(ret);
    }
}


public class LeetCode51{

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<String>> ret = solution.solveNQueens(4);
        System.out.println(ret);

    }
}
