package leetcode;

import javax.jws.soap.SOAPBinding;
import java.util.Stack;

public class R {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));
    }

    public static boolean find132pattern(int[] nums) {
        //要找的第一个数必须是左边最小的，继续从右边找大于第一个数的数，然后在判断当前数是不是大于第二个数
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);

            }
        }

        return false;
    }
}
