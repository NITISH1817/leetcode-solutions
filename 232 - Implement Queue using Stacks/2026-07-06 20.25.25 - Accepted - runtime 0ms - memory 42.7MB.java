import java.util.*;

class MyQueue {

    private Deque<Integer> queue;

    public MyQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.removeFirst();
    }

    public int peek() {
        return queue.peekFirst();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}