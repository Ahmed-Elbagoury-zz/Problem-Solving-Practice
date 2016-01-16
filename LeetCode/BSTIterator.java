/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class BSTIterator {
    List<Integer> list;
    Iterator<Integer> iter;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<Integer>();
        inOrderTraversal(root);
        iter = list.iterator();
    }
    
    private void inOrderTraversal(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(set.contains(cur)){
                list.add(cur.val);
            }
            else{
                set.add(cur);
                if(cur.right != null)
                    stack.push(cur.right);
                stack.push(cur);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iter.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return iter.next();
    }
    
    
    public static void main (String [] args){
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	BSTIterator bstIterator = new BSTIterator(root);
    	while(bstIterator.hasNext())
    		System.out.println(bstIterator.next());
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
