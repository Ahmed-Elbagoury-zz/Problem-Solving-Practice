//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == '(' || curChar == '{' || curChar == '['){
                stack.push(curChar);
            }
            else{
                if(stack.isEmpty())
                    return false;
                if(match(stack.peek(), curChar)){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
    
    public boolean match(char left, char right){
        if((left == '(' && right == ')')||
            (left == '{' && right == '}')||
            (left == '[' && right == ']'))
            return true;
        return false;
    }



