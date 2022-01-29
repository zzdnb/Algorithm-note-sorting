package Acwing;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 堆优化版的Dijkstra算法
 */
public class Spfa {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
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
        int t = spfa();
        if(t== -1){
            System.out.println("impossible");
        }else{
            System.out.println(t);
        }
    }

    static int spfa() {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        st[1] = false;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }  if (dist[n] == 0x3f3f3f) {
            return -1;
        }else {
            return dist[n];
        }
    }
}