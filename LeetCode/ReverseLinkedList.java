/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     public ListNode reverseListIterative(ListNode head) {
         if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = p2;
        ListNode nextNext = p2.next;
        ListNode prev = null;
        while(p2 != null){
            p1.next = prev;
            p2.next = p1;
            prev = p1;
            p1 = p2;
            newHead = p2;
            p2 = nextNext;
            if(nextNext != null)
                nextNext = nextNext.next;
        }
        return newHead;
    }
    
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
