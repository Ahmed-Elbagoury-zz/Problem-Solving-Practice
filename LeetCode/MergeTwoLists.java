http://oj.leetcode.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode curNode = null;
        ListNode newHead = null;
        if(l1.val < l2.val){
                newHead = l1;
                l1 = l1.next;
            }
            else{
                newHead = l2;
                l2 = l2.next;
            }
        curNode = newHead;    
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }
            else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        ListNode temp = l1 == null ? l2 : l1;
        while(temp != null){
           curNode.next = temp;
            temp = temp.next;
            curNode = curNode.next;
        }
        curNode.next = null;
        return newHead;
    }
}