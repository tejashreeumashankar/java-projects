 import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    public MyStack() {}
    
    public void push(int x) {
        q.add(x);
        // Rotate the queue so the newly added element comes to the front
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
} 