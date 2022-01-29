package Acwing;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AC4074 {
    static int N = 410, M = 100000;
    static int g[][] = new int[N][N];
    static boolean st[] = new boolean[N];
    static int dist[] = new int[N];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int  i = 0;i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x][y] = g[y][x] = 1;
        }
        int ans1 =  dijstra(0);
        int ans2 = dijstra(1);
//        System.out.println(ans1+" "+ans2);
        if(ans1==-1||ans2 == -1){
            System.out.println(-1);
        }else{
            System.out.println(Math.max(ans1,ans2));
        }
    }
    static int dijstra(int x){
        Arrays.fill(dist,0x3f3f3f3f);
        Arrays.fill(st,false);
        dist[1] = 0;
        for(int i = 1; i <= n; i++){
            int t = -1;
            for(int j = 1; j <=n;j++){
                if(!st[j]&&(t==-1|| dist[t] > dist[j])){
                    t = j;
                }
            }
            st[t] = true;

            for(int j = 1; j <= n; j++){
                if( g[t][j] == x){
                    dist[j] = Math.min(dist[j],dist[t]+1);
                }else{
                    continue;

                }

            }


        }
        if(dist[n]!=0x3f3f3f3f){
            return dist[n];
        }else{
            return -1;
        }
    }
}
