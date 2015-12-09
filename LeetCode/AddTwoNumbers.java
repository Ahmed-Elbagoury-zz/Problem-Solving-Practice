//http://oj.leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode head = null;
        ListNode curRes = head;
        while(l1 != null || l2 != null){
            int result = carry;
            if(l1 != null){
                result += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                result += l2.val;
                l2 = l2.next;
            }
            carry = result /10;
            ListNode temp = new ListNode(result % 10);
            if(curRes == null){
                head = temp;
                curRes = temp;
            }
            else{
                curRes.next = temp;
                curRes = curRes.next;
            }
        }
        if(carry != 0) curRes.next = new ListNode(carry);
        return head;
    }
}