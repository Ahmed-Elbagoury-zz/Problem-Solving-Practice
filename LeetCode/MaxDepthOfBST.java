//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBST{
	public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    
    public int maxDepth(TreeNode root, int curDepth){
        if(root == null)
            return curDepth;
        int depthLeft = maxDepth(root.left, curDepth+1);
        int depthRight = maxDepth(root.right, curDepth+1);
        return Math.max(depthLeft, depthRight);
    }

}