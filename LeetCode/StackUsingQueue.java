class MyQueue {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();
    boolean inPushStack = true;
    // Push element x to the back of queue.
    public void push(int x) {
        if(!inPushStack){
            moveData(popStack, pushStack);
            inPushStack = true;
        }
        pushStack.push(x);
    }
    
    private void moveData(Stack<Integer> src, Stack<Integer> dist){
        while(!src.isEmpty()){
            dist.push(src.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(inPushStack){
            moveData(pushStack, popStack);
            inPushStack = false;
        }
        popStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(inPushStack){
            moveData(pushStack, popStack);
            inPushStack = false;
        }
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(inPushStack)
            return pushStack.isEmpty();
        else
            return popStack.isEmpty();
    }
}
