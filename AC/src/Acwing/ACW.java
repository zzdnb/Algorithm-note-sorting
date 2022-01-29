package Acwing;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class ACW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek()=='['&& s.charAt(i)==']') {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        int x = stack.size();
        for(Character c:stack){
            System.out.print(c);
        }
        if(x==0){
            System.out.println(0);
        }else{
            if(x>2){
                System.out.println(x);
                System.out.println( x%4 == 0?x/4:x/4+1);
            }else{
                System.out.println(x/2);
            }
        }


    }
}
