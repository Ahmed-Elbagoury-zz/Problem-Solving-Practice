//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum{
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        //Calculate the sum of the tree rooted at the root node
        int total = root.val;
        if(left > 0)
            total += left;
        if(right > 0)    
            total += right;
        max = max > total ? max : total;
        //Calculate the max sum if the current node (root) is part of the max pat
        total = root.val;
        total = Math.max(total, Math.max(total+left, total+right));
        return total;
    }

}
