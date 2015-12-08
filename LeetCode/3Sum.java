//https://leetcode.com/problems/3sum/
//http://n00tc0d3r.blogspot.com/

public class 3Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> solutions = new ArrayList <ArrayList<Integer>>();
        for(int i = 0; i < num.length && num[i] <= 0; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            int low = i+1;
            int high = num.length-1;
            while(low < high){
                if(num[low] + num[high] + num[i] == 0){
                    ArrayList list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[low]);
                    list.add(num[high]);
                    solutions.add(list);
                    do{low ++;}while(low<high && num[low] == num[low-1]);
                    do{high --;}while(low<high && num[high] == num [high+1]);
                }
                else if(num[low] + num[high] +num[i]< 0)
                    low ++;
                else high --;
            }
        }
        return solutions;
    }

    ArrayList<ArrayList<Integer>> sol;
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        if(num == null || num.length < 3) return new ArrayList<ArrayList<Integer>>();
        sol = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
            int curVal = num[i];
            if(i > 0 && curVal == num[i-1]) continue;
            twoSum(i, num, -1*curVal);
        }
        return sol;
    }
    public void twoSum(int ind, int [] arr, int target){
        int st = ind+1;
        int end = arr.length-1;
        while(st < end){
        	int sum = arr[st] + arr[end];
        	if(sum < target) st ++;
            else if(sum > target) end--;
            else{   //sum up to zero
                Integer [] temp = new Integer [3];
                temp [0] = arr[st];
                temp [1] = arr[end];
                temp [2] = -1*target;
                Arrays.sort(temp);
                sol.add(new ArrayList<Integer>(Arrays.asList(temp)));
                do{
                    st++;
                }while(st < arr.length && arr[st] == arr[st-1]);
                do{
                    end--;
                }while(end > st && arr[end] == arr[end+1]);
            }
        }
    }
}
