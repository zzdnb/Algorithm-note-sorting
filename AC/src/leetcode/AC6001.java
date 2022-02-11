package leetcode;

import java.util.BitSet;
import java.util.Scanner;

public class AC6001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        System.out.println(new AC6001().smallestNumber(s));

    }

    public long smallestNumber(long num) {
        if (num == 0) {
            return num;
        }
        long[] nums = new long[10];
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        for(int i = 0; i < String.valueOf(num).length(); i++){
            nums[String.valueOf(num).charAt(i)-'0']++;
        }
        long ans = 0;
        boolean fi = false;
        if (!flag) {
            for (int i = 1; i < 10; i++) {
                if (nums[i] != 0 && !fi) {
                    ans = ans * 10 + i;
                    nums[i]--;
                    fi = true;
                    while (nums[0] != 0) {
                        ans = ans * 10 + 0;
                        nums[0]--;
                    }
                }
                while (nums[i] != 0) {
                    ans = ans * 10 + i;
                    nums[i]--;
                }
            }

        } else {
            for (int i = 9; i >= 0; i--) {
                while (nums[i] != 0) {
                    ans = ans * 10 + i;
                    nums[i]--;
                }
            }
            ans = -ans;
        }
        String s = "0011";
        BitSet set = new BitSet(4);
        set.flip(0,set.length());
        System.out.println(set);
        return ans;

    }
}

