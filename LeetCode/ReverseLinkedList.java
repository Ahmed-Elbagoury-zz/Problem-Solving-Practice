/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode newHead = reverseListHelper(head);
        head.next = null;
        return newHead;
    }
    
    public ListNode reverseListHelper(ListNode cur){
        if(cur.next == null)
            return cur;
        ListNode newHead = reverseListHelper(cur.next);
        ListNode next = cur.next;
        next.next = cur;
        return newHead;
    }
}
