//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            x *= -1;
            isNegative = true;
        }
        int newNumber = 0;
        while(x > 0){
        	if(newNumber > Integer.MAX_VALUE /10)
                return 0;
            newNumber *= 10;
            newNumber += x % 10;
            x = x / 10;
        }
        if(isNegative)
            newNumber *= -1;
        return newNumber;
    }
}


