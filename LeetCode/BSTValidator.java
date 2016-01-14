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
    
    
    List<Integer> result;
    public boolean isValidBSTUsingInOrder(TreeNode root) {
        if(root == null)
            return true;
        result = new LinkedList<Integer>();
        inOrder(root);
        Iterator<Integer> it = result.iterator();
        int prev = it.next();
        while(it.hasNext()){
            int cur = it.next();
            if(prev >= cur)
                return false;
            prev = cur;    
        }
        return true;
    }
    
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}
