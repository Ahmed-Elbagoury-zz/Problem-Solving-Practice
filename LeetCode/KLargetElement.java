//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KLargetElement{
	public int findKthLargestMaxHeap(int[] nums, int k) {
		//Time complexity: O(n + klogn)
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
    	//Using bubble sort in O(k*n)
        if(nums == null || nums.length == 0)
            return -1;
        int n = nums.length;    
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
    	//O(k + (n-k)Logk) 
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
    
    
    public int findKthLargestQuickSort(int [] nums, int k){
       if(nums == null || nums.length == 0)
           return -1;
       	   int n = nums.length;
           return findKathLargest(nums, 0, nums.length-1, n-k);
   }
   
   public int findKathLargest(int [] nums, int st, int end, int k){
   	//O(n)
       int pivot = partition(nums, st, end);
       if(k == pivot)
           return nums[pivot];
       else if(k > pivot){
           return findKathLargest(nums, pivot+1, end, k);
       }
       else
           return findKathLargest(nums, st, pivot-1, k);
       
   }
   
   public int partition(int [] nums, int st, int end){
       int pivotInd = end;
       int pivot = nums[pivotInd];
       int largerInd = st;
       int smallerInd = st;
       while(largerInd < end && smallerInd < end){
           while(nums[largerInd] < pivot)
               largerInd ++;
           smallerInd = largerInd;
           while(smallerInd < end && nums[smallerInd] >= pivot)
               smallerInd ++;
           swap(nums, smallerInd, largerInd);
           pivotInd = largerInd;
           largerInd++;
       }
       return pivotInd;
   }
   
   public void swap(int [] nums, int ind1, int ind2){
	   if(ind1 == ind2)
		   return;
       nums[ind1] += nums[ind2];
       nums[ind2] = nums[ind1] - nums[ind2];
       nums[ind1] -= nums[ind2];
   }

}
