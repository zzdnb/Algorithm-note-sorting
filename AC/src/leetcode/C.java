package leetcode;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(countBalls(1,10));
    }


    public static int countBalls(int l, int h) {
        int[] arr = new int[40];
        for (int i = l; i <= h; i++) {
        int res = 0;
        int tmp = i;
        while (tmp != 0) {
            res += tmp % 10;
            tmp /= 10;
        }
        arr[res]++;
    }
    int res = 0;
        for (int i = 0; i < 40; i++) {
        res = Math.max(res, arr[i]);
    }
        return res;
}
}