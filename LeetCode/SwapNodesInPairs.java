//https://leetcode.com/problems/swap-nodes-in-pairs/
public class Solution {
    public ListNode SwapNodesInPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = head;
        while(first != null && second != null){
            first.next = second.next;
            second.next = first;
            if(head == first)
                head = second;
            else
                prev.next = second;
            prev = first;
            //advance the pointers
            first = first.next;
            if(first != null)
                second = first.next;
        }
        return head;
    }
}

