public class Solution{
   public int equilibriumIndex(int [] arr){
    	int index = -1;
    	if(arr == null || arr.length == 0)
    		return index;
    	int sum = 0;
    	for(int i : arr){
    		sum += i;
    	}
    	int leftSum = 0;
    	for(int i = 0; i < arr.length; i++){
    		sum -= arr[i];
    		if(sum == leftSum)
    			return i;
    		leftSum += arr[i];
    	}
    	return index;
    }
}
