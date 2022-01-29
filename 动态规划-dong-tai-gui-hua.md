---
title: 动态规划
date: 2022-01-07 12:33:20.913
updated: 2022-01-29 00:05:18.227
url: /archives/dong-tai-gui-hua
categories: 算法
tags: dp
---

[TOC]()

## 1.1 背包问题
### 1.1.1 01背包
#### LeetCode416.分割等和子集
```java
class Solution {
    //体积为ai，背包容量为sum/2
    //dp[j] 前i个物品总体积不超过j的选法的集合
    //属性是 true,false[恰好装满背包]
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        
        for(int x:nums){
            sum += x;
        }
        boolean[]dp = new boolean[sum/2+1];
        if(sum%2 != 0){
            return false;
        }
        dp[0] = true;
        for(int x:nums){
            for(int j = sum/2; j >= x; j--){
                dp[j] |= dp[j-x];
            }
        }
        return dp[sum/2];
    }
}
```
#### LeetCode494.目标和
```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //前i个物品且总和为j 的选法的集合 数量
        // 两种选法 选+和选-
        //为正：dp[i][j] = dp[i-1][j-a[i]]
        //为负：dp[i][j] = dp[i-1][j+a[i]]
        //定义一个偏移量offset[-1000,1000]->[0,2000]

        if(target < -1000 || target > 1000){
            return 0;
        }
        int n = nums.length,offset = 1000;
        int[][]dp = new int[n+1][2010];
        dp[0][1000] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = -1000; j <= 1000; j++){
                if(j - nums[i-1] >= -1000){
                    dp[i][j+offset] += dp[i-1][j-nums[i-1]+offset];
                }
                if(j + nums[i-1] <= 1000){
                    dp[i][j+offset] += dp[i-1][j+nums[i-1]+offset];
                }
            }
        }
        return dp[n][target+offset];
    }
}
```
## 1.1.2 完全背包
#### LeetCode279.完全平方数
#### LeetCode322.零钱兑换
#### LeetCode518.零钱兑换Ⅱ
## 1.1.3 二维费用背包
#### LeetCode474.一和零
## 1.1.4 求具体方案
#### LeetCode1449.数位成本和为目标值的最大数字
## 1.2 LIS模型
#### LeetCode300.最长上升子序列
#### LeetCode354.俄罗斯套娃信封问题（二维LIS）
#### LeetCode368.最大整除子集（LIS求方案）
#### LeetCode1626.无矛盾的最佳球队（二维LIS+LIS最大和）
#### LeetCode1691.堆叠长方体的最大高度（贪心+三维LIS）
## 1.3 线性DP
#### LeetCode53.最大子数组和
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[]dp = new int[nums.length+1];
        dp[1] = nums[0];
        int ans = nums[0];
        for(int i = 2; i <= nums.length;i++){
            dp[i] = nums[i-1] +Math.max(0,dp[i-1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
```
#### LeetCode62.不同路径
#### LeetCode63.不同路径Ⅱ
LeetCode64.最小路径和
#### LeetCode70.爬楼梯（递推）
#### LeetCode72.编辑距离即AcWing 902. 最短编辑距离
> 解题思路：状态表示以及状态计算
状态表示：f[i][j]：集合：所有将a[1..i]变成b[1..j]的操作方式
状态计算：
删除：a的[1..i-1]与b的[1..j]匹配 f[i][j] = f[i-1][j]+1
增加：a的[1..i]与b的[1..j-1]匹配 f[i][j] = f[i][j-1]+1
改变：
1.如果相等的话，就不需要改变了 f[i][j] = f[i-1][j-1]
2.如果不相等的话，就+1 f[i][j] = f[i-1][j-1] + 1
最后取个最小值min
```java


import java.io.*;
import java.util.*;
public class  Main{
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

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); String s1 = sc.next();
        int m = sc.nextInt(); String s2 = sc.next();
        int dp[][] = new int[n+1][m+1];
        //表示A的1.。i到b的1.。j的操作次数的最小值
        //初始化边界
	//如果A的长度为0只能增加i个
        for(int i = 1; i <= m; i++){
            dp[0][i] = i;
        }
	//如B的长度为0只能删除i个
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        System.out.println(dp[n][m]);



    }
}


```
#### NC35 编辑距离(二)
```java
import java.util.*;


public class Solution {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int n = str1.length();
        int m = str2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 1; i <= m; i++){
            dp[0][i] = i*ic;
        }
        for(int i = 1; i <= n; i++){
            dp[i][0] = i*dc;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.min(dp[i-1][j]+dc,dp[i][j-1]+ic);
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+rc);
                }
            }
        }
        return dp[n][m];
    }
}
```
#### LeetCode91.解码方法
#### LeetCode96.不同的二叉搜索树（递推）
#### LeetCode97.交错字符串
#### LeetCode115.不同的子序列
#### LeetCode118.杨辉三角
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        int[][] arr = new int[numRows+1][numRows+1];
        arr[0][0] = 1;
        for(int i = 1; i <= numRows; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                list.add(arr[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
}
```
#### LeetCode119.杨辉三角Ⅱ
滚动数组来优化
```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[rowIndex+1];
        for(int i = 0; i <= rowIndex; i++){
            dp[i] = 1;
            for(int j = i-1; j > 0; j--){
                dp[j] = dp[j]+dp[j-1];
            }
        }
        for(int i = 0; i <= rowIndex; i++){
            list.add(dp[i]);
        }
        return list;
    }
}
```
```c++
class Solution {
public:
    vector<int> getRow(int n) {
        vector<vector<int>> f(2, vector<int>(n + 1));
        for (int i = 0; i <= n; i ++ ) {
            f[i & 1][0] = f[i & 1][i] = 1;
            for (int j = 1; j < i; j ++ )
                f[i & 1][j] = f[i - 1 & 1][j - 1] + f[i - 1 & 1][j];
        }
        return f[n & 1];
    }
};

```
#### LeetCode120.三角形最小路径和
#### LeetCode131.分割回文串（DP+DFS）
#### LeetCode132.分割回文串Ⅱ
#### LeetCode174.地下城游戏
#### LeetCode221.最大正方形（分类讨论）
#### LeetCode376.摆动序列
#### LeetCode509.斐波那契数
#### LeetCode514.自由之路
#### LeetCode1155.掷骰子的n种方法（骰子问题）
#### LeetCode1425.带限制的子序列和（动态规划+单调队列优化）
#### LeetCode1696.跳跃游戏VI（动态规划+单调队列优化）
#### 抢劫问题

