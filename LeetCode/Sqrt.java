//http://oj.leetcode.com/problems/sqrtx/
public class Sqrt{
	public int sqrt(int x) {
        if(x <= 0) return 0;
        double g = 1;
        while(Math.abs(x/g-g) > .00001){
            g = (x/g + g)/2;
        }
        return (int)(g);
    }
}