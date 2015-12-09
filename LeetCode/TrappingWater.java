//https://leetcode.com/problems/trapping-rain-water/
public class TrappingWater{
	public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int n = height.length;    
        int [] left = new int [n];
        int [] right = new int [n];
        right[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] > height[i] ? right[i+1] : height[i];
        }
        left[0] = height[0];
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] > height[i] ? left[i-1] : height[i];
        }
        int area = 0;
        for(int i = 0; i < n; i++){
            area += Math.min(right[i], left[i]) - height[i];
        }
        return area;
    }

}