//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KLargetElement{
	public int findKthLargestMaxHeap(int[] nums, int k) {
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
    public int findKthLargestBubbleSort(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return -1;
        int n = nums.length;    
        //Using bubble sort in O(k*n)
        for(int i = 0; i < k; i++){
            int max = nums[i];
            int ind = i;
            for(int j = i+1; j < n; j++){
                if(nums[j] > max){
                    max = nums[j];
                    ind = j;
                }
            }
            nums[ind] = nums[i];
            nums[i] = max;
        }
        return nums[k-1];
    }
    
    public int findKthLargestMinHeap(int [] nums, int k){
        if(nums == null || nums.length == 0)
            return -1;
        int n = nums.length;    
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer int1, Integer int2) {
				if(int1 > int2)
				    return 1;
				else if(int1 < int2)    
				    return -1;
				return 0;
			}
    	});
    	//adding the first k elements
    	int i =  0;
    	for(; i < k; i++){
    	    pq.add(nums[i]);
    	}
    	for(;i < n; i++){
    	    if(nums[i] > pq.peek()){
    	        pq.poll();
    	        pq.add(nums[i]);
    	    }
    	}
    	return pq.peek();
    }

}
