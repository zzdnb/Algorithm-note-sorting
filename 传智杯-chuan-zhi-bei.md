---
title: 传智杯
date: 2021-12-19 19:33:05.667
updated: 2021-12-19 19:34:26.693
url: /archives/chuan-zhi-bei
categories: 算法
tags: 质数线性筛法
---

[TOC]（标题）


> https://www.luogu.com.cn/contest/58544#problems
## 第一题：
```java
package luogu;

import java.util.Scanner;

public interface A_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int ans = (int)(a*0.2+b*0.3+c*0.5);
        System.out.println(ans);
    }
}

```
## 第二题：
```java
package luogu;

import java.util.Scanner;

public class B_2021 {
    static int T;
    static int a,p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- != 0){
            a = sc.nextInt();
            p = sc.nextInt();
            if(p < 16){
                a = a-10;
                if(a < 0){
                    a = 0;
                }
            }
            if(p > 20){
                a = a - (p-20)*1 ;
                if(a <= 0){
                    a = 0;
                }
            }
            System.out.println(a);
        }
    }
}

```
## 第三题：
```java
package luogu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1010];
        int n = sc.nextInt();
        int maxx = 0,minn = 1010;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            maxx = Math.max(arr[i],maxx);
            minn = Math.min(arr[i],minn);
        }

        for(int i = 0; i < n; i++){
            arr[i] = 100*(arr[i]-minn)/(maxx-minn);
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }

    }
}

```
## 第四题：
> 线性筛法加找规律，用二进制优化
```
package luogu;

import java.util.Scanner;

public class D_2021 {
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] st = new boolean[(int)2e6+20];
        int[] f = new int[(int)2e6+20];
        int[] primes = new int[(int)2e6+20];

        int cnt = 0;
        for(int i = 2; i <= 2e6+10; i++){
            if(!st[i]){
                primes[cnt++] = i;
            }
            //但凡是前边质数的倍数都不是质数，是合数 只需要将所有质数的倍数删了即可
            for(int j = 0;primes[j] <= (2e6+10)/i; j++){
                st[primes[j]*i] = true;
                if(i%primes[j] == 0){
                    break;
                }
            }

        }
        for(int i = 1,j = 0,k = 2; i <= 30; i++,k*=2){
            if(k > primes[cnt-1]){
                break;
            }
            for(int l = j; primes[l] < k;l++,j++){
                f[i]++;
            }
        }

        T = sc.nextInt();
        System.out.println(cnt);
        while(T-- != 0){
            int x = sc.nextInt();
            int k = 0,sum = 0;
            while (x!=0){
                if((x&1) == 1){
                    sum += f[k+1];
                }
                k++;
                x >>= 1;
            }

            System.out.println(sum);
        }




    }
}

```
## 第五题：
```java
package luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_2021 {
    static int n,k;

    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i <= k; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            list.add(tmp);
        }
        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            if(s == 1){
                int p = sc.nextInt();
                while(p-- != 0){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                        list.get(x).add(y);

                }

            }else{
                int x = sc.nextInt();
                int y1 = sc.nextInt();
                int y2 = sc.nextInt();
                if(list.get(x)==null){
                    System.out.println(0);
                }else{
                    int cnt = 0;
                    for(int xx:list.get(x)){
                        if (xx>=y1&& xx<=y2){
                            cnt++;
                        }
                    }
                    System.out.println(cnt);
                }

            }

        }
    }
}




```
