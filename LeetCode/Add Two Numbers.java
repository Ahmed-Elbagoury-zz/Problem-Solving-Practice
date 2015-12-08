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
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        int sum = 0;
        ListNode result = null;
        ListNode tail = null;
        while(l1 != null || l2 != null || carry != 0){
            sum = (l1 == null? 0 : l1.val) + (l2 == null ? 0: l2.val) + carry;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            carry = sum/10;
            sum %= 10;
            if(result == null){
                result = new ListNode(sum);
                tail = result;
            }
            else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
        }
        return result;
    }

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0 : l2.val;
            int val3 = val1 + val2 + carry;
            carry = val3 /10;
            val3 = val3 % 10;
            cur.next = new ListNode(val3);
            cur = cur.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }
}

