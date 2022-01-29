package Acwing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AC13 {
    static char[] arr = new char[10];
    static boolean[] st = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dfs(0);

        while (t-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] pos = new char[n][m];
            int x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    pos[i][j] = s.charAt(j);
                    if (pos[i][j] == 'S') {
                        x = i;
                        y = j;
                    }
                }
            }
            String test = sc.next();
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            int ans = 0;
            for (String s : list) {
                int xx = x;
                int yy = y;
                for (char c : test.toCharArray()) {

                    xx = xx + dx[s.charAt(c-'0')-'0'];
                    yy = yy + dy[s.charAt(c-'0')-'0'];
                    if(xx < 0|| xx >= n|| yy < 0 || yy>= m||pos[xx][yy]=='#'){
                        break;
                    }else if (pos[xx][yy] =='E'){
                        ans++;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static void dfs(int u) {

        if (u == 4) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 4; i++) {

                s.append(arr[i]);
            }

            list.add(s.toString());
            return;
        }
        for (int i = 0; i <= 3; i++) {
            if (!st[i]) {
                arr[u] = (char) (i+'0');
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}

