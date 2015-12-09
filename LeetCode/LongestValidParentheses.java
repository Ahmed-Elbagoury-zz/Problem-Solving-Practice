//http://oj.leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() ==0) return 0;
        int last = -1;
        int maxLen = 0;
        Stack<Integer> lefts = new Stack<Integer> ();
        for(int i = 0; i< s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == '('){
                lefts.push(i);
            }
            else{   //curChar is ')'
                if(lefts.isEmpty()){ //No remaining (
                    last = i;
                }
                else{   //there is matching (
                    lefts.pop();
                    if(lefts.isEmpty()){ //The stack is empty ... so up till now we have a valid string directly after last to the current char
                        maxLen = Math.max(maxLen, i-last);
                    }
                    else{   //The stack has ( ... so up till now the valid string is directly after the last unmatched ( to the current char (which is ')' )
                        maxLen = Math.max (maxLen, i-lefts.peek());                        
                    }
                }
            }
        }
        return maxLen;
    }
    public int longestValidParentheses2(String s) {
         if(s == null || s.length() == 0)
             return 0;
         int max = 0;    
         Stack<int[]> stack = new Stack<int[]>();
         for(int i = 0; i < s.length(); i++){
             char curChar = s.charAt(i);
             if(curChar == '('){
                 int [] a = new int [] {i, 0};
                 stack.push(a);
             }
             else{
                 if(stack.isEmpty() || stack.peek()[1] == 1)
                     stack.add(new int[]{i, 1});
                 else{
                     stack.pop();
                     if(stack.isEmpty())
                         max = max > i+1 ? max : i+1;
                     else
                         max = max > i-stack.peek()[0] ? max : i-stack.peek()[0];
                 }
             }
         }
         return max;
     }


}