package lanqiao;


import java.util.Scanner;

public class L {
    static int N = 10010;
    static int n, m;
    static int[] p = new int[N];
    static int[] d = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- != 0) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (t == 1) {
                a = find(a);
                b = find(b);
                if (a != b) {
                    d[a] -= d[b];
                    p[a] = b;
                }
            } else {
                a = find(a);
                d[a] += b;
            }

        }
        for (int i = 1; i <= n; i++) {
            if (i == find(i)) {
                System.out.print(d[i]+" ");
            } else {
                System.out.print(d[i] + d[find(i)]+" ");
            }
        }

    }

    static int find(int x) {
        if (p[x] == x || p[p[x]] == p[x]) {
            return p[x];
        }
        int r = find(p[x]);
        d[x] += d[p[x]];
        p[x] = r;
        return r;
    }
}