#### LeetCode198.打家劫舍
#### LeetCode213.打家劫舍Ⅱ
#### 方格取数问题(矩阵双路径)

#### LeetCode741.摘樱桃
#### LeetCode1463.摘樱桃Ⅱ
####  股票问题

#### LeetCode121.买卖股票的最佳时机（贪心）
```java
class Solution {
    public int maxProfit(int[] prices) {
        int minn = prices[0];
        int ans = 0;
         for(int i = 1; i < prices.length; i++){
             minn = Math.min(minn,prices[i]);
            ans = Math.max(ans,prices[i]-minn);
         }
         return ans;
    }
}
```
#### LeetCode122.买卖股票的最佳时机Ⅱ（贪心）
如果第一天小于第二天那么直接求差值，否则说明第二天更适合后面取值

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minn = (int)1e5;
        int ans = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > minn){
                 ans += prices[i] - minn;    
            }  
            minn = prices[i];
            
        }
        return ans;
    }
}
```
#### LeetCode123.买卖股票的最佳时机Ⅲ（前后缀分解也能做）
> 求两次买卖股票的最佳时机。不能没卖就买。而且是最多买卖两次，也就是说我们可以买卖一次。但是要保证收益是最大的。
状态表示：f[i]表示[0,i]天内买卖一次的最大收益值。g[i]表示[i, n - 1]天内买卖一次的最大收益值。
状态方程： res = max(res , f[i] + g[i]);
对于两次的买卖，我们可以枚举第二次买的时候。
我们用f[i]表示前i天买卖一次的收益最大值，用g[i]表示第i天后买卖一次的收益最大值，最后枚举每天，前面买卖一次和后面买卖一次和的最大值即可。
时间复杂度O(N)，空间复杂度O(N)
```java
class Solution {
    public int maxProfit(int[] prices) {
       
        int n = prices.length; 
        if(n == 0){
            return 0;
        }
        int[]pre = new int[n];
        int[] suf = new int[n];
        
        for(int i = 1,low = prices[0]; i < n; i++){
            pre[i] = Math.max(pre[i-1],prices[i]-low);
            low = Math.min(low,prices[i]);
        }
        for(int i = n-2,high = prices[n-1]; i >= 0; i--){
            suf[i] = Math.max(suf[i+1],high - prices[i]);
            high = Math.max(high,prices[i]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,pre[i]+suf[i]);
        }
        return ans;
    }
}
```
#### LeetCode188.买卖股票的最佳时机Ⅳ
#### LeetCode309.最佳买卖股票时机含冷冻期（状态机）
#### LeetCode714.买卖股票的最佳时机含手续费（状态机）
#### 表达式匹配

#### LeetCode10.正则表达式匹配
#### LeetCode44.通配符匹配
## 1.4 区间DP
#### LeetCode312.戳气球
#### LeetCode375.猜数字大小Ⅱ（极小化极大，区间DP）
#### LeetCode486.预测赢家（极小化极大，区间DP）
#### LeetCode516.最长回文子序列
#### LeetCode730.统计不同回文子序列（区间DP + 双端队列）
#### LeetCode877.石子游戏（博弈论，区间DP，数学，486题的特例）
#### LeetCode1690.石子游戏Ⅶ（博弈论，区间DP）
## 1.5 树形DP
#### LeetCode337.打家劫舍Ⅲ
## 1.6 记忆化搜索
#### LeetCode135.分发糖果
#### LeetCode329.矩阵中的最长递增路径
#### LeetCode464.我能赢吗(状压DP+记忆化搜索)
#### LeetCode913.猫和老鼠（存在平局的博弈论，记忆化搜索）
#### LeetCode1728.猫和老鼠 II（博弈论，记忆化搜索）
## 1.7 状态机DP
#### LeetCode309.最佳买卖股票时机含冷冻期（状态机）
#### LeetCode552.学生出勤记录2
#### LeetCode714.买卖股票的最佳时机含手续费（状态机）
## 1.8 状压DP
#### LeetCode464.我能赢吗(状压DP+记忆化搜索)
#### LeetCode1681.最小不兼容性（枚举子集）

## 背包杂题
##### ACW4078. 01串
```c++
//状态表示: dp[i]表示以第i个字符结尾的优秀子串的集合 属性：数量
// 状态计算： dp[i][j] = (以0结尾)dp[i-1][0] + （以1结尾）dp[i-k][1]
#include<bits/stdc++.h>
using namespace std;


