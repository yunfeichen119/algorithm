package backtrackingAlgorithm;

/*
全排列
https://leetcode-cn.com/problems/permutations/
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        Stack<Integer> path = new Stack<>();
        dfs(path, nums, result);
        return result;
    }

    public void dfs(Stack<Integer> path, int[] nums, List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i :nums) {
            if(path.contains(i)){
                continue;
            }
            path.push(i);
            dfs(path, nums, result);
            path.pop();
        }
    }

    public void main(String[] args){
        int[] nums = {1,2 ,3};
        List<List<Integer>> result = permute(nums);

    }
}
