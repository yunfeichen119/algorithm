package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class Solution102 {

  public class TreeNode {
    int val;
    Solution144.TreeNode left;
    Solution144.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, Solution144.TreeNode left, Solution144.TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    if(null == root){
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    while (queue.size() != 0){

      List<Integer> levelResult = new ArrayList<>();
      List<TreeNode> cacheList = new ArrayList<>();


      while (queue.size() != 0){
        cacheList.add(queue.remove());
      }

      for (TreeNode node : cacheList) {
        levelResult.add(node.val);

//        if(null != node.left){
//          queue.add(node.left);
//        }
//
//        if(null != node.right){
//          queue.add(node.right);
//        }

      }

      result.add(levelResult);

    }

    return result;

  }

}
