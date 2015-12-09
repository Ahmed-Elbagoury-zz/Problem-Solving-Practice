//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BuildTreeFromPreOrderAndInorder{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);    
    }
    
    public TreeNode helper(int [] preorder, int st1, int end1, int [] inorder, int st2, int end2){
        if(st1 > end1)
            return null;
        int first = preorder[st1];
        int ind = -1; 
        for(int i = st2; i <= end2; i++){
            if(inorder[i] == first){
                ind = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[ind]);
        root.left = helper(preorder, st1+ 1, st1 + ind -st2, inorder, st2, ind-1);
        root.right = helper(preorder, st1 + ind -st2 + 1, end1, inorder, ind+1, end2);
        return root;   
    }
}