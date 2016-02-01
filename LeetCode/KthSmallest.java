/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode ptr = root;
        while(k > 0){
            if(ptr == null){
                k--;
                ptr = stack.pop();
                if(k == 0)
                    return ptr.val;
                ptr = ptr.right;    
            }
            else{
                stack.push(ptr);
                ptr = ptr.left;
            }
        }
        return -1;
    }
}
