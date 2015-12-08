//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class Binary TreeLevelOrderTraversal2{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList <Integer>> sol = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        ArrayList<Integer> curSol;
        cur.add(root);
        while(cur.size() != 0){
            curSol = new ArrayList<Integer>();
            Iterator<TreeNode> it = cur.iterator();
            while(it.hasNext()){
                TreeNode curNode = it.next();
                curSol.add(curNode.val);
                if(curNode.left != null) next.add(curNode.left);
                if(curNode.right != null) next.add(curNode.right);
            }
            sol.add(0, curSol);
            cur = next;
            next = new ArrayList<TreeNode>();
        }
        return sol;
    }

}