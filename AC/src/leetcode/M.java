package leetcode;

import java.util.Stack;

/**
 * leetocde周赛
 */
public class M {
    public static void main(String[] args) {

    }

    public int maximumScore(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            //如果栈顶元素大于当前待入栈元素，则出栈
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            //如果栈空，则没有比该元素小的值。
            if (stack.isEmpty()){
                left[i] = -1;
            } else {
                //栈顶元素就是左侧第一个比它小的元素。
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] < k && right[i] > k) {
                int cnt = (right[i] - left[i] - 1) * nums[i];
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
