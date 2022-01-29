package 笔试面试辅导课;

import java.util.Scanner;

public class AC756 {
    static int N = 110;
    static int n, m;
    static int[][] p = new int[N][N];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void solve() {

        int k = 1, x = 1, y = 1;
        for (int i = 1; i <= n * m; i++) {

            p[x][y] = i;

            int xx = x + dx[k];
            int yy =  y + dy[k];

            if (xx <= 0 || xx > n || yy <= 0 || yy > m || p[xx][yy] != 0) {
                k = (k+1)%4;
                xx = x + dx[k];
                yy = y + dy[k];
            }
            x = xx;
            y = yy;

        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.print(p[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        solve();
    }
}
