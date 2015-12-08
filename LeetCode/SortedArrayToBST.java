//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return convert(num, 0, num.length-1);
    }
    
    public TreeNode convert (int [] num, int st, int end){
        if(st == end) return new TreeNode(num[st]);
        if(st > end) return null;
        int mid = (end-st)/2 + st;
        TreeNode root = new TreeNode (num[mid]);
        TreeNode l = convert (num, st, mid-1);
        TreeNode r = convert (num, mid+1, end);
        root.left = l;
        root.right = r;
        return root;
    }
}

