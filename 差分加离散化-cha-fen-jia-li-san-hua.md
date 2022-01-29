---
title: 差分加离散化
date: 2022-01-15 12:44:17.045
updated: 2022-01-15 12:44:17.045
url: /archives/cha-fen-jia-li-san-hua
categories: 算法
tags: 
---

[TOC]()
## AcWing 1969. 品种邻近
```java
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(map.get(x)==null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(x,list);
            }else{
                map.get(x).add(i);
            }
        }
        int ans = -1;
        for(int x:map.keySet()){
            int pre = map.get(x).get(0);
            for(int i = 1; i < map.get(x).size();i++){
                if(Math.abs(map.get(x).get(i)-pre)<=k){
                    ans = x;
                    break;
                }
                pre = map.get(x).get(i);
            }
        }
        System.out.println(ans);
    }
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2287615/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
## AcWing 1952. 金发姑娘和 N 头牛
```java
import java.io.*;
import java.util.*;
public class Main {
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
    static int mod = (int)1e9+7;
    static int[]dx = {-1,0,1,0},dy = {0,1,0,-1};
    static int[] dx1 = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy1 = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dx2= {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy2= {1, 2, 2, 1, -1, -2, -2, -1};
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
        return Math.max(a,b);
    }
    static int min(int a, int b) {
        return Math.min(a,b);
    }
    static long max(long a, long b) {
        return Math.max(a,b);
    }
    static long min(long a, long b) {
        return Math.min(a,b);
    }
    static int max(int[] a) {
        int max = a[0];
        for(int i : a) {
            max = max(max,i);
        }
        return max;
    }
    static int min(int[] a) {
        int min = a[0];
        for(int i : a) {
            min = min(min,i);
        }
        return min;
    }
    static long max(long[] a) {
        long max = a[0];
        for(long i : a) {
            max = max(max,i);
        }
        return max;
    }
    static long min(long[] a) {
        long min = a[0];
        for(long i : a) {
            min = min(min,i);
        }
        return min;
    }
    //离散化+差分  枚举每一个点
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            map.put(0,map.getOrDefault(0,0)+x);
            map.put(a,map.getOrDefault(a,0)-x+y);
            map.put(b+1,map.getOrDefault(b+1,0)-y+z);
        }
        int res = 0,pre = 0;
        for(int i:map.keySet()){
            pre += map.get(i);
            res = max(pre,res);
        }
        System.out.println(res);;
    }
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2306761/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## AcWing 1987. 粉刷栅栏
```java
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>((Comparator.comparingInt(o -> o)));
        int n = sc.nextInt();
        int now = 0;
        while(n-- != 0){
            int x = sc.nextInt();
            if(sc.next().equals("R")){
                map.put(now,map.getOrDefault(now,0)+1);
                now += x;
                map.put(now,map.getOrDefault(now,0)-1);
            }else{
                map.put(now,map.getOrDefault(now,0)-1);
                now -= x;
                map.put(now,map.getOrDefault(now,0)+1);
            }

        }
        int ans = 0,sum = 0,pre = 0;
        for(int x:map.keySet()){
            if(sum >= 2){
                ans+= x-pre;
            }
            sum +=map.get(x);
            pre = x;
        }
        System.out.println(ans);
    }
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2279835/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```