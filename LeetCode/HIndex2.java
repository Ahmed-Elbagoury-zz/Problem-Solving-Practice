//https://leetcode.com/problems/h-index-ii/
public class HIndex2{
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;    
        for(int i = n-1; i >= 0; i --){
            int order = n- i;
            if(citations[i] < order)
                return order-1;
        }
        return n;
    }

    //Using Binary Search
    public int hIndexBS(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length; 
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;
        int sol = -1;
        while(start <= end){
            if(citations[mid] == n-mid)
                return n-mid;
            else if(citations[mid] < n-mid){ //Mid satisfies the condition
                start = mid+1;
                sol = n-(mid+1) < 0 ? 0 : n-(mid+1);
            }
             else{
            	sol = n-mid;
                end = mid - 1;
            }
            mid = start + (end-start)/2;
        }
        return sol;   
    }

}