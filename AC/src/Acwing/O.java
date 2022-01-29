package Acwing;

import java.util.*;

class O {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int j = i, x = 0;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j++) - '0';
                }
                num.push(x);
                i = j - 1;
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    eval(num, op);
                }
                op.pop();
            } else {

                while (!op.isEmpty() && map.get(op.peek()) != null && map.get(op.peek()) >= map.get(c)) {
                    eval(num, op);
                }
                op.push(c);
            }
        }
        while (!op.isEmpty()) {
            eval(num, op);
        }
        System.out.println(num.peek());
    }

    static void eval(Stack<Integer> num, Stack<Character> op) {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int x = 0;
        if (c == '+') {
            x = a + b;
        } else if (c == '-') {
            x = a - b;
        } else if (c == '*') {
            x = a * b;
        } else {
            x = a / b;
        }
        num.push(x);
    }
}