---
title: 闫氏DP分析法
date: 2022-01-07 14:12:38.32
updated: 2022-01-07 14:12:38.32
url: /archives/yan-shi-dp-fen-xi-fa
categories: 算法
tags: dp
---

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210213174423395.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjg4NTg3,size_16,color_FFFFFF,t_70)
dp问题的下标
1. 若状态转移方程中有f[i - 1]这种状态, 下标(状态转移那部分代码)尽量从1开始
2. 否则就最好从0开始

dp问题的时间复杂度
状态数量(n^几个约束维度) * 转移状态的时间复杂(状态转移代码的时间复杂度)

dp的集合划分依据 -> 寻找最后一个不同操作 eg. 加不加这个背包, 数字三角形最后一步是由左边还是右边走过来的呀(根据操作的不同来对集合进行划分)
使得划分之后的小集合可以递推求出当前集合, 且最小集合已知

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210213174447925.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjg4NTg3,size_16,color_FFFFFF,t_70)
