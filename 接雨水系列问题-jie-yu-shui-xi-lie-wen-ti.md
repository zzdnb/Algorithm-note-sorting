---
title: 接雨水系列问题
date: 2022-01-07 14:06:18.332
updated: 2022-01-07 14:06:18.332
url: /archives/jie-yu-shui-xi-lie-wen-ti
categories: 算法
tags: 
---

@[TOC](接雨水)


给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210402193648794.png)

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
## 朴素做法
> 将数组扫一遍，每次在里面找到该数左边最大的值和右边最大的值，判断是否能加雨水，能加雨水的话就将结果累加，扫一遍就好了。
时间复杂度为o（n*n）
空间复杂度为o(1)
```java
public static  int trap(int[] height) {
        //特判数组是否为空
        if(height==null||height.length==0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        //遍历数组
        for(int i = 0; i < n; i++){
            //找到该数左边最大的值
            int l = Integer.MIN_VALUE;
            for(int j = i-1; j >=0; j--){
                l = Math.max(l,height[j]);
            }
            //如果该数左边最大的值小于等于当前数，说明不能接雨水
            if(l<=height[i]){
                continue;
            }
            //找到该数右边最大的值
            int r = Integer.MIN_VALUE;
            for(int j = i+1; j < n; j++){
                r = Math.max(r,height[j]);
            }
            //如果该数左边最大的值小于等于当前数，说明不能接雨水
            if(r<=height[i]){
                continue;
            }
            //将结果累加
            res += Math.min(l,r)-height[i];
        }
        return res;
    }
```
## 解法二：预处理
> 优化二：上面每次要找每个数左边以及右边最大的值，直接预处理存储，使用额外的空间来换时间。
> 对数组扫一遍肯定需要o(n),时间复杂度为o(n),空间复杂度为o(n)，因为开了两个空间为n的数组用来存储。
```java

    public static  int trap2(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int n = height.length;
        int max = Integer.MIN_VALUE;
        //定义两个数组用来存储各个元素左边以及右边的最大值
        int[] l = new int[n];
        int[] r = new int[n];
        //由于第一个数的左边的最大值肯定是0，所以从第一个开始计算
        for(int i = 1; i < n; i++){
            max = Math.max(max,height[i-1]);
            l[i] = max;
        }
        max = Integer.MIN_VALUE;
        //由于最后一个数的右边的最大值肯定是0，所以直接置为0
        for(int i = n-2; i >= 0; i--){
            max = Math.max(max,height[i+1]);
            r[i] = max;
        }
        int res = 0;
        //这里进行特判一下：如果当前l，r里对应下标的最小值<=当前值的话，就不能接雨水，就直接置为0，否则算差值。
        for(int i = 1; i < n-1; i++){
            res += Math.min(l[i],r[i])<=height[i]?0:Math.min(l[i],r[i])-height[i];
        }
        return res;
    }
```

## 单调栈做法
```java
 public int trap(int[] height){ 
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
```

## 双指针做法
```java
    public int trap(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int area = 0;
        for(int x:height){
            area +=x;
        }
        int len = height.length;
        int l = 0, r = len-1,total = 0;
        int h = 1;
        while(l<=r){
            while(l<=r&&height[l]<h){
                l++;
            }
            while(l<=r&&height[r]<h){
                r--;
            }
            total +=(r-l+1);
            h++;
        }
        return total-area;
    }

```