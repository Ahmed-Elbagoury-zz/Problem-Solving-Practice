public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(x == 1 || x == -1){
            if(n %2 == 0){
                return 1;
            }
            else{
                return x;
            }
        }
        if(n == Integer.MIN_VALUE){
            return 0;
        }
        boolean isNegative = false;
        if(n < 0){
            n *= -1;
            isNegative = true;
        }
        double x1 = myPow(x, n/2);
        x1 = x1*x1;
        if(n %2 != 0){
            x1 *= x;
        }
        if(isNegative){
            x1 = 1/x1;
        }
        return x1;
    }
}
