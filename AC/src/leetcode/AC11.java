package leetcode;

import java.util.Stack;

public class AC11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()&&height[stack.peek()] > height[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                l[i] = -1;
            }else{
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i < height.length; i++){
            System.out.print(l[i] +" ");
        }
        System.out.println();
        stack.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty()&&height[stack.peek()] > height[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                r[i] = n;
            }else{
                r[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i < height.length; i++){
            System.out.print(r[i] +" ");
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res,(r[i]-l[i]-1)*height[i]);
        }
        return res;
    }
}
