//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindromeNoExtraSpace(String s) {
        if(s == null || s.length() <= 1) return true;
        int st = 0;
        int end = s.length()-1;
        while(st < end){
            char curChar = s.charAt(st);
            while(st < end && !(curChar >= 'a' && curChar <= 'z') && !(curChar >= 'A' && curChar <= 'Z') && !(curChar <= '9' && curChar >= '0') ){
                st ++;
                curChar = s.charAt(st);
            }
            curChar = s.charAt(end);
            while(st < end && !(curChar >= 'a' && curChar <= 'z') && !(curChar >= 'A' && curChar <= 'Z') && !(curChar <= '9' && curChar >= '0') ){
                end--;
                curChar = s.charAt(end);
            }
            if(!compareChar(s.charAt(st), s.charAt(end)))    
                return false;
            st++;
            end--;
        }
        return true;
    }
    
    
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        int len = 0;
        char [] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if( (curChar >= 'a' && curChar <= 'z') || (curChar >= 'A' && curChar <= 'Z') || (curChar <= '9' && curChar >= '0') )
                arr[len++] = curChar;
        }
        int st = 0 ;
        int end = len-1;
        while(st < end){
            if(!compareChar(arr[st++], arr[end--])) return false;
        }
        return true;
    }
    
    public boolean compareChar(char first, char second){
        boolean firstIsNum = first >= '0' && first <= '9';
        boolean secondIsNum = second >= '0' && second <= '9';
        
        if(!firstIsNum && !secondIsNum){
            if(first >= 'A' && first <= 'Z')
                first = (char)(first - 'A' +'a');
            if(second >='A' && second <= 'Z')    
                second = (char) (second - 'A' + 'a');
        }
        return first == second;
    }
}


