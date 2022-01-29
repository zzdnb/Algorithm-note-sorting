package Acwing;

import java.util.Scanner;

public class AC3417 {
    static int N = 110, M = 100005;
    static int n, sum;
    static int[] w = new int[N];
    static boolean[][] f = new boolean[N][M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            sum += w[i];
        }

        f[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                f[i][j] = f[i - 1][j] || f[i - 1][j + w[i]] || f[i - 1][Math.abs(j - w[i])];
            }
        }
        //只要有一个非空,f[i][j]就非空
        int ans = 0;
        for (int i = 1; i <= sum; i++) {
            if (f[n][i]) {
                ans++;//不为零说明可以选出这个质量的砝码
            }
        }

        System.out.println(ans);


    }


}

