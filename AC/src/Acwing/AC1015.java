package Acwing;

import java.util.Scanner;
//
public class AC1015 {
    static int T;
    static int N = 110;
    static int [][] dp= new int[N][N],p = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- != 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i = 1; i <= n; i++){
                for (int j = 1; j <= m; j++){
                    p[i][j] = sc.nextInt();
                }
            }
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    dp[i][j] = p[i][j] + Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            System.out.println(dp[n][m]);
        }

    }
}
