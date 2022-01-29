package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class L5752 {
    public static void main(String[] args) {
        System.out.println(maxSumMinProduct(new int[]{1, 2, 3, 2,2}));
    }

        public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] s = new int[n+1];
        for(int i = 1; i <= n; i++){
            s[i] = nums[i-1] + s[i-1];
            System.out.println(s[i]);
        }

        int[] l =  new int[n];
        int[] r = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()&&nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                l[i] = 0;
            }else{
                l[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty()&&nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                r[i] = n-1;
            }else{
                r[i] = stack.peek()-1;
            }
            stack.push(i);
        }
        for(int i = 0; i < n; i++){
            System.out.println(l[i] +" "+r[i]);
        }
        long res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(nums[i] * (s[r[i]+1]-s[l[i]])%(int)(1e9+7),res);
        }
        return (int)res;
    }
}

//    public static int maxSumMinProduct(int[] nums) {
//        long res = 0;
//        int mod = (int) 1e9 + 7;
//        int n = nums.length;
//        long[] s = new long[n + 1];
//        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
//        Deque<Integer> stk = new ArrayDeque<>();
//        int[] l = new int[n];
//        int[] r = new int[n];
//        for (int i = 0; i < n; i++) {
//            while (stk.size() > 0 && nums[stk.peek()] >= nums[i]) stk.pop();
//            l[i] = stk.size() == 0 ? 0 : stk.peek() + 1;
//            stk.push(i);
//        }
//        stk.clear();
//        for (int i = n - 1; i >= 0; i--) {
//            while (stk.size() > 0 && nums[stk.peek()] >= nums[i]) stk.pop();
//            r[i] = stk.size() == 0 ? n - 1 : stk.peek() - 1;
//            stk.push(i);
//        }
//        System.out.println(Arrays.toString(l));
//        System.out.println(Arrays.toString(r));
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, (long) nums[i] * (s[r[i] + 1] - s[l[i]]));
//        }
//        return (int) (res % mod);
//    }
//}

