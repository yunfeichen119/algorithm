package backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution40 {

    List<List<Integer>> output;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        output = new ArrayList<>();

        Stack<Integer> path = new Stack<>();
        backtrack(candidates, target, 0, path);

        return output;
    }

    public void backtrack(int[] candidates, int target, int start, Stack<Integer> path){
//        if(path.size() == candidates.length - start){
//            return;
//        }
        for (int index = start; index < candidates.length; index++){
            path.push(candidates[index]);
            int pathSum = sum(path);
            if(pathSum <= target){
                if(pathSum == target){
                    addOutput(path);
                }else{
                    backtrack(candidates, target, index+1, path);
                }

            }
            path.pop();
        }
    }


    public void addOutput(Stack<Integer> path){
        List<Integer> tmp = new ArrayList<>(path);
        Collections.sort(tmp);
        if(!contain(output, tmp)){
            output.add(tmp);
        }

    }


    public boolean contain(List<List<Integer>> output, List<Integer> tmp){
        for (List<Integer> slice : output) {
            if(isEqual(slice, tmp)){
                return true;
            }
        }
        return false;
    }

    public boolean isEqual(List<Integer> l1, List<Integer> l2){
        if(l1.size() != l2.size()){
            return false;
        }
        for(int i = 0; i < l1.size(); i++){
            if(!l1.get(i).equals(l2.get(i))){
                return false;
            }
        }
        return true;
    }

    public int sum(Stack<Integer> path){
        int sum = 0;
        for (int u : path) {
            sum += u;
        }
        return sum;
    }
}

public class LeetCode40 {

    public static void main(String[] args){
        Solution40 solution40 = new Solution40();
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>>  ret = solution40.combinationSum2(candidates, target);
        System.out.println(ret);

    }
}
