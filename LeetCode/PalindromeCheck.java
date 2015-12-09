//http://oj.leetcode.com/problems/palindrome-number/
public class PalindromeCheck {
    public boolean isPalindrome(int x) {
        if(x < 0)  return false;
        if(x < 9) return true;
        int rev = reverse (x);
        return x == rev;
    }
    
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean negative = x < 0;
        int temp = x;
        if(negative) temp *= -1;
        while(temp % 10 == 0) temp /= 10;
        int result = 0;
        while(temp > 0){
            int r = temp %10;
            temp /= 10;
            result *= 10;
            result += r;
        }
        if(negative) result *= -1;
        return result;   
    }
}
