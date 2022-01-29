package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    static int N = 510;
    static int n, m;
    static int[][] g = new int[N][N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 0x3f3f3f;
                }
            }
        }
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int t = prim();
        if (t == 0x3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

    }

    static int prim() {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if(dist[t]==0x3f3f3f) {
                return 0x3f3f3f;
            }
            res += dist[t];
            //拿这个点去更新其他所有的点到集合的距离
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j],g[t][j]);
            }

            st[t] = true;
        }
        return res;

    }
}
