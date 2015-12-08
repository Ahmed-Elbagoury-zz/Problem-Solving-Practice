https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3)return Integer.MAX_VALUE;
        Arrays.sort(num);
        int sol = num[0]+num[1]+num[2];
        for(int i =0; i < num.length; i++){
            int curVal = num[i];
            int st = i+1;
            int end = num.length-1;
            while(st < end){
                int temp = num[st] + num[end] + curVal;
                if(temp == target) return target;
                if(Math.abs(temp - target) < Math.abs(sol - target))
                        sol = temp;
                else if(temp > target) end--;
                else st++;
            }
        }
        return sol;
    }
}

