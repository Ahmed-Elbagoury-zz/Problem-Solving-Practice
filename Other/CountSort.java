//http://www.geeksforgeeks.org/counting-sort/ 
//O(n+k) time
//O(k) space
public class CountSort {
	public String countSort(String str, int range){
    	if(str == null || str.length() == 0)
    		return "";
    	int [] count = new int[range];
    	int n = str.length();
    	for(int i = 0; i < n; i++){
    		int cur = (int)(str.charAt(i));
    		count[cur]++;
    	}
    	for(int i = 1; i < range; i++){
    		count[i] += count[i-1];
    	}
    	char[] sorted = new char[n];
    	for(int i = n-1; i >= 0; i--){
    		int index = (int)(str.charAt(i));
    		sorted[count[index]-1] = str.charAt(i);
    		count[index] --;
    	}
    	return new String(sorted);
    }
	
public static void main (String [] args){
    	
    	CountSort countSort = new CountSort();
    	int range = (int)Character.MAX_VALUE;
    	String in = "This is a test input";
    	String out = countSort.countSort(in, range);
    	System.out.println("\"" + out + "\"");
    }
}
