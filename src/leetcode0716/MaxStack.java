package leetcode0716;

import java.util.Stack;

public class MaxStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> maxElement;
    public MaxStack() {
        stack = new Stack<>();
        maxElement = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    private void pushHelper(int x) {
        stack.push(x);
        if (maxElement.isEmpty() || x > maxElement.peek()) {
            maxElement.push(x);
        } else {
            maxElement.push(maxElement.peek());
        }
    }

    public int pop() {
        int res = stack.pop();
        maxElement.pop();
        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxElement.peek();
    }

    public int popMax() {
        int max = maxElement.peek();
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty() && stack.peek() != max) {
            tmp.push(stack.pop());
            maxElement.pop();
        }
        stack.pop();
        maxElement.pop();
        while (!tmp.isEmpty()) {
            pushHelper(tmp.pop());
        }
        return max;
    }
}
