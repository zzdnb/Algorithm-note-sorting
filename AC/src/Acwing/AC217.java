package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC217 {
    static int n,m,N = (int)1e5+10,M = 2*N;
    static int e[] = new int[N],h[] = new int[N],ne[] = new int[M],w[] = new int[M],idx = 0;
    static double f[] = new double[N];
    static int d[] = new int[N];
    static void add(int a,int b,int c){
        e[idx]= b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static double dp(int u){
        if(f[u]>=0){
            return f[u];
        }
        f[u] = 0;
        for(int i = h[u]; i!= -1 ; i = ne[i]){
            int j =e[i];
            f[u] += (w[i]+dp(j))/d[u];
        }
        return f[u];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
            d[a]++;
        }

        Arrays.fill(f,-1);
        System.out.printf("%.2f",dp(1));
    }
}
