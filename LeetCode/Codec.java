/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> curList = new LinkedList<TreeNode>();
        Queue<TreeNode> nextList = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        curList.add(root);
        while(curList.size() != 0){
            while(curList.size() != 0){
            	TreeNode curNode = curList.poll();
                if(curNode == null){
                    sb.append(",null");
                }
                else{
                	if(sb.length() != 0)
                		sb.append(',');
                    sb.append(String.valueOf(curNode.val));
                    nextList.add(curNode.left);
                    nextList.add(curNode.right);
                }
            }
            curList = nextList;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() == 0)
            return null;
        String[] splits = data.split(",");
        if(splits.length == 0)
            return null;
        Queue<TreeNode> curList = new LinkedList<TreeNode>();
        int index = 0;
        if(isNull(splits[index]))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(splits[index++]));    
        curList.add(head);
        Queue<TreeNode> nextList = new LinkedList<TreeNode>();
        while(curList.size() != 0){
            while(curList.size() != 0){
                TreeNode curNode = curList.poll();
                if(isNull(splits[index])){
                    curNode.left = null;
                    index++;
                }
                else{
                    TreeNode left = new TreeNode(Integer.parseInt(splits[index++]));
                    curNode.left = left;
                    nextList.add(left);
                }
                if(isNull(splits[index])){
                    curNode.right = null;
                    index++;
                }
                else{
                    TreeNode right = new TreeNode(Integer.parseInt(splits[index++]));
                    curNode.right = right;
                    nextList.add(right);
                }
            }
            curList = nextList;
        }
        return head;
    }
    
    public boolean isNull(String str){
        return str.compareTo("null") == 0;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
