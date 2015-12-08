//http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
public class DeleteDuplicates{
	public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return head;
        
        HashSet <Integer> set = new HashSet<Integer> ();
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null) {
            int val = cur.val;
            if(set.contains(val)){
                //Remove the duplicate
                if(prev != null) prev.next = cur.next;
                else head = head.next;
            }
            else{
                set.add(new Integer (val));
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}