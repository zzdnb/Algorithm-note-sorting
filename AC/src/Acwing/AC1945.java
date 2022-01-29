package Acwing;

import java.io.*;
import java.util.*;

public class AC1945 {
    static class JoinSet {
        int[] fa;

        JoinSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int t) {
            if (t != fa[t]) {
                fa[t] = find(fa[t]);
            }
            return fa[t];
        }

        void join(int x, int y) {
            x = find(x);
            y = find(y);
            fa[x] = y;
        }
    }

    static int mod = (int) 1e9 + 7;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[] dx1 = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy1 = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy2 = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[] prime = new boolean[10];

    static {
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int k = 2; i * k < prime.length; k++) {
                    prime[i * k] = false;
                }
            }
        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }

    static int powmod(long a, long b, int mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return (int) ans;
    }

    static void sort(int[] a) {
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    static void sort(long[] a) {
        int n = a.length;
        Long[] b = new Long[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static int max(int[] a) {
        int max = a[0];
        for (int i : a) {
            max = max(max, i);
        }
        return max;
    }

    static int min(int[] a) {
        int min = a[0];
        for (int i : a) {
            min = min(min, i);
        }
        return min;
    }

    static long max(long[] a) {
        long max = a[0];
        for (long i : a) {
            max = max(max, i);
        }
        return max;
    }

    static long min(long[] a) {
        long min = a[0];
        for (long i : a) {
            min = min(min, i);
        }
        return min;
    }

    static int[] dis;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = sc.nextInt();
        }
        Arrays.sort(dis);
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++){
                int l = j+1,r = n-1;
                int tmp = 0;
                int x = dis[j]-dis[i];
                while(l < r){
                    int mid = (l+r)>>1;
                    if(dis[mid]-dis[j]>=x){
                        r = mid;
                    }else{
                        l = mid+1;
                    }
                }
//                System.out.println(l);
                tmp = l;
                l = i+2;
                r = n-1;
                while(l < r){
                    int mid = (l+r+1)>>1;
                    if(dis[mid]-dis[j]<=2*x){
                        l = mid;
                    }else{
                        r = mid-1;
                    }
                }
                if(tmp == 0){
                    continue;
                }
                if(dis[tmp]-dis[j]>=x&&dis[tmp]-dis[j]<=2*x &&dis[r]-dis[j]>=x&&dis[r]-dis[j]<=2*x){
                    ans += r-tmp+1;
                }



            }
        }
        System.out.println(ans);
    }
}

