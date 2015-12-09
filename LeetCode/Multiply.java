//http://oj.leetcode.com/problems/multiply-strings/
public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1 == null && num2 == null) return "";
        int [] result = new int [num1.length()+num2.length()]; 
        int r = 0;
        int carry = 0;
        for(int i = num1.length()-1; i >= 0; i--){
            int digit1 = (int)(num1.charAt(i)-'0');
            for(int j = num2.length()-1; j >= 0; j--){
                int digit2 = (int)(num2.charAt(j)-'0');
                r = digit1*digit2 + carry;
                carry = r /10;
                r %= 10;
                //Add to the final result
                int index = num1.length()+num2.length()-i-j-2;
                r += result[index];
                if(r > 9){
                    carry += r/10;
                    r %= 10;
                }
                result[index] = r;
            }
            result[num2.length()+ num1.length()-1-i] += carry;
            carry = 0;
        }
        
        int size = result.length;
        boolean flag = true;
        while(size > 0 && flag){
        	size --;
        	flag = result[size] == 0;
        }
        size ++;
        result[num1.length()+num2.length()-1] += carry;
        //int size = result[result.length-1] == 0? result.length-1 : result.length;
        char [] arr = new char [size];
        for(int i = size-1; i >= 0; i--)
            arr[i] = (char)(result[size-i-1] + (int)'0');
        return new String(arr);
    }
}
