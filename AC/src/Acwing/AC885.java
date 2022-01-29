package Acwing;

import java.util.Scanner;

public class AC885 {
    static int[][] dp = new int[2010][2010];
    static int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }
        while (n-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(dp[x][y]);
        }
    }
}
