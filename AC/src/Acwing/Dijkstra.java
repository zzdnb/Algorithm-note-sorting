package Acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dijkstra算法
 */
public class Dijkstra {
    static int N = 510;
    static int[][] g =  new int[N][N];
    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j){
                    g[i][j] = 0;
                }else{
                    g[i][j] = 0x3f3f3f;
                }
            }

        }
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = Math.min(g[a][b],c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        Arrays.fill(dist,0x3f);
        dist[1] = 0;
        for(int i = 0; i < n; i++){
            //表示还没有确定距离当前点最近的点
            int t = -1;
            for(int j = 1; j <= n; j++){
                //如果当前点没有确定最短路并且
                if(!st[j]&&(t==-1||dist[t]>dist[j])){
                    t = j;
                }

            }
            System.out.println(t);
            st[t] = true;
            //再拿这个点去更新其他的点
            for (int j = 1; j <= n; j++){
                dist[j] = Math.min(dist[j],dist[t]+g[t][j]);
                System.out.println(dist[j]);
            }


        }
        if (dist[n]==0x3f){
            return -1;
        }else{
            return dist[n];
        }
    }
}
