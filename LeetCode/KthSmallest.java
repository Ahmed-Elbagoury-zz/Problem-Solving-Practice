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
        if(root == null)
            return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while(k >= 0){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }
            else{
                if(stack.isEmpty())
                    return -1;
                curNode = stack.pop();
                k--;
                if(k == 0)
                    return curNode.val;
                curNode = curNode.right;    
            }
        }
        return -1;
    }
}
