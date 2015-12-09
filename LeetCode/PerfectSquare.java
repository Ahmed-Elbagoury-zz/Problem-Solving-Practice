//https://leetcode.com/problems/perfect-squares/
public class PerfectSquare{
	//http://traceformula.blogspot.ca/2015/09/perfect-squares-leetcode.html
	public int numSquares(int n) {
        if(n == 0)
            return 0;
        int [] memo = new int [n+1];
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= sqrt; j++){
                min = min < memo[i - j *j] ? min : memo[i - j *j];
            }
            memo[i] = min + 1;
        }
        return memo[n];
    }

}