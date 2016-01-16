public class NumArray {
    
    SegmentTree segmentTree;
    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    void update(int i, int val) {
        segmentTree.updateSum(segmentTree.root, i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.sumRange(segmentTree.root, i, j);
    }
    
    public static void main(String [] args){
   	 NumArray numArray = new NumArray(new int [] {9, -8});
   	System.out.println(numArray.sumRange(0, 1));
   	numArray.update(0, 3);
   	 System.out.println(numArray.sumRange(1, 1));
   	System.out.println(numArray.sumRange(0, 1));
   	numArray.update(1, -3);
   	 System.out.println(numArray.sumRange(0, 1));
   }
}


class SegmentTree{
    SegmentTreeNode root;
    
    public SegmentTree(int [] nums){
        if(nums == null || nums.length == 0)
            return;
        this.root = constructSegmentTree(nums, 0, nums.length-1);    
    }
    
    private SegmentTreeNode constructSegmentTree(int [] nums, int start, int end){
        if(start > end)
            return null;
        if(start == end)    
            return new SegmentTreeNode(start, end, nums[start]);
        SegmentTreeNode curRoot = new SegmentTreeNode(start, end);
        int mid = start + (end-start)/2;
        curRoot.left = constructSegmentTree(nums, start, mid);
        curRoot.right = constructSegmentTree(nums, mid+1, end);
        curRoot.val = curRoot.left.val + curRoot.right.val;
        return curRoot;
    }
    
    public int sumRange(SegmentTreeNode curRoot, int start, int end){
    	if(curRoot == null || curRoot.start > end || curRoot.end < start)
    		return 0;
        if(curRoot.start >= start && curRoot.end <= end)
            return curRoot.val;
        int mid = curRoot.start + (curRoot.end-curRoot.start)/2;    
        int val1 = sumRange(curRoot.left, start, Math.min(end, mid)) ;
        int val2 = sumRange(curRoot.right, mid > start ? mid: start, end);
        return val1 + val2;    
    }
    
    public void updateSum(SegmentTreeNode curRoot, int index, int val){
        if(curRoot == null)
            return;
        if(curRoot.start == curRoot.end){
        	if(curRoot.start == index)
        		curRoot.val = val;
        	return;
        }
        if(curRoot.start > index || curRoot.end < index)
            return;
        int mid = curRoot.start + (curRoot.end - curRoot.start)/2;    
        if(index <= mid)
            updateSum(curRoot.left, index, val);
        else
            updateSum(curRoot.right, index, val);
        curRoot.val = 0;
//        if(curRoot.left != null)
//        	curRoot.val += curRoot.left.val;
//        if(curRoot.right != null)
//        	curRoot.val += curRoot.right.val;  
        curRoot.val = curRoot.left.val + curRoot.right.val;
    }
}

class SegmentTreeNode{
    int start;
    int end;
    int val;
    
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    public SegmentTreeNode(int start, int end, int val){
        this.start = start;
        this.end = end;
        this.val = val;
    }
    public SegmentTreeNode(int start, int end){
        this(start, end, 0);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
