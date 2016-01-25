import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int x) {
        stack.push(x);
        int min = x;
        if(minStack.size() != 0)
            min = min < minStack.peek() ? min : minStack.peek();
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}



class MinStack {
    Stack<StackNode> stack = new Stack<StackNode>();
    
    public void push(int x) {
        int curMin = getMin();
        StackNode curNode = new StackNode(x, Math.min(x, curMin));   
        stack.push(curNode);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        if(stack.isEmpty())
            return Integer.MAX_VALUE;
        return stack.peek().min;    
    }
}

class StackNode{
    int val;
    int min;
    
    public StackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}
