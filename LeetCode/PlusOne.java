//https://leetcode.com/problems/plus-one/
public class PlusOne{
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return new int [0];
        int carry = 0;    
        digits[digits.length - 1] += 1;
        carry = digits[digits.length - 1] / 10;
        digits[digits.length - 1] %= 10;
        for(int i = digits.length - 2; i >= 0; i--){
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        int [] sol = digits;
        if(carry > 0){
            sol = new int [digits.length + 1];
            for(int i = digits.length - 1; i >= 0; i--)
                sol[i+1] = digits[i];
            sol[0] = carry;    
        }
        return sol;
    }

}