package Acwing;

import java.util.*;

/**
 * spfa判断负环
 */
public class Spfa2 {
    static int N = 2010;
    static int M = 10010;
    static int[] dist = new int[N];//从x点到各个点的距离
    static boolean[] st = new boolean[N];
    static int[] h = new int[N], w = new int[M], e = new int[M], ne = new int[M], cnt = new int[M];
    static int idx;
    static int n, m;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        if (spfa()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean spfa() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;

                    if (cnt[j] >= n) {
                        return true;
                    }
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }
        return false;
    }
}