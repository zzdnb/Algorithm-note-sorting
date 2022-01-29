---
title: 值域二分
date: 2021-12-14 17:36:43.615
updated: 2022-01-18 08:35:14.306
url: /archives/zhi-yu-er-fen
categories: 算法
tags: 值域二分 | 环的入口 | 抽屉原理
---

[TOC](这里写目录标题)
## LeetCode374.猜数字大小

```java
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long l = 1, r = n;
        while(l < r){
            long mid = (l+r) >>1;
            if(guess((int)mid) <= 0){
                r = mid;
            }else{
                l = mid +1;
            }
        }   
        return (int)r;
    
        

    }
}
```
## LeetCode69.x的平方根
**整数二分**
```java
class Solution {
    public int mySqrt(int x) {
        long l = 0, r = Integer.MAX_VALUE;
        while(l < r){
            long mid = (l + r + 1) >> 1;
            if(mid*mid <= x){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return (int)l;
    }
}

```
**实数二分**
```java
class Solution {
    public int mySqrt(int x){
        double l = 0,r = x;
        while(r-l > 1e-4){
            double mid = (l+r)/2;
            if(mid*mid>=x){
                r = mid;
            }else{
                l = mid;
            }
        }
        int ans = (int)l+1;
        if(ans*ans == x){
            return ans;
        }
        return(int)l;
    }
}


```
## LeetCode367.有效的完全平方数

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = Integer.MAX_VALUE;
        while(l < r){
            long mid = (l+r)>>1;
            if(mid*mid>=num){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(l*l==num){
            return true;
        }else{
            return false;
        }
    }
}

```
## LeetCode287.寻找重复数（鸽巢原理+二分）
```java
class Solution {
    public int findDuplicate(int[] nums) {
        int a = 0, b = 0;
        while(true){
            a = nums[a];
            b = nums[nums[b]];
            if(a == b){
                a = 0;
                while(a != b){
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
       
    }
}
```
```java
class Solution {
    public int findDuplicate(int[] nums) {
        //根据木桶原理,肯定有一边的数大于区间长度
        int l = 1, r = nums.length;
        while( l < r){
            int mid = (l+r)>>1;
            int s = 0;
            for(int x:nums){
                if(x >= l && x <= mid){
                    s += 1;
                }
            }
            //左边区间内的数大于区间长度，这个枚举
            if(s > mid-l+1){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
       
    }
}
```
## LeetCode378.有序矩阵中第K小的元素
## LeetCode410.分割数组的最大值
## LeetCode875.爱吃香蕉的珂珂
## LeetCode1011.在D天内送达包裹的能力
## LeetCode1482.制作m束花所需的最少天数
## LeetCode1552.两球之间的磁力
## LCP12.小张刷题计划