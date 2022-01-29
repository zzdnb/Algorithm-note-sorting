package Acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 堆优化版的Dijkstra算法
 */
public class Dijkstra2 {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int[] h = new int[N],w = new int[N],e = new int[N],ne = new int[N];
    static int idx;
    static int n,m;
    static void add(int a,int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1,o2)->{
            return o1[0] - o2[0];
        });

        //将一号点放进去，距离是0，编号是1
        queue.offer(new int[]{0,1});
        while(!queue.isEmpty()){
            int[] t = queue.poll();

            int distance = t[0];
            int ver = t[1];
            if (st[ver]){
                continue;
            }
            st[ver] = true;
            for(int i = h[ver]; i!=-1; i = ne[i]){
                int j = e[i];
                if(dist[j] > distance + w[i]){
                    dist[j] =  distance + w[i];
                    queue.offer(new int[]{dist[j],j});
                }
            }
        }
        if(dist[n]!= 0x3f3f3f3f){
            return dist[n];
        }else{
            return -1;
        }
    }
}
