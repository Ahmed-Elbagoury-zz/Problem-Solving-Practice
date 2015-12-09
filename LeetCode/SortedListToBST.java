//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class SortedListToBST{
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        //Counting the size of the list
        int size = 0;
        ListNode ptr = head;
        while(ptr != null){
            size++;
            ptr = ptr.next;
        }
        return constructBST(head, size);
    }
    
    public TreeNode constructBST(ListNode head, int size){
        if(size <= 0)
            return null;
        int mid = size/2;
        ListNode midPtr = head;
        //Set the midPtr
        for(int i = 0; i < mid; i++){
            midPtr = midPtr.next;
        }
        //Create the root node
        TreeNode root = new TreeNode(midPtr.val);
        //Create the left subtree
        root.left = constructBST(head, mid);
        //Create the right substree
        root.right = constructBST(midPtr.next, size - mid - 1);
        return root;
    }

}