//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class ReversePolishNotation{
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<String> stack = new Stack<String>(); 
        int result = 0;
        String operators  = "+-/*";
        for(int i = 0; i < tokens.length; i++){
            String curToken = tokens[i];
            if(!operators.contains(curToken)){
                stack.push(curToken);
                if(i == tokens.length -1)
                    return Integer.parseInt(curToken);
                continue;
            }
            
            int second = Integer.parseInt(stack.pop());
            int first = Integer.parseInt(stack.pop());
            if(curToken.compareTo("+") == 0)
                result = first + second;
            if(curToken.compareTo("-") == 0)
                result = first - second;
            if(curToken.compareTo("/") == 0)
                result = first / second;
            if(curToken.compareTo("*") == 0)
                result = first * second;
            stack.push(String.valueOf(result));
        }    
        return result;
    }

}