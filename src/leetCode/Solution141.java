package leetCode;


import java.util.HashMap;
import java.util.Map;

public class Solution141 {


    public static boolean hasCycle(ListNode head) {
        Map<ListNode, Object> hashMap = new HashMap<>();


        ListNode pointer = head;
        while(pointer != null){
            if(hashMap.containsKey(pointer)){
                return true;
            }
            hashMap.put(pointer, 1);
            pointer = pointer.next;
        }
        return false;
    }


    public static void main(String[] args){

        ListNode node4 = new ListNode(-4);
        node4.next = null;

        ListNode node3 = new ListNode(0);
        node3.next = node4;

        ListNode node2 = new ListNode(2);
        node2.next = node3;


        ListNode node1 = new ListNode(3);
        node1.next = node2;

        node4.next = node2;


        boolean ret = hasCycle(node1);

        System.out.println(ret);


    }
}
