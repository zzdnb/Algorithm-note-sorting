package Acwing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC2019 {
    static int N = 1010;
    static int[][] d = new int[N][N], ans = new int[N][N];
    static int x, n, m;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, m});
        ans[n][m] = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0], y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx == N || yy < 0 || yy == N) {
                    continue;
                }
                if (ans[xx][yy] <= d[xx][yy] + ans[x][y]) {
                    continue;
                }
                queue.offer(new int[]{xx, yy});
                ans[xx][yy] = Math.min(d[xx][yy] + ans[x][y],ans[xx][yy]);

            }
        }
        System.out.println(ans[0][0]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        int a, b;
        for(int[] x:ans){
            Arrays.fill(x,(int)1e9);
        }
        while (x-- != 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            d[a][b] = 1;
        }
        bfs();

    }
}
