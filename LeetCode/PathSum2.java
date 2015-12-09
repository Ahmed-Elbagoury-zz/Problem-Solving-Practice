//http://oj.leetcode.com/problems/path-sum-ii/
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>> ();
        pathSumHelper(sol, new ArrayList<Integer>(), root, sum);
        return sol;
    }
    
    public void pathSumHelper (ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> curPath, TreeNode root, int sum){
        if(root == null) return;
        curPath.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            ArrayList<Integer> copy = new ArrayList<Integer> (curPath);
            sol.add(copy);
            curPath.remove(curPath.size()-1);
            return;
        }
        if(root.left != null) pathSumHelper(sol, curPath, root.left, sum);
        if(root.right!= null) pathSumHelper(sol, curPath, root.right, sum);
        
        curPath.remove(curPath.size() -1);
    }
}


