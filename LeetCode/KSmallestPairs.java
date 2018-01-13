class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> solution = new LinkedList<int[]>();
        if(nums1.length == 0 || nums2.length == 0)
            return solution;
        int [] indexMapping = new int [nums1.length];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	public int compare(Integer index1, Integer index2) {
        		int sum1 = nums1[index1] + nums2[indexMapping[index1]];
        		int sum2 = nums1[index2] + nums2[indexMapping[index2]];
        		return sum1 - sum2;
        	}
        });
        for(int i = 0; i < nums1.length; i++) {
        	pq.add(i);
        }
        int counter = 0;
        while(!pq.isEmpty() && counter < k) {
        	int index = pq.poll();
        	solution.add(new int []{nums1[index], nums2[indexMapping[index]]});
        	indexMapping[index] ++;
        	if(indexMapping[index] < nums2.length) {
        		pq.add(index);
        	}
        	counter ++;
        }
        return solution;
    }
}
