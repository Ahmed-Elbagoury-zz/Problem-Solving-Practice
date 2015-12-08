//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    boolean isPalindrome(int x) {
        int temp = x;
        if(x < 0) return false;
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + (x%10);
            x /= 10;
        }
        return rev == temp;
    }

}


