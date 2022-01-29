package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC {
    static int n, m, x, y, z;
    static char[][] ch = new char[100][100];
    static boolean[][] st = new boolean[100][100];
    static String s;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String ss = sc.next();
            for (int j = 0; j < m ; j++) {
                ch[i][j] = ss.charAt(j);
            }
        }
        s = sc.next();
        dfs(0,0,0,2,2);
        dfs(0,0,0, 1, 2);
        System.out.println(ans);
    }

    static void dfs(int x,int y,int u, int finger, int len) {
        if(flag){
            return;
        }
        if (u >= s.length()) {
            ans = len;
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx <= n && yy >= 0 && yy <= m) {
                if (ch[xx][yy] == s.charAt(u)) {
                    if (finger != i) {
                        dfs(xx,yy,u + 1, i, len + 3);
                    } else {
                        dfs(xx,yy,u + 1, finger, len + 2);
                    }

                }else{
                    if (finger != i) {
                        dfs(xx,yy,u, i, len + 2);
                    }else{
                        dfs(xx,yy,u,finger,len+1);
                    }
                }
            }
        }

    }
}

