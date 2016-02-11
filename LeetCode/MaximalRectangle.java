//https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle{
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] height = new int [n][m];
        for(int i = 0; i < m; i++)
            height[0][i] = (int) (matrix[0][i] - '0');
        for(int i = 1 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0')
                    continue;
                height[i][j] = height[i-1][j] + 1;    
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, maxRectangle(height[i]));
        }
        return max;
    }
    
    public int maxRectangle(int[] height) {
    	/*
    		http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    		 For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. 
    		 If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. 
    		 How to calculate area with ‘x’ as smallest bar? 
    		 We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. 
    		 Let us call these indexes as ‘left index’ and ‘right index’ respectively.
		We traverse all bars from left to right, maintain a stack of bars. 
		Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen. 
		When a bar is popped, we calculate the area with the popped bar as smallest bar. 
		How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and 
		index of previous item in stack is the ‘left index’.
    	*/
        if(height == null)
            return 0;
        int n = height.length;    
        Stack<Integer> stack = new Stack<Integer>();//Stack of indices of heights of increasing order
        int max = 0;
        int i = 0;
        while(i < n){
            int curHeight = height[i];
            if(stack.isEmpty() || height[stack.peek()] <= curHeight){//We have an increasing order of heights
                stack.push(i++);
            }
            else{
                //This element breaks the increasing order. This means that last element in the stack is greater than it
                int index = stack.pop();
                //The height of the current rectangle will be used as the smallest height.
                int h = height[index];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
        }
        //If the stack is not empty as the rest of rectangles are in increasing order
        //i points now to the index of the last rectangle in the increasing sequence + 1
        //So, each time the width will be the difference between the current rectangle and the previous one of the index of the current rectangle in case the stack is empty
        while(!stack.isEmpty()){
            int index = stack.pop();
            int h = height[index];
            int w = stack.isEmpty()? i : i - stack.peek()-1;
            max = Math.max(h * w, max);
        }
        return max;
    }
}
