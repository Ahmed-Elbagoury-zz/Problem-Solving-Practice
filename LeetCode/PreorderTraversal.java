//http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
public class PreorderTraversal {
	//Recursive solution
    ArrayList<Integer> sol;
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer> ();
        sol = new ArrayList<Integer> ();
        helper(root);
        return sol;
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        sol.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    //Solution without recursion
    public ArrayList<Integer> preorderTraversalNoRecursion(TreeNode root) {
         if(root == null) return new ArrayList<Integer> ();
         sol = new ArrayList<Integer> ();
         
         Stack<TreeNode> stack = new Stack<TreeNode>();
         stack.push(root);
         while(!stack.isEmpty()){
             TreeNode cur = stack.pop();
             if(cur.right != null) stack.push(cur.right);
             if(cur.left != null) stack.push(cur.left);
             sol.add(cur.val);
         }
         return sol;
     }

}
