---
title: 剪绳子
date: 2022-01-02 09:52:02.207
updated: 2022-01-02 09:53:07.431
url: /archives/jian-sheng-zi
categories: 算法
tags: 剑指OFFER | dp
---

## 剑指OFFER 剪绳子
问题本质：将一个正整数拆分成至少两个正整数之和，求这些正整数的最大乘积。

方法一：动态规划
定义 dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积。

因为 0 和 1 都不能再分，所以 dp[0]=dp[1]=0。

当 i≥2 时，设拆分出的第一个正整数为 j（1≤j<i），此时有以下两种方案：

将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分，此时的乘积是j×(i−j) 。
将 i 拆分成 j 和 i−j的和，且 i−j继续拆分，此时的乘积是 j×dp[i−j] 。
则 dp[i] 取两种方案的较大值。

总结如下：


状态定义：dp[i] 表示将正整数 i 拆分成至少两个正整数之和，这些正整数的最大乘积

转移方程：
dp[i]=max(dp[i],max((j×(i−j),j×dp[i−j]))

初始化：dp[0]=dp[1]=0

时空复杂度
时间复杂度：O(n2)
空间复杂度：O(n)
```java
class Solution {
    public int maxProductAfterCutting(int length)
    {
         //dp[i]：长度为i的划分的段数的乘积的集合
    //最大值
    // dp[i] = max(j * dp[i-j],j*(i-j));

        int[] dp = new int[length+1];
        for(int i = 2; i <= length; i++){
            for(int j = 0; j < i; j++){
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[length];
    
    }
}
```
