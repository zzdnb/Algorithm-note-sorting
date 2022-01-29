package leetcode;

import java.util.Stack;

public class P {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String x:tokens){
            if("+".equals(x) || "-".equals(x) || "*".equals(x) || "/".equals(x)){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if("+".equals(x)){
                    stack.push(String.valueOf(a+b));
                }
                if("-".equals(x)){
                    stack.push(String.valueOf(a-b));
                }
                if("*".equals(x)){
                    stack.push(String.valueOf(a*b));
                }
                if("/".equals(x)){
                    stack.push(String.valueOf(a/b));
                }
            }else{
                stack.push(x);
            }

        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        String[] s =  {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }
}
