package leetCode;

//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/


/*

 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution144 {


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


  public List<Integer> preorderTraversal2(TreeNode root) {

    List<Integer> ret = new ArrayList<>();

    if(null != root){
      ret.add(root.val);
      ret.addAll(preorderTraversal(root.left));
      ret.addAll(preorderTraversal(root.right));
    }

    return ret;

  }




  public List<Integer> preorderTraversal(TreeNode root) {

    if(null == root){
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode current = root;


    while(true){
      result.add(current.val);
      if(null == current.left && null == current.right && stack.size() == 0){
        return result;
      }
      if(null == current.left && null == current.right){
        current = stack.pop();
        continue;
      }

      if(null != current.left && null == current.right){
        current = current.left;
        continue;
      }

      if(null == current.left && null != current.right){
        current = current.right;
        continue;
      }

      if(null != current.left && null != current.right){
        current = current.left;
        stack.push(current.right);
        continue;
      }
    }

  }


}
