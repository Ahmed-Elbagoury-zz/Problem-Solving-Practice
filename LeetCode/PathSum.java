//http://oj.leetcode.com/problems/path-sum/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        int newSum = sum - root.val;
        if(root.left == null && root.right == null && newSum == 0) return true;
        boolean result = false;
        if(root.left != null) result |= hasPathSum(root.left, newSum);
        if(root.right != null) result |= hasPathSum(root.right, newSum);
        return result;
    }
}
