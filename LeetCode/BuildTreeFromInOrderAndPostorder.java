//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BuildTreeFromInOrderAndPostorder{
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode helper(int [] inorder, int st1, int end1, int [] postorder, int st2, int end2){
        if(st1 > end1)
            return null;
        int rootVal = postorder[end2];
        int ind = -1;
        for(int i = st1; i <= end1; i++){
            if(inorder[i] == rootVal){
                ind = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, st1, ind-1, postorder, st2, st2 + ind-st1-1);
        root.right = helper(inorder, ind+1, end1, postorder, st2+ind-st1, end2-1);
        return root;
    }

}