package leetcode;

import java.util.Arrays;

public class K {
}

class Solutio {
    public static void main(String[] args) {
        System.out.println(canChoose(new int[][]{{1, 2, 3}, {3, 4}}, new int[]{7, 7, 1, 2, 3, 4, 7, 7}));
    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String s = sb.toString();
        System.out.println(s);
        for (int[] x : groups) {
            sb = new StringBuilder();
            for (int i = 0; i < x.length; i++) {
                sb.append(x[i]);
            }
            String ss = sb.toString();
            System.out.println(ss);
            if (s.contains(ss)) {
                s = s.substring(s.indexOf(ss) + ss.length());
                System.out.println(s);
            } else {
                return false;
            }
        }
        return true;
    }
}