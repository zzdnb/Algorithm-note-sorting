package pipi;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AC1253 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return ((o2[0] - o2[1]) - (o1[0] - o1[1]));
                }
            });

            long res = 0;
            for (int i = 1; i <= n; i++) {

                res += (i - 1) * nums[i - 1][0] + (n - i) * nums[i - 1][1];
            }
            System.out.println(res);
        }
    }
}