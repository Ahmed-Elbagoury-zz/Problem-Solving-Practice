/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) 
            return null;
        boolean hasCycle = false;    
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle)
            return null;
        fast = head;
        while(fast != null && fast.next != null){
            if(fast == slow)
                return fast;
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
}
