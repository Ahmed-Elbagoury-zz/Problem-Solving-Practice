//https://leetcode.com/problems/4sum/
 public class 3Sum {
        public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if(num.length < 4) return new ArrayList<ArrayList<Integer>>();
            Arrays.sort(num);
            ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
            for(int i =0; i < num.length-3; i++){
                if(num[i] > target && num[i] > 0) break;
                if(i > 0 && num[i] == num[i-1]) continue;
                for(int j = i+1; j < num.length-2;j++){
                    if(num[i] + num[j] > target && num[j] > 0) break;
                    if(j > i+1 && num[j] == num[j-1]) continue;
                    int low  = j + 1;
                    int high = num.length - 1;
                    while(low < high){
                        int sum = num[i] + num[j] + num[low] + num [high];
                        if(sum == target){
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[low]);
                            list.add(num[high]);
                            sol.add(list);
                            do{low++;} while(low<high && num[low] == num[low-1]);
                            do{high--;} while(low<high && num[high] == num[high+1]);
                        }
                        else if(sum < target)
                            low ++;
                        else//sum > 0
                            high --;
                    }
                }
            }
            return sol;
        }
    }
