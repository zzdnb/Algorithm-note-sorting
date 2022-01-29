package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AC256 {
    public static void main(String[] args) {
//        System.out.println(minimumDifference(new int[]{1,4,9,7},2));
//        System.out.println(kthLargestNumber(new String[]{"6","7","3","10"},4));
        System.out.println(minSessions(new int[]{2,3,3,4,4,4,5,6,7,10 }, 12));
    }

    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < nums.length - k + 1; i++) {
            ans = Math.min(nums[i + k - 1] - nums[i], ans);
        }
        return ans;
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }));
        return nums[nums.length - k];
    }

    public static int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int i = 0, j = tasks.length-1;

        int ans = 0;
        while(i < j){
            int t = tasks[i];
            System.out.println(i);
            while(t+tasks[j] <= sessionTime){
                t = t+tasks[++i];
            }
            ans++;
            j--;
        }
        return ans;
//        Deque<Integer> queue = new LinkedList<Integer>();
//        for (int x : tasks) {
//            queue.add(x);
//        }
//        int ans = 1;
//        int tmp = 0;
//        while (!queue.isEmpty()) {
//            tmp += queue.peekLast();
//
//            if (tmp > sessionTime) {
//                tmp -= queue.peekLast();
//                System.out.println(tmp);
//                while (queue.size() != 1 && queue.peekFirst() + tmp <= sessionTime) {
//                    queue.pollFirst();
//                }
//
//                ans++;
//                tmp = 0;
//            }
//            else{
//
//                queue.pollLast();
//            }
//        }
//        return ans;

    }
}
