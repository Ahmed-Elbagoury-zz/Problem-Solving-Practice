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
    List<String> solution;
    public List<String> binaryTreePaths(TreeNode root) {
        solution = new LinkedList<String>();
        if(root == null)
            return solution;
        binaryTreePaths(root, new StringBuilder());
        return solution;    
    }
    
    public void binaryTreePaths(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        int stInd = sb.length();
        if(sb.length() != 0)
            sb.append("->");
        sb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            solution.add(sb.toString());
        }
        else{
            binaryTreePaths(root.left, sb);
            binaryTreePaths(root.right, sb);
        }
        sb.delete(stInd, sb.length());
    }
}
