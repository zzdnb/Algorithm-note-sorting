package pipi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] s = read.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] ss = read.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(ss[j]);
            }
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j = 0; j < m; j++) {
                res = Math.max(res, arr[i][j]);
            }
            arr1[i] = res;
        }
        for (int i = 0; i < m; i++) {
            int res = 0;
            for (int j = 0; j < n; j++) {
                res = Math.max(res, arr[j][i]);
            }
            arr2[i] = res;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    res +=0;
                } else {
                    res += (long) Math.min(arr1[i], arr2[j]) - arr[i][j];
                }
            }
        }
        System.out.println(res);
    }
}
