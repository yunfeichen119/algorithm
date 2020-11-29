package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

  public static class BTNode {
    public int data;
    public BTNode left;
    public BTNode right;
  }

  public void preOrder(BTNode root){
    if(null == root){
      return;
    }

    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
  }


  public void preOrderNoRecursive(BTNode root){
    if(null == root){
      return;
    }

    Deque<BTNode> stack = new LinkedList<>();

    stack.push(root);
    while (!stack.isEmpty()){
      BTNode node = stack.pop();
      System.out.println(node.data);
      if(null != node.right){
        stack.push(node.right);
      }

      if(null != node.left){
        stack.push(node.left);
      }
    }


  }


  public void inOrder(BTNode root){
    if(null == root){
      return;
    }

    inOrder(root.left);
    System.out.println(root.data);
    inOrder(root.right);
  }


  public void postOrder(BTNode root){
    if(null == root){
      return;
    }

    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
  }





  public void create(){

  }


  public BTNode find(BTNode root, int target){
    if(null == root){
      return null;
    }

    if(root.data == target){
      return root;
    }else{
      BTNode ret = find(root.left, target);
      if(null != ret){
        return ret;
      }else{
        return find(root.right, target);
      }
    }
  }


  public int height(BTNode root){
    if(null == root){
      return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }



  public void bfs(BTNode root){
    if(null == root){
      return;
    }

    Queue<BTNode> queue = new LinkedList<>();

    queue.add(root);


    while(!queue.isEmpty()){
      BTNode node = queue.remove();
      System.out.println(node.data);
      if(null != node.left){
        queue.add(node.left);
      }
      if(null != node.right){
        queue.add(node.right);
      }
    }

  }


  public void sequence(BTNode root){
    List<Integer> result = new LinkedList<>();

    walk(root, result);

  }


  private void walk(BTNode root, List<Integer> result){
    if(null == root){
      result.add(null);
      return;
    }

    result.add(root.data);

    walk(root.left, result);

    walk(root.right, result);

  }


  public BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q){
    return null;
  }


  private BTNode search(BTNode root, BTNode p, BTNode q){
    if(root == null){
      return null;
    }

    if(root.equals(p) || root.equals(q)){
      return root;
    }

    BTNode left = search(root.left, p, q);

    BTNode right =search(root.right, p, q);

    //if()
    return null;
  }



  public static void main(String[] args){

  }



  public void bfs2(BTNode root){
    if(null == root){
      return;
    }

    Queue<BTNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()){
      BTNode node = queue.remove();
      if(null != node.left){
        queue.add(node.left);
      }

      if(null != node.right){
        queue.add(node.right);
      }
    }


  }



}
