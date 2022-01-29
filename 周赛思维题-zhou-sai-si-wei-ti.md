---
title: 周赛思维题
date: 2022-01-01 23:35:41.526
updated: 2022-01-01 23:35:41.526
url: /archives/zhou-sai-si-wei-ti
categories: 算法
tags: 
---

请你构造一个 n×n 的整数矩阵。

要求，矩阵满足下列所有条件：

矩阵中的所有元素的取值范围为 [0,n−1]。
矩阵主对角线上的所有元素都为 0。主对角线是指从左上角到右下角这一斜线方向的对角线。
该矩阵是对称矩阵。对称矩阵是指以主对角线为对称轴，各元素对应相等的矩阵。
同一行上的所有元素两两不同。
同一列上的所有元素两两不同。
输入格式
一个整数 n。

输出格式
共 n 行，每行 n 个空格隔开的整数，表示整个矩阵。

如果方案不唯一，输出任意合理方案均可。

数据范围
前三个测试点满足 2≤n≤10。
所有测试点满足 2≤n≤1000，n 保证是偶数。

输入样例1：
2
输出样例1：
0 1
1 0
输入样例2：
4
输出样例2：
0 1 3 2
1 0 2 3
3 2 0 1
2 3 1 0

```c++
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;
const int N = 1010;
int n;
int p[N][N];
int main()
{
    cin >> n;
    for(int i = 0; i < n-1; i++){
        for(int j = 0; j < n-1; j++){
            p[i][j] = (i+j)%(n-1)+1;
        }
    }
    for(int i = 0; i < n; i++){
        
        p[i][n-1] = p[n-1][i] = p[i][i];
        
        p[i][i] = 0;
    }
    for(int i = 0; i < n; i++){
        for(int j = 0;j < n; j++){
            cout << p[i][j] <<" ";
        }
        cout << endl;
    }
    return 0;
}
```