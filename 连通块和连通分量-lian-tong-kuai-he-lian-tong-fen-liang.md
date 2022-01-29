---
title: 连通块和连通分量
date: 2022-01-07 13:17:51.721
updated: 2022-01-07 13:17:51.721
url: /archives/lian-tong-kuai-he-lian-tong-fen-liang
categories: 算法
tags: 
---

@[TOC](关于连通块的小技巧)
## 砍树
```c++
给定一棵包含 n个节点的树。
你的任务是从树中删除尽可能多的边，使得剩余图形的所有连通分量都具有偶数个节点。
输入格式
第一行包含整数 n。
接下来 n−1 行，每行包含两个整数 a,b，表示节点 a 和 b之间存在一条边。节点编号 1∼n。保证给出图形是一棵树。

输出格式
输出一个整数表示可以删除的最大可能边数。
如果无论如何都不可能使得剩余图形的所有连通分量都具有偶数个节点，则输出 −1。
数据范围
前六个测试点满足，1≤n≤10。
所有测试点满足，1≤n≤105，1≤a,b≤n。
输入样例1：
4
2 4
4 1
3 1
输出样例1：
1
输入样例2：
3
1 2
1 3
输出样例2：
-1
```
题目分析：
判断：如果是奇数的话就不可能直接输出-1，要切尽可能多的边使得偶数最大，则 我们可以在判断两边都是偶数的时候就去切一刀。
去判断子树的点的个数是否是偶数，如果是偶数的话，那么必然剩下也是偶数。
```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10, M = N * 2;
int h[N], e[M], ne[M], idx, n, sizes[N], ans;

void add(int x, int y){
    e[idx] = y, ne[idx] = h[x], h[x] = idx ++;
}

void dfs(int x, int fa){
    for(int i = h[x]; ~i; i = ne[i])
    {
        int y = e[i];
        if(fa == y) continue;
        dfs(y, x);
        sizes[x] += sizes[y];
    }
    if(!(sizes[x] & 1)) ++ ans;
}

int main()
{
    memset(h, -1, sizeof h);
    scanf("%d", &n);
    for(int i = 1; i < n; i ++)
    {
        int x, y;
        scanf("%d%d", &x, &y);
        add(x, y), add(y, x);
    }

    if(n & 1) puts("-1");
    else {
        for(int i = 1; i <= n; i ++) sizes[i] = 1;
        dfs(1, 0);
        printf("%d\n", ans - 1);
    }

    return 0;
}

作者：acw_zzd
链接：https://www.acwing.com/activity/content/code/content/1824702/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
```c++
#include<bits/stdc++.h>

using namespace std;
const int N = 1e5+10, M = 2e5+10;
int h[N],e[M],ne[M],idx;
int n;
int ans;
void add(int a,int b){
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}
int dfs(int u,int fa){
    int d= 1;
    for(int i = h[u]; ~i; i = ne[i]){
        int j = e[i];
        if(j == fa ){
            continue;
        }
        //记录点的个数
        int dis = dfs(j,u);
        
        if(!(dis & 1)){
            ans++;
        }
        //加在前面会多加一次就是全部的偶数会多加一次
        d = d+dis;
    }
    return d;
}

int main(){
    cin >> n;
    if(n & 1){
        puts("-1");
        return 0;
    }
    memset(h,-1,sizeof h);
    int a,b;
    while(--n){
        cin >> a >> b;
        add(a,b);
        add(b,a);
    }
    dfs(1,-1);
    cout << ans << endl;
    return 0;
}
```
## 树的重心
```c++
#include<iostream>
#include<cstring>
#include<cstdio>
#include<algorithm>
using namespace std;
const int N=100010,M=N*2;
int n;
int h[N],e[M],ne[M],idx;
int ans=N;
bool vis[N];
void add(int a,int b){ //建图，链式前向星
    e[idx]=b;ne[idx]=h[a];h[a]=idx++;
}
int dfs(int u){
    vis[u]=1; //标记走过
    int size=0,sum=0; //前者为存删除u点后，最大的连通子图节点数，后者为以u为根的节点数（用来求该点上面连通块的点数的）
    for(int i=h[u];i!=-1;i=ne[i]){  //深搜
        int j=e[i];           
        if(vis[j]) continue;  //如果走过，那就不用管
        int s=dfs(j);       //s为u点下面以j为结点的连通块的点数
        size=max(size,s); // 这是在求u点之下连通块的点数，来找一个最大值
        sum+=s;  
    }
    size=max(size,n-sum-1); //与u点上面连通块的点数，取个最大值
    ans=min(ans,size);  //这是求答案，根据题目，求删掉各个点后，最小的最大连通块点数
    return sum+1;
}
int main(){
    scanf("%d",&n);
    memset(h,-1,sizeof(h));
    for(int i=0;i<n-1;i++){
        int a,b;
        scanf("%d%d",&a,&b);
        add(a,b),add(b,a);
    }
    dfs(1);
    printf("%d\n",ans);
    return 0;
}


```