---
title: Leetcode 每日一题
date: 2022-01-05 08:12:47.041
updated: 2022-01-05 08:12:47.041
url: /archives/leetcodemei-ri-yi-ti
categories: 
tags: dp
---

https://leetcode-cn.com/problems/cat-and-mouse/
```java
class Solution {
    static int N = 210;
    //猫会走n个不同的点，老鼠也会走n个不同的点
    static int f[][][] = new int[2*N][N][N];
    int n;
    int[][] g;
    int dp(int k,int i,int j){
        if(f[k][i][j]!=-1){
            return f[k][i][j];
        }
        if(k > n*2){
            f[k][i][j] = 0;
            return 0;
        }
        if(i == 0){
            f[k][i][j] = 1;
            return 1;
        }
        if(i == j){
            f[k][i][j] = 2;
            return 2;
        }
        if(k % 2 == 0){
            int draws = 0;
            for(int x:g[i]){
                int t = dp(k+1,x,j);
                if(t == 1){
                    f[k][i][j] = 1;
                    return 1;
                }
                if(t == 0){
                    draws ++;
                }
            }
            if(draws!=0){
                f[k][i][j] = 0;
                return 0;
            }
                f[k][i][j] = 2;
                return 2;
            
        }else{
            int draws = 0;
            for(int x:g[j]){
                if(x==0){
                    continue;
                }
                int t = dp(k+1,i,x);
                if(t == 2){
                    f[k][i][j] = 2;
                    return 2;
                }
                if(t == 0){
                    draws++;
                }
            }
            if(draws!=0){
                f[k][i][j] = 0;
                return 0;
            }
                f[k][i][j] = 1;
                return 1;
            

        }

    }
    public int catMouseGame(int[][] graph) {
        n = graph.length;
        g = graph;
        for(int i = 0; i < 2*N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    f[i][j][k] = -1;

                }
            }
        }
        return dp(0,1,2);
    }
}
```