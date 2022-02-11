package pdf;

import java.util.Stack;

public class A {


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(-3);
        stack.push(2);
        stack.push(0);
        System.out.println(stack.getmin());
    }
}

class MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int val = stackData.pop();
        if (val == this.getmin()) {
            this.stackMin.pop();
        }
        return val;
    }
}
