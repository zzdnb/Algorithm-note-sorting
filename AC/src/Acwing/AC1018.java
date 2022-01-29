package Acwing;

import java.util.Scanner;

public class AC1018 {
    static int N = 110;
    static int[][] dp = new int[N][N], p = new int[N][N];
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = (int)(1e9);
            }
        }
        dp[0][1] = 0;
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                p[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = p[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
//        for(int i = 0; i <= n; i++){
//            for(int j = 0; j <= n; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][n]);
    }
}
