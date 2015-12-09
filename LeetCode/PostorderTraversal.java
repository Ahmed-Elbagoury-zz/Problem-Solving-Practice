//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostorderTraversal {
	//Recursive Solution
    ArrayList<Integer> sol;
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        sol = new ArrayList<Integer>();
        helper(root);
        return sol;
    }
    
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        helper(root.right);
        sol.add(root.val);
    }
    //Solution without recursion
    public ArrayList<Integer> postorderTraversalNoRecursion(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        sol = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        stack.add(root);
        visited.add(root);
        if(root.right != null) stack.add(root.right);
        if(root.left != null) stack.add(root.left);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(visited.contains(cur))
                sol.add(cur.val);
            else{
                visited.add(cur);
                stack.push(cur);
                if(cur.right != null) stack.push(cur.right);
                if(cur.left != null) stack.push(cur.left);
            }    
        }
        return sol;
    }    
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        helper(root.right);
        sol.add(root.val);
    }

}
