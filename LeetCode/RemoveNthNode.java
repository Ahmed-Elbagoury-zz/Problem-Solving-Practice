//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode slow = head;
        ListNode fast = head;
        for(int i =0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //Move the pointer to the (n-1)-th node
        ListNode ptr = head;
        int size = 0;
        while(ptr != null){
            ptr = ptr.next;
            size ++;
        }
        if(size < n)
            return head;
        if(size == n)
            return head.next;
        ptr = head;
        for(int i = 0; i < size-n-1; i++)
            ptr = ptr.next;
        ptr.next = ptr.next.next;
        return head;
    }
}

