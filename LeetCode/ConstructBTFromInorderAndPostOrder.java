
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  public class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return buildTree(inorder, postorder, 0, inorder.length-1, 0, inorder.length-1);
	    }
	    
	    public TreeNode buildTree(int [] inorder, int [] postorder, int stIn, int endIn, int stPost, int endPost){
	        if(endIn < stIn)
	            return null;
	        TreeNode root = new TreeNode(postorder[endPost]);
	        int indInorder = search(inorder, stIn, endIn, postorder[endPost]);
	        int numLeft = indInorder - stIn;
	        root.left = buildTree(inorder, postorder, stIn, indInorder-1,stPost, stPost+numLeft-1);
	        root.right = buildTree(inorder, postorder, indInorder+1, endIn, stPost+numLeft, endPost-1);
	        return root;
	    }
	    
	    public int search(int [] inorder, int st, int end, int val){
	        for(int i = st; i <= end; i++){
	            if(inorder[i] == val)
	                return i;
	        }
	        return -1;
	    }
	    
	    public static void main(String [] args){
	    	Solution solution = new Solution();
	    	TreeNode root = solution.buildTree(new int []{1, 2}, new int []{2, 1});
	    	System.out.println(root);
	    }
	}
