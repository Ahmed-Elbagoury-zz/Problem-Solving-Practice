/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int size = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr = ptr.next;
            size++;
        }
        int halfCount = 0;
        ListNode left = head;
        ListNode right = null;
        ptr = head;
        while(halfCount <= size/2 - 1){
            ListNode next = ptr.next;
            if(halfCount == size/2 - 1){
                ptr.next = null;
                right = next;
                break;
            }
            halfCount++;
            ptr = next;
        }
        left = sortList(left);
        right = sortList(right);
        return mergeLists(left, right);
    }
    
    private ListNode mergeLists(ListNode p1, ListNode p2){
        if(p1 == null)
            return p2;
        if(p2 == null)
            return p1;
        ListNode curP1 = p1;
        ListNode curP2 = p2;
        ListNode head = null;
        ListNode cur = null;
        while(curP1 != null && curP2 != null){
            ListNode temp;
            if(curP1.val < curP2.val){
                temp = curP1;
                curP1 = curP1.next;
            }
            else{
                temp = curP2;
                curP2 = curP2.next;
            }
            if(cur == null){
                head = temp;
                cur = head;
            }
            else{
                cur.next = temp;
                cur = cur.next;
            }
        }
        ListNode temp = curP1 == null ? curP2: curP1;
        while(temp != null){
            cur.next = temp;
            temp = temp.next;
            cur = cur.next;
        }
        
        return head;
    }
}
