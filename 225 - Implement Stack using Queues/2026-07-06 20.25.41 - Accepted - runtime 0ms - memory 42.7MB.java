import java.util.*;

class MyStack {

    private Deque<Integer> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
    }

    public int pop() {
        return stack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}