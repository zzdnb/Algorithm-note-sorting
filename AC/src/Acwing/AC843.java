package Acwing;

import java.util.Scanner;

public class AC843 {

    static int N = 20, n;
    static boolean[] col = new boolean[N], dg = new boolean[N], udg = new boolean[N];
    static char[][] ch = new char[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch[i][j] = '.';
            }
        }
        dfs(0);
    }

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ch[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[-u + n + i]) {
                ch[u][i] = 'Q';
                col[i] = dg[u + i] = udg[-u + i + n] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[-u + i + n] = false;
                ch[u][i] = '.';
            }
        }
    }


}
