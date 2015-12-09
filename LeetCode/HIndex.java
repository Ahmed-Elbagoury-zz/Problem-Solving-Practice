//https://leetcode.com/problems/h-index/
public class HIndex{
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);    
        int n = citations.length;
        for(int i = n-1; i >= 0; i --){
            int order = n-i;
            if(citations[i] < order)
                return order-1;
        }
        return n;
    }
}