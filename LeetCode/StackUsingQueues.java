class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int lastVal = -1;
        while(!q1.isEmpty()){
            lastVal = q1.poll();
            if(!q1.isEmpty())
                q2.add(lastVal);
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Get the top element.
    public int top() {
        int lastVal = -1;
        while(!q1.isEmpty()){
            lastVal = q1.poll();
            q2.add(lastVal);
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return lastVal;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
