package Acwing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class AC4198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        char[] ch = s.toCharArray();
        stk.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(i);
            else {
                stk.pop();
                if (stk.isEmpty()) stk.push(i);
                else {
                    res = Math.max(res, i - stk.peek());
                    if(res == i-stk.peek()){
                        map.put(res,map.getOrDefault(res,0)+1);
                    }

                }
            }
        }


        if (res == 0) {
            System.out.println(0 + " " + 1);
        } else {
            System.out.println(res + " " + map.get(res));
        }


    }
}
