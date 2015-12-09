//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KLargetElement{
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2){
				if(i1 > i2)
					return -1;
				else if(i2 > i1)
					return 1;
				return 0;
			}
		});
		for(int i : nums){
			queue.add(i);
		}
		int sol = 0;
		for(int i = 0; i < k; i++){
			sol = queue.remove();
		}
		return sol;
    }

}