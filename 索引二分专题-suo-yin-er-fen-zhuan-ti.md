---
title: 索引二分专题
date: 2021-12-14 13:44:14.711
updated: 2022-01-18 08:35:07.567
url: /archives/suo-yin-er-fen-zhuan-ti
categories: 算法
tags: 索引二分
---

[TOC](索引二分专题)
#  索引二分专题
> 二分满足的不是单调性，而是二段性。

维基百科中对二分法的解释：二分法（dichotomy）指的是将一个整体事物分割成两部分。也即是说，这两部分必须是互补事件，即所有事物必须属于双方中的一方，且互斥，即没有事物可以同时属于双方。

所以二分和单调性确实是没有绝对关系的。

二分就是把区间划分成两部分，我把这两部分分别记为left 和 right。满足left就一定不满足right，满足right就一定不满足left。

整数二分口诀：
最大值最小，先r后l l+1，mid那里不加1
最小值最大，先l后r r-1，mid那里要加1

个人是这么记忆的：
如果在else 后写的是r 就要减1，然后在上面的mid那里+1；如果在else后写的是l，就加1，上面的mid就不用加1。

**整数二分**
```java
//check(mid)是对mid处的数进行判断。
//若符合right，答案就在left。即binarySearch1
//若符合left，答案就在right。即binarySearch2

int binarySearch1(int l,int r){
    while(l < r){
        int mid = (l+r)>>1;      //mid那里不+1
        if(check(mid)) r = mid;         //先r
        else l = mid + 1;                //后l l+1
    }
    return l;                           //二分到最后一个，即l==r时，为所求
}

int binarySearch2(int l,int r){
    while(l < r){
        int mid = （l+r+1）>>1;  //mid那里要+1 
        if(check(mid)) l = mid;         //先l
        else r = mid - 1;               //后r  r-1    
    }
    return l;                           //二分到最后一个，即l==r时，为所求
}
```
**实数二分**
```java
double binarySearch3(double l,double r){
    double eps;//根据题目设置精度，一般是题目精度的1e-2倍
    while(r - l > eps){
        double mid = (r + l) / 2;
        if(check(mid)) l = mid;
        else r = mid;
    }
    return l;
}

```

## LeetCode33.搜索旋转排序数组
```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        //找到最后一个满足条件的数
        while(l < r){
            int mid = (l+r+1) >> 1;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        //判断是否在第一段
        if(target >= nums[0]){
            l = 0;
        }else{
            l = r+1;
            r = nums.length-1;
        }
        //找大于target的最小值
        while(l < r){
            int mid = (l+r) >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        System.out.println(l +" "+r);
        //最后特判r，不然一个数时 l = mid + 1
        if(nums[r] == target){
            return r;
        }else{
            return -1;
        }

    }
}
```
## LeetCode34. 在排序数组中查找元素的第一个和最后一个位置
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[]{-1,-1};
        if(nums.length == 0){
            return ans;
        }
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l  = mid +1;
            }
        }
        if(nums[l] == target){
            ans[0] = l;
        }
        l = 0;
        r = nums.length-1;
        while(l < r){
            int mid = (l+r+1) >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if(nums[r] == target){
            ans[1] = r;
        }
        return ans;
    }
}
```
## LeetCode35. 搜索插入位置
//注意边界问题，r = len（nums）
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int mid = (l+r) >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
```
## LeetCode搜索旋转排序数组 II
```java
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        //使重新具有二段性
        while(r>=0 && nums[r] ==nums[0]){
            r --;
        }
        if(r < 0){
            return nums[0] == target;
        }//找到最后一个满足条件的数
        while(l < r){
            int mid = (l+r+1) >> 1;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        //判断是否在第一段
        if(target >= nums[0]){
            l = 0;
        }else{
            l = r+1;
            r = nums.length-1;
        }
        //找大于target的最小值
         System.out.println(l +" "+r);
        while(l < r){
            int mid = (l+r) >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        System.out.println(l +" "+r);
        //最后特判r，不然一个数时 l = mid + 1
        if(nums[r] == target){
            return true;
        }else{
            return false;
        }
    }
}
```
## leetcode74. 搜索二维矩阵
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length*matrix.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = matrix[i/matrix[0].length][i%matrix[0].length];
        }
        int l = 0, r = n-1;
        while(l < r ){
            int mid = (l+r) >> 1;
            if(arr[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(arr[l] == target){
            return true;
        }else{
            return false;
        }
    }
}
```

## LeetCode153.寻找旋转排序数组中的最小值
## LeetCode154.寻找旋转排序数组中的最小值Ⅱ
## LeetCode162.寻找峰值
## LeetCode274.H指数（排序）
## LeetCode275.H指数Ⅱ
## LeetCode278.第一个错误的版本
## LeetCode436.寻找右区间
## LeetCode540.有序数组中的单一元素（trick：x^1的奇偶性）
## LeetCode704.二分查找（二分模板题）
## AcWing 1945. 奶牛棒球
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


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2314073/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
