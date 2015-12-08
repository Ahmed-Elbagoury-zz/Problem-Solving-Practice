//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
            if(head == null || n == 0)   return head;
            ListNode temp = head;
            int len = 0;
            ListNode tail = head;
            while (temp != null){
                temp = temp.next;
                if(temp != null) tail = tail.next;
                len++;
            }
            if(len == 1) return head;
            n = n %len;
            if(n == 0) return head;
            ListNode newHead = head.next;
            ListNode pre = head;
            for(int i = 1; i < len-n; i++){
                pre = pre.next;
                newHead = newHead.next;
            }
            tail.next = head;
            pre.next = null;
            head = newHead;
            return head;
    }
}
