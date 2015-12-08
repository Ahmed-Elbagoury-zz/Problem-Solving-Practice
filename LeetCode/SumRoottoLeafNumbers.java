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