package leetCode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
}


public class SolutionOffer06 {


    public static int[] reversePrint(ListNode head) {
        if(null == head){
            return new int[0];
        }

        int count = 0;

        ListNode result = null;

        ListNode loopNode  = head;

        while(loopNode != null){
            ListNode tmp = new ListNode(loopNode.val);
            tmp.next = result;

            result = tmp;

            loopNode = loopNode.next;

            count++;
        }

        int[] arr = new int[count];
        int i = 0;
        loopNode = result;
        while(loopNode != null){
            arr[i] = loopNode.val;
            loopNode = loopNode.next;
            i++;

        }

        return arr;



    }


    public static void main(String[] args){
        ListNode node3 = new ListNode(2);
        node3.next = null;

        ListNode node2 = new ListNode(3);
        node2.next = node3;


        ListNode node1 = new ListNode(1);
        node1.next = node2;

        int[] ret = reversePrint(node1);

        System.out.println(ret);


    }
}
