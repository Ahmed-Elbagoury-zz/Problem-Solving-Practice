//http://oj.leetcode.com/problems/string-to-integer-atoi/
public class Atoi {
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int ind = 0;
        while(ind < str.length() && str.charAt (ind) == ' ' || str.charAt(ind) == '\t' || str.charAt(ind) == '\n')
            ind++;
        int sign = 1;    
        if(str.charAt(ind) == '+')
            ind++;
        if(str.charAt(ind) == '-'){
            ind++;
            sign = -1;
        }
        boolean flag = false;
        int res = 0;
        for(int i = ind; i < str.length(); i++){
            char curChar = str.charAt(i); 
            if(curChar >= '0' && curChar <= '9'){
                flag = true;   
                
                if(res != 0 && Integer.MAX_VALUE/ res < 10){
                	if(sign == -1) return -2147483648;
                    else return 2147483647; 
                }
                res *= 10;
                res += (int) (curChar-'0');
                if(res < 0){
                    if(sign == -1) return -2147483648;
                    else return 2147483647;    
                }
            }
            else 
                return sign*res;
        }
        if(!flag)   return 0;
        return sign*res;
            
    }
}