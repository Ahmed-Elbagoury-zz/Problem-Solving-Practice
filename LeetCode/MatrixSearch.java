//https://leetcode.com/problems/search-a-2d-matrix/
public class MatrixSearch{
	public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix == null || matrix.length == 0)
	            return false;
	        int m = matrix.length;
	        int n = matrix[0].length;
	        //Search for the row
	        int st = 0;
	        int end = m-1;
	        boolean flag = false;
	        int mid = 0;
	        while(st <= end){
	            mid = st + (end -st) / 2;
	            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target){
	                flag = true;
	                break;
	            }
	            else{
	                if(matrix[mid][0] > target)
	                    end = mid - 1;
	                else
	                    st = mid + 1;
	            }    
	        }
	        if(!flag)
	            return false;
	        //Search within row    
	        flag = false;
	        st = 0;
	        end = n-1;
	        int row = mid;
	        mid = 0;
	        while(st <= end){
	            mid = st + (end -st) /2;
	            int curVal = matrix[row][mid];
	            if(curVal == target)
	                return true;
	            if(curVal > target)
	                end = mid - 1;
	            else
	                st = mid + 1;
	        }
	        return false;
	}
}
