//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class DeleteDuplicates2{
	public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return head;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> dup = new HashSet<Integer> ();
        ListNode cur = head;
      
        
        
        ListNode prev = null;
        cur = head;
        
        while(cur != null){
            int val = cur.val;
            if(!set.contains(val)){
                set.add(val);
                prev = cur;
            }
            else{
                dup.add(val);
                if(prev != null) prev.next = cur.next;
                else head = cur.next;
            }
            cur = cur.next;   
        }
        cur = head;
        prev = null;
        while(cur != null){
            if(dup.contains(cur.val)){
                if(prev != null) prev.next = cur.next;
                else head = cur.next;
            }
            else{
            	prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}