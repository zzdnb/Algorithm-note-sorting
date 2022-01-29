package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bellman_Ford {
    static int N = 510;
    static int M = 100010;
    //总点数
    static int n ;
    //总边数
    static int m ;
    //最多经过k条边
    static int k ;
    //记录从1号点到n号的距离
    static int[] dist = new int[N];
    //结构体数组
    static Node[] list = new Node[M];
    static int INF = 0x3f3f3f;
    //备份数组
    static int[] backup = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        k = Integer.valueOf(s[2]);
        for(int i = 0; i < m; i++){
            String[] ss = reader.readLine().split(" ");
            int a = Integer.valueOf(ss[0]);
            int b = Integer.valueOf(ss[1]);
            int c = Integer.valueOf(ss[2]);
            list[i] = new Node(a,b,c);
        }
        bellman_ford();
    }
    static void bellman_ford(){
        Arrays.fill(dist,INF);
        dist[1] = 0;
        for(int i = 0; i < k; i++){
            backup = Arrays.copyOf(dist,n+1);
            for(int j = 0; j < m; j++){
                Node node = list[j];
                int a = node.a;
                int b = node.b;
                int c = node.c;
                dist[b] = Math.min(dist[b],backup[a]+c);

            }
        }
        if(dist[n] > INF/2){
            System.out.println("impossible");
        }else{
            System.out.println(dist[n]);
        }
    }
}
class Node{
    int a,b,c;
    Node(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
