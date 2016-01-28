/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2){
            return head;
        }
        ListNode curHead = head;
        ListNode curTail = head;
        ListNode prevTail = null;
        while(curHead != null){
            for(int i = 0; i < k-1; i++){
                if(curTail == null){
                    return head;
                }
                else{    
                    curTail = curTail.next;
                }
            }
            if(curTail == null)
                return head;
            if(prevTail != null)
                prevTail.next = curTail;
            ListNode next = curTail.next;
            curTail.next = null;
            reverse(curHead, curTail);
            if(curHead == head){
                head = curTail;    
            }
            prevTail = curHead;
            curHead.next = next;
            curHead = next;
            curTail = curHead;
        }
        return head;
    }
    
    public void reverse(ListNode curHead, ListNode curTail){
        ListNode ptr = curHead;
        ListNode next = curHead.next;
        curHead.next = null;
        while(next != null){
            ListNode nextNext = next.next;
            next.next = ptr;
            ptr = next;
            next = nextNext;
        }
    }
}
