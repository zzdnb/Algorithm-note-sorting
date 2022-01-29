package Acwing;

import java.util.Scanner;

public class AC1027 {
    static int N = 15;
    static int[][][] dp = new int[2 * N][N][N];
    static int[][] w = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c  = sc.nextInt();
        w[a][b] = c;
        while(a!=0||b!=0||c!=0){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            w[a][b] = c;
        }
        for(int k = 2; k <=n*2; k++){
            for(int i1 = 1; i1 <= n; i1++){
                for(int i2 = 1; i2 <= n; i2++){
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if(j1>=1 && j1 <= n &&j2 >=1 && j2 <= n){
                        int x = dp[k][i1][i2];
                        int t = w[i1][j1];

                        if(i1!=i2){
                            t += w[i2][j2];
                        }
                        x = Math.max(x,dp[k-1][i1-1][i2-1]+t); // i1-1,j1 i2-1,j2
                        x = Math.max(x,dp[k-1][i1-1][i2]+t); // i1-1,j1 i2,j2-1
                        x = Math.max(x,dp[k-1][i1][i2-1]+t); // i1,j1-1 i2-1,j2
                        x = Math.max(x,dp[k-1][i1][i2]+t);   // i1,j1-1 i2,j2-2
                        dp[k][i1][i2] = x;
                    }
                }
            }
        }
        System.out.println(dp[n*2][n][n]);


    }
}
