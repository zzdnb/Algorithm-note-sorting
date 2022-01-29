package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC4075 {
    static int n, m, k;
    static int N = (int) 2e5 + 10;
    static int p[] = new int[N];
    static int num[] = new int[N];

    static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        Arrays.fill(num, 1);
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        //这个
        int res = 0;
        while (m-- != 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x1 = find(p[l]);
            int y1 = find(p[r]);
            if (x1 != y1) {
                if (num[x1] >= num[y1]) {
                    p[y1] = x1;
                    num[x1] +=num[y1];
                }else{
                    p[x1] = y1;
                    num[y1] +=num[x1];
                }
                res++;
            }
        }
        System.out.println(res);

    }
}
