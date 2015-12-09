//http://oj.leetcode.com/problems/merge-k-sorted-lists/
public class MergeKLists{
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
       	public int compare(ListNode a, ListNode b){
       		if(a.val < b.val)
       			return -1;
       		else if(a.val == b.val)
       			return 0;
       		return 1;
       	}
        });
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
    			 pq.add(lists[i]);
    			 lists[i] = lists[i].next;
            }
        }
        
        ListNode head = null;
        ListNode ptr = null;
        while(pq.size() > 0){
        	 ListNode cur = pq.poll();
        	 if(head == null){
        		 head = cur;
        		 ptr = cur;
        	 }
        	 else{
        		 ptr.next = cur;
        		 ptr = ptr.next;
        	 }
        	 if(cur.next != null)
        		 pq.add(cur.next);
        }
        return head;
    }

}