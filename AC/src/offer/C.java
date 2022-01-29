package offer;

import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class C {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while(!s2.empty()){
            return s2.pop();
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!s2.empty()){
            return s2.peek();
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }


    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */