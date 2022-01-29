---
title: ACWING周赛
date: 2021-12-19 19:41:24.865
updated: 2021-12-19 19:41:24.865
url: /archives/acwing-zhou-sai
categories: 算法
tags: 公约数 | 合法括号序列
---

[TOC](这里写目录标题)

## 4197. 吃苹果
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(x <= m){
                sum += 1;

            }else{
                sum+=2;
            }
        }
        System.out.println(sum);
    }
}

```
## AcWing 4198. 最长合法括号子串
```java


import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        char[] ch = s.toCharArray();
        stk.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(i);
            else {
                stk.pop();
                if (stk.isEmpty()) stk.push(i);
                else {
                    res = Math.max(res, i - stk.peek());
                    if(res == i-stk.peek()){
                        map.put(res,map.getOrDefault(res,0)+1);
                    }

                }
            }
        }


        if (res == 0) {
            System.out.println(0 + " " + 1);
        } else {
            System.out.println(res + " " + map.get(res));
        }




    }
}
```
## AcWing 4199. 公约数
```java


import java.util.TreeSet;
import java.util.Scanner;

public class Main {
    static int a, b;
    static  TreeSet<Integer> set3 = new TreeSet<>();
    static void solve(int l, int r) {
        int ans = -1;

        for (int x : set3) {
            if (x >= l && x <= r) {
                ans = x;
            }
            if(x>r){
                break;
            }

        }
   System.out.println(ans);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int q = sc.nextInt();
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        set1.add(1);
        set1.add(a);

        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                set1.add(i);
                set1.add(a/i);
            }
        }

        set2.add(1);
        set2.add(b);

        for (int i = 2; i <= b / i; i++) {

            if (b % i == 0) {
                set2.add(i);
                set2.add(b/i);
            }

        }



        for (int x : set1) {
            if (set2.contains(x)) {
                set3.add(x);
            }
        }

        while (q-- != 0) {

            int l = sc.nextInt();
            int r = sc.nextInt();
            solve(l, r);
        }

    }
}

```

