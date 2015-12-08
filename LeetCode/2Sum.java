//https://leetcode.com/problems/two-sum/
public class 2Sum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return null;
        int [] copy = new int [numbers.length];
        System.arraycopy(numbers, 0, copy, 0, numbers.length);
        Arrays.sort(numbers);
        int st = 0;
        int end = numbers.length-1;
        boolean found = false;
        while (st < end){
            if(numbers[st] + numbers[end] == target){
                found = true;
                break;
            }
            else if(numbers[st] + numbers[end] < target)
                st ++;
            else
                end --;
        }
        if(!found)return null;
        int ind1 = -1;
        int ind2= -1;
        boolean ind1Found = false;
        boolean ind2Found = false;
        for(int i = 0; i< copy.length; i++){
            if(!ind1Found && copy[i] == numbers[st]){
            	ind1Found = true;
                ind1 = i;
            }
            else if(!ind2Found && copy[i] == numbers[end]){
            	ind2Found = true;
                ind2 = i;
            }
        }
        return new int [] {Math.min(ind1, ind2) + 1, Math.max(ind1, ind2)+1};
    }

     public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return new int [0];
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer> ();
        for(int i = 0; i < numbers.length; i++){
            int curNum = numbers[i];
            if(map.containsKey(target-curNum))
                return new int [] {map.get(target-curNum)+1, i+1};
            else
                map.put(curNum, i);
        }
        return null;
    }	
}
