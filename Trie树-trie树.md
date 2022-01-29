---
title: Trie树
date: 2022-01-13 19:48:58.996
updated: 2022-01-19 22:48:52.276
url: /archives/trie树
categories: 算法
tags: 
---

[TOC]()
## Trie树

快速存储和查找字符串集合的数据结构

![trie.png](https://cdn.acwing.com/media/article/image/2021/01/18/35590_a624568f59-trie.png)
![](https://cdn.acwing.com/media/article/image/2020/06/13/31041_aed49a42ad-Trie2.PNG)

## 142. 前缀统计
```java
import java.util.*;
class Main{
    static int N = (int)1e6+10;
    static int[][]ch = new int[N][26];
    static int idx = 0;
    static int[] end = new int[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(n-- !=0){
            String s = sc.next();
            insert(s);
        }
        while(m-- !=0){
            String s = sc.next();
            System.out.println(find(s));
        }
    }
    public static void insert(String str){
        char[] c = str.toCharArray();
        int p = 0;
        for(int i = 0; i < c.length; i++){
            int x = c[i]-'a';
            if(ch[p][x]==0){
                ch[p][x] = ++idx;
            }
            p = ch[p][x];
        }
        end[p] ++;
    } 
    public static int find(String str){
        int cnt = 0;
        char[] c = str.toCharArray();
        int p = 0;
        for(int i = 0; i < c.length; i++){
            int x = c[i]-'a';
            if(ch[p][x]==0){
                return cnt;
            }
            p = ch[p][x];
            cnt += end[p]; 
        }
       
        return cnt;
    }
    
}
```
## 835. Trie字符串统计
```
import java.util.*;
class Main{
    static int N = 100005;
    //存储节点
    static int[][] arr = new int[N][26];
    //以当前单词结尾的单词的个数
    static int[] end = new int[N];
    //根节点，也是空节点
    static int idx = 0;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while((n--)!=0){
            String s = sc.next();
            if("Q".equals(s)){
                String ss = sc.next();
                System.out.println(query(ss));
            }else{
                String ss = sc.next();
                insert(ss);
            }
        }
    }
    public static int query(String s){
        char[] ch = s.toCharArray();
        int p = 0;
        for(int i = 0; i < ch.length; i++){
            int x = ch[i] - 'a';
            if(arr[p][x]==0){
                return 0;
            }
            p = arr[p][x];
        }
        return end[p];
    }
    public static void insert(String s){
        int p = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            int x = ch[i] - 'a';
            if(arr[p][x]==0){
                arr[p][x] = ++idx;
            }
            p  = arr[p][x];
        }
        end[p]++;
    }
}
```

## 143. 最大异或对



 

```
import java.util.*;
import java.io.*;

class Main{

    static int idx;
    static int[][] son = new int[3000000][2];

    static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i--){
            int u = (x >> i)&1;
            if(son[p][u] == 0){
                son[p][u] = ++ idx;
            }
            p = son[p][u];
        }
    }
     static int query(int x){
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            
            int u = (x >> i) & 1;
            if(son[p][1-u] != 0){
                //因为这里存的就是结果 我们要知道如果是1的话，两位是相对的，所以肯定是异或肯定是1
                res += (1 << i);
                p = son[p][1-u];
            }else{
                p = son[p][u];
            }
        }
        return res;
    }
     public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            insert(a[i]);
            res = Math.max(res,query(a[i]));
        }
        
        System.out.println(res);
    }
}
```
