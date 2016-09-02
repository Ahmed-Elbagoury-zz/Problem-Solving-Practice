//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoottoLeafNumbers{
	 public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> nodes = new Stack <TreeNode> ();
        Stack<Integer> sum  = new Stack <Integer> ();
        int res = 0;
        
        nodes.push(root);
        sum.push(root.val);
        while(!nodes.isEmpty()){
            TreeNode curNode = nodes.pop();
            int curSum  = sum.pop();
            boolean flag = false;
            if(curNode.left != null){
                flag = true;
                nodes.push(curNode.left);
                sum.push(curSum*10+curNode.left.val);
            }
            if(curNode.right != null){
                flag = true;
                nodes.push(curNode.right);
                sum.push(curSum*10+curNode.right.val);
            }
            if(!flag)
                res += curSum;
        }
        return res;
    }

}


//---------------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int sol = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return sol;
        }
        traverseTree(root, 0);
        return sol;
    }
    
    public void traverseTree(TreeNode root, int curVal){
        if(root.left == null && root.right == null){
            //Base case
            sol += (curVal * 10) + root.val;
            return;
        }
        curVal *= 10;
        curVal += root.val;
        if(root.left != null){
            traverseTree(root.left, curVal);
        }
        if(root.right != null){
            traverseTree(root.right, curVal);
        }
        curVal -= root.val;
        curVal /= 10;
    }
}
