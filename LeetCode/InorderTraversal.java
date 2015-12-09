//http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
	//With Recursion
    ArrayList<Integer> sol;
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        sol = new ArrayList<Integer>();
        helper(root);
        return sol;
    } 
    
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        sol.add(root.val);
        helper(root.right);
    }
	//Without Recursion
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        sol = new ArrayList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(set.contains(cur)){
                sol.add(cur.val);
            }
            else{
                set.add(cur);
                if(cur.right != null) stack.push(cur.right);
                stack.push(cur);
                if(cur.left != null) stack.push(cur.left);
            }
        }
        return sol;
    } 

}
