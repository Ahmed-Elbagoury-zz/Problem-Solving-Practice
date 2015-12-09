//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTree{
	public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode listHead = null;
        TreeNode ptr = null;
        while(!stack.isEmpty()){
            TreeNode curNode= stack.pop();
            if(listHead == null){
                listHead = curNode;
                ptr = listHead;
            }
            else{
                ptr.right = curNode;
                ptr = ptr.right;
            }
            if(curNode.right != null)
                stack.push(curNode.right);
            if(curNode.left != null)    
                stack.push(curNode.left);
            curNode.right = null;
            curNode.left = null;
        }
    }
}