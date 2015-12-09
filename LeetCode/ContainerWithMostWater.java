//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater{
	public int maxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int temp = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
            max = max > temp ? max : temp;
            if(height[left] < height[right]){
                //Left is the bottlneck... so we need to move it to check if there is something better.
                //On the other hand if we move right and the new line is larger it will not make difference as left is the bottlnekc and if it is smaller than the left the area will be smaller
                left ++;
            }
            else
                right --;
        }
        return max;
    }

}