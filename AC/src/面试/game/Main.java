package 面试.game;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两种方法：1.暴力2.时间换空间
 */
public class Main {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] ch = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                ch[i][j] = s.charAt(j);
            }
        }
        System.out.println(Arrays.toString(solve2(ch)));
    }

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static int[] solve1(char[][] board) {
        int ans = 0;
        int[] arr = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int res = 0;
                if (board[i][j] == '0') {
                    for (int k = 0; k < 4; k++) {
                        int xx = i + dx[k], yy = j + dy[k];
                        while (xx >= 0 && xx < n && yy >= 0 && yy < m && board[xx][yy] != 'W') {
                            if (board[xx][yy] == 'R' || board[xx][yy] == 'B' || board[xx][yy] == 'Y') {
                                res++;
                            }
                            xx = xx + dx[k];
                            yy = yy + dy[k];
                        }
                    }
                    if (res > ans) {
                        ans = res;
                        arr[0] = i;
                        arr[1] = j;
                    }

                }


            }
        }
        return arr;
    }

    public static int[] solve2(char[][] board) {
        int[][] rows = new int[n][m], cols = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ('0' == board[i][j]) {
                    continue;
                }
                if ("BRY".contains("" + board[i][j])) {
                    int l = i-1, r = i+1;
                    while (l >= 0) {
                        if (board[l][j] == 'W') {
                            break;
                        }
                        rows[l--][j] += 1;
                    }

                    while (r < n) {
                        if (board[r][j] == 'W') {
                            break;
                        }
                        rows[r++][j] += 1;
                    }
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ('0' == board[i][j]) {
                    continue;
                }
                if ("BRY".contains("" + board[i][j])) {
                    int l = j-1, r = j+1;
                    while (l >= 0) {
                        if (board[i][l] == 'W') {
                            break;
                        }
                        rows[i][l--] += 1;
                    }
                    while (r < m) {
                        if (board[i][r] == 'W') {
                            break;
                        }
                        rows[i][r++] += 1;
                    }
                }

            }
        }
        int ans[] = new int[2], res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res < rows[i][j] + cols[i][j]) {
                    res = rows[i][j] + cols[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;

    }
}

