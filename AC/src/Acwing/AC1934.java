package Acwing;

import sun.plugin2.message.JavaScriptCallMessage;

import java.io.*;
import java.util.*;

public class AC1934 {
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

    //x/2+1
    static int N = 10010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt1 = 0, cnt2 = 0;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("T")) {
                arr1[cnt1++] = sc.nextInt();
            } else {
                arr2[cnt2++] = sc.nextInt();
            }
        }

        arr1 = Arrays.copyOf(arr1, cnt1 );
        arr2 = Arrays.copyOf(arr2, cnt2 );
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //计算距离与时间
        double t = 0, dis = 0, speed = 1;
        System.out.println(arr1.length+" "+arr2.length);;
        cnt1 = 0;
        cnt2 = 0;
        while (cnt1 < arr1.length && cnt2 < arr2.length && dis < 1000) {
            double a = arr1[cnt1] - t;
            double b = (arr2[cnt2] - dis) * speed;

            if (a < b) {
                t = arr1[cnt1];
                dis += (a / speed);
                cnt1++;
            } else if (a > b) {
                dis = arr2[cnt2];
                t += b;
                cnt2++;
            } else {
                dis = arr2[cnt2];
                t = arr1[cnt1];
                cnt1++;
                cnt2++;
                speed++;
            }
            speed++;


        }

        while (cnt1 < arr1.length && dis < 1000) {
            dis += (arr1[cnt1] - t)/speed;
            t = arr1[cnt1];
            cnt1++;
            speed++;
        }
        while(cnt2 < arr2.length && dis < 1000) {
            t += (arr2[cnt2] - dis) * speed;
            dis = arr2[cnt2];
            cnt2++;
            speed++;
        }
        if(dis < 1000){
            t += (1000-dis)*speed;
        }
        System.out.println((int) Math.round(t));

    }
}

