//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBST{
	boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        getHeight(root);
        return flag;
    }
    
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            flag = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}