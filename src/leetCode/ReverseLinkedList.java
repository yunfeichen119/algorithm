package leetCode;



//class ListNode {
//  int val;
//  ListNode next;
//  ListNode(int x) { val = x; }
//}

//https://leetcode-cn.com/problems/reverse-linked-list/

public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {

    if(null == head){
      return null;
    }

    ListNode newHead = null;


    ListNode p = head;
    while (p != null){
      ListNode node = new ListNode(p.val);
      if(null == newHead){
        newHead = node;
      }else{
        node.next = newHead;
        newHead = node;
      }


      p = p.next;
    }

    return newHead;

  }

}
