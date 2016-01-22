/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode evenHead = evenPtr;
        ListNode lastOddPtr = oddPtr;
        while(oddPtr != null && evenPtr != null){
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            if(oddPtr != null){
            	lastOddPtr = oddPtr;
                evenPtr.next = oddPtr.next;
                evenPtr = evenPtr.next;
            }
        }
        lastOddPtr.next = evenHead;
        return head;
    }
}
