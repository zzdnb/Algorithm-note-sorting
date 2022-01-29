---
title: 第k小个数和第k大个数，5种方法，速看！！！
date: 2022-01-07 14:02:43.204
updated: 2022-01-07 14:03:10.261
url: /archives/第k小个数和第k大个数5种方法速看
categories: 算法
tags: 
---

@[TOC](这里写目录标题)
# 1.第k小个数
地址：[链接地址](https://www.acwing.com/problem/content/description/788/)
## 1.1时间复杂度O(n)


### 1.1.1基于快排实现
将k值当做物理地址的值，比如第5个数其实就是数组4的位置，第2个数就是数组1的位置

每次只需要判断k在左区间还是右区间，一直递归查找k所在区间
最后只剩一个数时，只会有数组[k]一个数，返回数组[k]的值就是答案
```java

描述
将k值当做物理地址的值，比如第5个数其实就是数组4的位置，第2个数就是数组1的位置

每次只需要判断k在左区间还是右区间，一直递归查找k所在区间
最后只剩一个数时，只会有数组[k]一个数，返回数组[k]的值就是答案

import java.util.Scanner;

public class Main{
    static int N = 100010;
    static int[] A = new int[N];
    static int n, k;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) A[i] = sc.nextInt();

        System.out.println(quickSort(0, n-1, k-1));
    }

    public static int quickSort(int l, int r, int k){
        if(l >= r) return A[k];

        int x = A[l], i = l-1, j = r+1;
        while(i < j) {
            do i++; while(A[i] < x);
            do j--; while(A[j] > x);
            if(i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        if(k <= j) return quickSort(l, j, k);
        else return quickSort(j+1, r, k);
    }
}

```
## 1.2时间复杂度O(nlogn)
### 1.2.1快排后找到第k小的数
```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);
       
        System.out.print(arr[k-1]);
       
    }
    static void quickSort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int i = l-1;
        int j = r+1;
        int mid = arr[(l+r)/2];
        while(i<j){
            do{
                i++;
            }while(arr[i]<mid);
            do{
                j--;
            }while(arr[j]>mid);
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSort(arr,l,j);
        quickSort(arr,j+1,r);
    }
}
```
### 1.2.2 数组模拟堆来实现
```java
import java.util.*;
//把整个数组建成堆，每次输出堆顶即可
//因此只需要用到输出集合的最小值
//还有删除最小值，关键是实现down操作。
//求最小值是o1的时间复杂度，而求插入和删除的时间复杂度与树的高度有关因此是logn的
class Main{
    static int m,n,size;
    static int[] p = new int[100010];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <=n; i++){
            p[i] = sc.nextInt();
        }
        size = n;
        for(int i = n/2; i !=0;i--){
            down(i);
        }
        for(int i = 1; i <=m; i++){
            if(i == m){
                System.out.println(p[1]);
            }
            p[1] = p[size];
            size--; 
            down(1); 
        }
    }
    static void down(int u){
        int t = u;
        //如果子节点<当前节点的话就把下标位置赋给t
        if(u*2<=size&&p[u*2]<p[t]){
            t = u*2;
        }
        if(u*2+1<=size&&p[u*2+1]<p[t]){
            t = u*2+1;
        }
        if(u!=t){
            int temp = p[u];
            p[u] = p[t];
            p[t] = temp;
            down(t);
        }
    }
    
}
```
### 1.2.3使用系统自带的排序函数
```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
        
    }

}
````
### 1.2.4 使用库函数的堆实现
```java
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            queue.offer(x);
        }
        for(int i = 0; i < k-1; i++){
            queue.poll();
        }
        System.out.println(queue.peek());

    }
}
```

# 2.第k大个数
地址：[力扣](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/submissions/)
## 2.1 时间复杂度O(n)
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quick_sort(nums, 0, nums.length - 1, k - 1);
            
    }
    int quick_sort(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i ++ ; while (nums[i] > x);
            do j -- ; while (nums[j] < x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quick_sort(nums, l, j, k);
        else return quick_sort(nums, j + 1, r, k);
    }

    
}
```
### 2.1.1 基于快排实现
## 2.2 时间复杂度O(nlogn)
### 2.2.1 快排后找到第k小的数
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
     quick_sort(nums, 0, nums.length - 1);
      return nums[k-1];      
    }
    void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i ++ ; while (nums[i] > x);
            do j -- ; while (nums[j] < x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }
}
```
### 2.2.2 使用数组模拟堆来实现
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i-1];
        }
        int n = nums.length;
        int size = n;
        for(int i = n/2; i !=0;i--){
            down(i,arr,size);
        }
        for(int i = 1; i <= k; i++){
            if(i == k){
                return arr[1];
            }
            arr[1] = arr[size];
            size--; 
            down(1,arr,size);
        }
        return 0;
    }
    void down(int u,int[] arr,int size){
        int t = u;
        //如果子节点<当前节点的话就把下标位置赋给t
        if(u*2<=size&&arr[u*2]>arr[t]){
            t = u*2;
        }
        if(u*2+1<=size&&arr[u*2+1] > arr[t]){
            t = u*2+1;
        }
        if(u!=t){
            int temp = arr[u];
            arr[u] = arr[t];
            arr[t] = temp;
            down(t,arr,size);
        }
    }
    
}
```
### 2.2.3 使用系统自带的排序函数
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      for(int i = nums.length -1; i >= 0; i--){
          if(i == nums.length-k){
              return nums[i];
          }
      }
      return 0;
    }

    
}
```
### 2.2.4 使用库函数的堆来实现
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> {
            return o2-o1;
        }));
        for (int i = 0; i < nums.length; i++){
            
            queue.offer(nums[i]);
        }
        for(int i = 0; i < k-1; i++){
            queue.poll();
        }
        return queue.peek();
    }

    
}
```