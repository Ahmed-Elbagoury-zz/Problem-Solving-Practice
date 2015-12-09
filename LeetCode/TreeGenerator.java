//https://leetcode.com/problems/unique-binary-search-trees-ii/
//http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-ii-java/ 
public class TreeGenerator{
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();    
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for(TreeNode lNode : left){
                for(TreeNode rNode: right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = lNode;
                    cur.right = rNode;
                    list.add(cur);
                }
            }
        }
        return list;
    }

}