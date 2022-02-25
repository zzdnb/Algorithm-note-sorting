package Acwing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AC1184 {
    static int N = (int)1e6+10, M = 4*N;
    int [] h = new int[N],e = new int[M],ne = new int[M],ans = new int[M];
    int idx;
    boolean[] used = new boolean[M];
    int[] din = new int[N],dout = new int[N];
    int n,m,flag,cnt;
    void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    void dfs(int u){
        for(int i = h[u]; i != -1; i = h[u]){
            if(used[i]){
                //主要是反向边
                h[u] = ne[i];
                continue;
            }
            //该条辨被使用过
            used[i] = true;
            if(flag == 1){
                //反向边也被使用过
                used[i^1] = true;
            }
            int t = 0;//下一条边
            if(flag == 1){
                t = i/2 + 1;
                // 0-1 2-3
                if(i % 2 == 1){
                    t = -t;
                }
            }else{
                t = i+1;
            }
            int j =e[i];
            //删边
            h[u] = ne[i];
            dfs(j);


            ans[++ cnt] = t;

        }
    }
//void dfs(int u){
//
//    for(int i=h[u]; i!=-1; i=h[u]){
//
//        if(used[i]){
//            h[u] = ne[i];
//            continue;
//        }
//
//        used[i] = true;
//        if(flag == 1) used[i ^ 1] = true;
//
//        int t;
//        if(flag == 1){
//            t = i / 2 + 1;
//            if(i % 2 == 1) t = -t;
//        }else t = i + 1;
//
//        int j = e[i];
//        h[u] = ne[i];
//        dfs(j);
//
//        ans[++ cnt ] = t;
//    }
//}

    void solve() {
        Scanner sc = new Scanner(System.in);
        flag = sc.nextInt(); n = sc.nextInt(); m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < m; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            add(x,y);
            //无向图
            if(flag == 1){
                add(y,x);
            }
            //无向图，有向图的度数 ++
            din[y]++;dout[x]++;
        }
        if(flag == 1){
            for(int i = 1; i <= n; i++){
                if(((din[i]+dout[i]) & 1 )!= 0){
                    System.out.println("NO");
                    return;
                }
            }
        }else{
            for(int i = 1; i <= n; i++){
                if(din[i]!=dout[i]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(h[i] != -1){
                dfs(i);
                break;
            }
        }
        if(cnt < m){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        for(int i = cnt; i > 0; i--){
            System.out.print(ans[i]+" ");
        }

    }
    public static void main(String[] args) {
        new AC1184().solve();
    }
}
