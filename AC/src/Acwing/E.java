package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class E {
    public static int[] p = new int[100010];

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = read.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while ((m--) != 0) {
            String[] s = read.readLine().split(" ");
            if (s[0].equals("M")) {
                p[find(Integer.valueOf(s[1]))] = find(Integer.valueOf(s[2]));
            } else {
                if (find(Integer.valueOf(s[1])) == find(Integer.valueOf(s[2]))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int find(int x) {//返回x的祖宗节点+路径压缩
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}