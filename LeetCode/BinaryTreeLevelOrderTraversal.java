//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal{
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList <ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> curList  = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextList = new ArrayList<TreeNode>();
        curList.add(root);
        
        while(curList.size() != 0){
            Iterator<TreeNode> it = curList.iterator();
            ArrayList<Integer> temp = new ArrayList<Integer> ();
            while(it.hasNext()){
                TreeNode curNode = it.next();
                temp.add(curNode.val);
                if(curNode.left != null) nextList.add(curNode.left);
                if(curNode.right != null) nextList.add(curNode.right);
            }
            sol.add(temp);
            curList = null;
            curList = nextList;
            nextList = new ArrayList<TreeNode> ();
        }
        return sol;
    }

}