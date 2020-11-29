package leetCode;

public class Solution206 {

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseList(ListNode head) {

    ListNode result = null;
    ListNode pointer = result;
    ListNode node = head;
    while(node != null){
      ListNode tmp = new ListNode(node.val);
      tmp.next = result;

      result = tmp;

      node = node.next;

    }

    return result;

  }
}