const int N = 100010,MOD = 1e9+7;
int t,k;
int dp[N];

void solve()
{
    dp[0] = 1;
    for(int i = 1; i <= N; i++){
        dp[i] = dp[i-1];
        if(i-k>=0){
            dp[i] = (dp[i]+dp[i-k])%MOD;
         }
    }
    for(int i = 1; i <= N; i++){
        dp[i] = (dp[i]+dp[i-1])%MOD;
    }
    
    
}
int main()
{
    cin >> t >> k;
    int l,r;
    solve();
    while(t--){
        cin >> l >>r;
        cout << (dp[r] - dp[l-1]+MOD)%MOD <<endl;
    }
    return 0;
}
```
##### ACW1884. COW
```java
二维到一维
状态表示：dp[i][0]表示以第i个数结尾的C出现的序列
dp[i][1]表示以第i个数结尾的O出现的序列
如果字符为'C',dp[i][0]+=1;
如果为'O',dp[i][1] += dp[i][0];
否则res+=dp[i][1]
import java.util.*;
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[][]dp = new int[n+1][2];
        long ans = 0;
        for(int i = 1;i <= n; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            if(s.charAt(i-1) =='C'){
                dp[i][0] += 1;
            }else if(s.charAt(i-1) =='O'){
                dp[i][1] += dp[i][0];
            }else{
                ans += dp[i][1];
            }

        }
        System.out.println(ans);


    }
}


import java.util.*;
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        long a = 0,b = 0,res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'C'){
                a++;
            }
            if(s.charAt(i) == 'O'){
                b+=a;
            }
            if(s.charAt(i) == 'W'){
                res+=b;
            }
        }
        System.out.println(res);

    }
}

```

