//https://leetcode.com/problems/validate-binary-search-tree/
public class BSTValidator{
	public boolean isValidBST(TreeNode root) {
           return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public boolean isValidBST(TreeNode root, double min, double max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)    
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}