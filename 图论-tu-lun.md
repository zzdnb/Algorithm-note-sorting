---
title: 图论
date: 2022-01-07 12:33:58.97
updated: 2022-01-22 22:30:17.579
url: /archives/tu-lun
categories: 算法
tags: 
---

[TOC]()
## 基础知识
### (1)树与图的深度优先遍历

树是一种特殊的图，树是一种无环连通图。

所以只需要了解图就行了，图分为有向图与无向图。

无向图是一种特殊的有向图。

有向图：a->b 邻接矩阵 g[a,b] 用来存储边的信息，如果有权重的话g[a,b]就是权重，否则的话存储的就是booelan值【表示有边或者无边】。

邻接表：每一个头节点后面都跟了一个单链表。

树和图的遍历一般分为深度优先遍历和广度优先遍历。

```java
数组建立邻接表
int h[N],e[N*2],ne[N*2],idx;
void add(int a,int b){
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}
// 需要标记数组st[N],  遍历节点的每个相邻的便
void dfs(int u) {
    st[u] = true; // 标记一下，记录为已经被搜索过了，下面进行搜索过程
    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (!st[j]) {
            dfs(j);
        }
    }
}
```

**数的重心**

```java
https://www.acwing.com/solution/content/13513/
import java.io.*;
import java.util.*;

class Main{
    //以有向图的格式存储无向图，所以每个节点至多对应2n-2条边
    static int N = 100010, M = N*2;
    //存储n个单链表所以会有n个头
    static int[] h = new int[N];
    //存储元素的值
    static int[] e = new int[M];
    //存储列表的next值
    static int[] ne = new int[M];
    //idx是单链表指针
    static int idx,n;
    static boolean[] st = new boolean[N];
    static int ans = N;
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //将头结点都指向-1
        Arrays.fill(h,-1);
        n = Integer.valueOf(read.readLine().trim());
        for(int i = 0; i < n-1; i++){
            //树是不存在环的，对于有n个节点的树，必定是n-1条边
            String[] s = read.readLine().split(" ");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
    //插入法，将b插到a后边
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    //以u为根的子树中点的数量，包括u节点
    static int dfs(int u){
        //标记访问过u节点
        st[u] = true;
        //res存储删掉某个节点后，最大的联通子图节点数
        //存储以u为根的数的节点数，包括u
        int sum = 1,res = 0;
        //访问u的每个子节点
        for(int i  = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            //因为每个节点的编号是不一样的，所以用编号为下标，来标记是否被访问过
            if(!st[j]){
                //u节点的单棵子树节点数，如图中的size值。
                int s = dfs(j);
                //记录最大联通子图的节点数
                res = Math.max(res,s);
                //
                sum += s;
            }
        }
	//计算入的这个联通块上的点
        res = Math.max(res,n - sum);
        ans = Math.min(ans,res);
        return sum;
    }
}
```



### (2)树与图的广度优先遍历

这些边的权重默认是1，与下面的算法不同。

```java
import java.util.*;

class Main{
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] d = new int[N];
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] st = new boolean[N];
    static int idx,n;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        System.out.println(bfs(1));
        
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static int bfs(int u){
        queue.offer(u);
        Arrays.fill(d,-1);
        d[1] = 0;
        
        while(queue.size()!=0){
            int t = queue.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(d[j] == -1){
                    queue.offer(j);
                    d[j] = d[t] + 1; 
                }
            }
           
        }
         return d[n];
    }
}
```

```java
import java.util.*;
class Main{
    static int n, m,idx, N = (int)1e5+10;
    static int[] h = new int[N], e = new int[N*2], ne = new int[N*2],d = new int[N];
    static boolean[] st = new boolean[N]; 
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < m ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        bfs();
    }
    static void bfs(){
        queue.offer(1);
        while(!queue.isEmpty()){
            int t = queue.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(!st[j]){
                    st[j] = true;
                    d[j] = d[t]+1;
                    queue.offer(j);
                }
            }
        }
        if(d[n] == 0){
           System.out.println(-1); 
        }else{
            System.out.println(d[n]); 
        }
        
    }
    //链式前向星
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
```



### (3) 拓扑排序

有向图才有拓扑序列，拓扑序列就是对于每条边的起点都在终点前边。

环一定不是拓扑图，拓扑图又叫有向无环图（DAG）。

入度为0代表着没有任何一点在我的前面，你只需要不断地挖墙角就可以了

![image-20210602101316321](https://s3.bmp.ovh/imgs/2022/01/49e3ea1f23f67f93.png)

```java
将入度为0的点加入到queue中，

while(!queue.isEmpty()){
	取出队头
    枚举t的所有出边t到j；
    删除t到j，d[j]--即j的入度--；
    if(d[j]==0){
        将j加入到队列中
    }
    
}


```

```java
//本题中每次将入度为0的点删除后，你会发现这就是答案，因为它之前已经没有点了，它后面的点都比它大。
import java.util.*;
class Main{
    static int N = 100010;
    //d是记录i节点的入度，ans记录的是答案
    static int[]h = new int[N],e = new int[N*2],ne = new int[N*2],d = new int[N],ans = new int[N];
    //队列
    static Queue<Integer> queue = new LinkedList<>();
    //从一开始记录答案
    static int n,m,idx,cnt = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //记得初始化
        Arrays.fill(h,-1);
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            //将b的入度添加1
            d[b]++;
        }
        if(bfs()){
            for(int i = 1; i <= n; i++){
                System.out.print(ans[i]+" ");
            }
            }else{
                 System.out.println(-1);
            }
        }
    
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static boolean bfs(){
        //将入度为0的点添加到队列中
        for(int i = 1; i <= n; i++){
            if(d[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            //记录答案
            ans[cnt] = t;
            cnt++;
            //找t到j的点，将j的入度减一，判断其是否为0，是0的添加到队列中，在下一回开始的时候会把它添加到答案中。
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j]==0){
                    queue.offer(j);
                }
            }
        }
        //最后如何答案出来的话，肯定为n，如果小于n说明有的点存在问题，不符合条件。
        return cnt >= n;
    }
}
```
DFS求拓扑图
```java
#include<iostream>
using namespace std;

const int N = 100010,M = 100010;

int n,m;
struct Node{
    int id;
    Node* next;
    Node(int _id):id(_id),next(NULL){}
}* head[N];
//加*代表地址，不加*代表变量
int st[N],q[N],top;
void add(int a,int b){
    auto p = new Node(b);
    p->next = head[a];
    head[a] = p;
}

bool dfs(int u){
    //0表示没有遍历过，1表示在递归当中，2表示遍历完了
    st[u] = 1;
    
     
    for(auto p = head[u]; p ; p = p->next){
         int j = p->id;
         if(!st[j]){
             //如果发现了环
             if(!dfs(j)){
                 return false;
             }
         }else if(st[j] == 1){
                 return false;
             }
    }
    q[top++] = u;
    st[u] = 2;
   
   return true;
    
}
bool topsort(){
    for(int i = 1; i <= n; i++){
        if(!st[i]&&!dfs(i)){
            return false;
        }
    }
    return true;
}
int main(){
    scanf("%d%d",&n,&m);
    while(m-- != 0){
        int a,b;
        scanf("%d%d",&a,&b);
        add(a,b); 
    }
    if(!topsort()){
        printf("-1");
    }else{
         for(int i = n-1; i >= 0; i--){
             printf("%d ",q[i]);
         }
    } 
    
   
    return 0;
}
```



### (4)Dijkstra

如果是稠密图（边数多）的话，建议使用朴素版的的迪杰斯特拉算法，稠密图用邻接矩阵来存。稀疏图用邻接表来存。

稀疏图的话可以使用堆优化版的迪杰斯特拉算法。

朴素化Dijkstra：

（1）初始化距离dist[1] = 0, dist[i] = 正无穷

（2）s是当前已确定最短距离的点。

for(int i = 0; i < n; i++){

​			t是不在s中的距离最近的点

​			将t加入到s中

​			用t更新到其他点的距离。

} 



朴素版的迪杰斯特拉算法：

```java
package Acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dijkstra算法
 */
public class Dijkstra {
    static int N = 510;
    static int[][] g =  new int[N][N];
    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //解决重边和自环
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j){
                    g[i][j] = 0;
                }else{
                    g[i][j] = 0x3f3f3f;
                }
            }

        }
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = Math.min(g[a][b],c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        //算法思路：
        初始化距离：一号节点的距离为0，其他节点的距离为正无穷
        循环n次，每一次都将集合s外距离最短的点x加入到s中，然后用x去更新x邻接点的距离。
        Arrays.fill(dist,0x3f3f3f);
        dist[1] = 0;
        for(int i = 0; i < n; i++){
            //表示还没有确定距离当前点最近的点（贪心思想）
            int t = -1;
            for(int j = 1; j <= n; j++){
                //如果当前点没有确定最短路并且
                if(!st[j]&&(t==-1||dist[t]>dist[j])){
                    t = j;
                }

            }
            st[t] = true;
            //用t更新其他点的距离
            for (int j = 1; j <= n; j++){
                dist[j] = Math.min(dist[j],dist[t]+g[t][j]);
            }

        }
        if (dist[n]==0x3f3f3f){
            return -1;
        }else{
            return dist[n];
        }
    }
}

```

堆优化版的迪杰斯特拉算法：
时间复杂度 O(mlogn)O(mlogn)
每次找到最小距离的点沿着边更新其他的点，若dist[j] > distance + w[i]，表示可以更新dist[j]，更新后再把j点和对应的距离放入小根堆中。由于点的个数是n，边的个数是m，在极限情况下（稠密图m=n(n−1)2m=n(n−1)2）最多可以更新m回，每一回最多可以更新nn个点（严格上是n - 1个点），有m回，因此最多可以把n2n2个点放入到小根堆中，因此每一次更新小根堆排序的情况是O(log(n2))O(log(n2))，一共最多m次更新，因此总的时间复杂度上限是O(mlog((n2)))=O(2mlogn)=O(mlogn)

```java
package Acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 堆优化版的Dijkstra算法
 */
public class Dijkstra2 {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int[] h = new int[N],w = new int[N],e = new int[N],ne = new int[N];
    static int idx;
    static int n,m;
    static void add(int a,int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        // 堆优化版的迪杰斯特拉算法是将 寻找不在s中的距离最短的点 这一步骤优化到nlongn 
        //1. 将一号点的距离置为0，其他点置为正无穷
        //2.将一号点放进去
        //3.不断循环，知道堆为空，每次执行操作将弹出堆顶（找到s外距离最短的点，并且标记最短路径已经确定），用该点去更新邻接点的距离，若更新成功就加入到堆中
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<int[]> queue = new <int[]>((o1,o2)->{
            return o1[0] - o2[0];
        });

        //将一号点放进去，距离是0，编号是1
        queue.offer(new int[]{0,1});
        while(!queue.isEmpty()){
            int[] t = queue.poll();
			//找到不在s中的点t
            int distance = t[0];
            int ver = t[1];
            if (st[ver]){
                continue;
            }
            st[ver] = true;
            //用这一点去到其他点的距离
            for(int i = h[ver]; i!=-1; i = ne[i]){
                int j = e[i];
                //这里的w[i]就是i到j的距离，上面用链式向前星存储过。
                if(dist[j] > distance + w[i]){
                    //更新距离
                    dist[j] =  distance + w[i];
                    //将新点的距离（到1的距离）和编号加入到队列中
                    queue.offer(new int[]{dist[j],j});
                }
            }
        }
        if(dist[n]!= 0x3f3f3f3f){
            return dist[n];
        }else{
            return -1;
        }
    }
}

```





### (5)Bellman-Ford算法



适用于最多经过k条边，并且可能存在负权回路。

a，b，w代表的是从a到b的边，权重为w。

`只需要两重循环，外层是遍历所有点，内层遍历所有点`

这个算法可以直接用结构体存就可以，不用链表存。

`如果图中存在负权回路的话，最短路径不一定存在。`



下面的外循环迭代k次，代表 经过 不超过k条边的 最短路径。

可用循环n次判断负环，若n个点有n+1条边，说明存在负环，这个值比较小，说明存在负数。



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N = 510;
    static int M = 100010;
    //总点数
    static int n ;
    //总边数
    static int m ;
    //最多经过k条边
    static int k ;
    //记录从1号点到n号的距离
    static int[] dist = new int[N];
    //结构体数组
    static Node[] list = new Node[M];
    static int INF = 0x3f3f3f;
    //备份数组
    static int[] backup = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        k = Integer.valueOf(s[2]);
        for(int i = 0; i < m; i++){
            String[] ss = reader.readLine().split(" ");
            int a = Integer.valueOf(ss[0]);
            int b = Integer.valueOf(ss[1]);
            int c = Integer.valueOf(ss[2]);
            list[i] = new Node(a,b,c);
        }
        bellman_ford();
    }
    static void bellman_ford(){
        Arrays.fill(dist,INF);
        dist[1] = 0;
        for(int i = 0; i < k; i++){
            //backup = Arrays.copyOf(dist,n+1);
            backup = dist.clone();
            for(int j = 0; j < m; j++){
                Node node = list[j];
                int a = node.a;
                int b = node.b;
                int c = node.c;
                dist[b] = Math.min(dist[b],backup[a]+c);

            }
        }
        //定义的正无穷是个数值，可能被更新。
        if(dist[n] > INF/2){
            System.out.println("impossible");
        }else{
            System.out.println(dist[n]);
        }
    }
}
class Node{
    int a,b,c;
    Node(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

```

迪杰斯特拉算法与Bellman_ford算法的区别与联系：https://www.acwing.com/solution/content/9306/



### (6)spfa算法

https://www.acwing.com/solution/content/9306/

要求不含负环,万能路算法



是对bellman_fold算法的简化，在第二个内循环中，它循环了m条边，更新每个点到起点的最小值，其实我们只需要把变小的值存到一个队列里面，然后用它去更新其他值即可。

比如 t变小了，就更新所有以t为起点的边即t的所有出边，比如 t --> b ,然后将b加入到队列中【此时要判断队列中有没有b，有的话就不更新了】              中心思想【我更新过谁，我就拿谁去更新别人】

```java

import java.util.*;

/**
 *spfa算法
 */
public class Spfa {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断这个点是否加入到队列中
    static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    static int idx;
    static int n, m;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }
        int t = spfa();
        if(t== -1){
            System.out.println("impossible");
        }else{
            System.out.println(t);
        }
    }

    static int spfa() {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        //表示当前点已经加入到队列中
        st[1] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }  if (dist[n] == 0x3f3f3f) {
            return -1;
        }else {
            return dist[n];
        }
    }
}
```

判断负环：

https://www.acwing.com/solution/content/6336/



```java
package Acwing;

import java.util.*;

/**
 * spfa判断负环
 */
public class Spfa2 {
    static int N = 2010;
    static int M = 10010;
    static int[] dist = new int[N];//从x点到各个点的距离
    static boolean[] st = new boolean[N];
    //cnt存储的是边数
    static int[] h = new int[N], w = new int[M], e = new int[M], ne = new int[M], cnt = new int[M];
    static int idx;
    static int n, m;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        if (spfa()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean spfa() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;

                    if (cnt[j] >= n) {
                        return true;
                    }
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }
        return false;
    }
}
```



力扣周赛题：

```java
  private static int MOD = (int)Math.pow(10, 9)+7;
  public int countRestrictedPaths(int n, int[][] edges) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.putIfAbsent(edge[0], new HashMap<>());
      map.putIfAbsent(edge[1], new HashMap<>());
      map.get(edge[0]).put(edge[1], edge[2]);
      map.get(edge[1]).put(edge[0], edge[2]);
    }
    int[] minDis = new int[n+1];
    Arrays.fill(minDis, Integer.MAX_VALUE);
    minDis[n] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{n, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        int currentId = current[0];
        int currentDis = current[1];
        Map<Integer, Integer> next = map.get(currentId);
        for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
          int nextId = entry.getKey();
          int currentToNext = entry.getValue();
          int nextDis = currentDis+currentToNext;
          if (nextDis < minDis[nextId]) {
            minDis[nextId] = nextDis;
            queue.add(new int[]{nextId, nextDis});
          }
        }
      }
    }
    int[] result = new int[n+1];
    result[n] = 1;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for (int i = 1; i < minDis.length; i++) {
      priorityQueue.add(new int[]{i, minDis[i]});
    }
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int currentId = current[0];
      int currentMinDis = minDis[currentId];
      Map<Integer, Integer> next = map.get(currentId);
      for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
        int nextId = entry.getKey();
        int nextMinDis = minDis[nextId];
        if (nextMinDis < currentMinDis) {
          result[currentId] += result[nextId];
          result[currentId] %= MOD;
        }
      }
    }
    return result[1];
  }


作者：MapleStore
链接：https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/solution/java-bfssuan-zui-duan-ju-chi-you-xian-du-m8au/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
![image-20210504131629554](https://s3.bmp.ovh/imgs/2022/01/fc49c18dfff0e7fa.png)
### (7)prim算法

![image-20210504155737160](https://s3.bmp.ovh/imgs/2022/01/27b9cc41e7d62983.png)

了解最小生成树：

最小树 ：不能形成环，n个顶点必有n-1条边。

朴素版prim算法：





https://www.acwing.com/solution/content/14120/

```java
import java.util.Arrays;
import java.util.Scanner;
//可以使用memset(array, 0x3f, sizeof(array))来为数组设初值为0x3f3f3f3f，因为这个数的每个字节都是0x3f。
public class Main {
    static int N = 510;
    static int n, m;
    static int[][] g = new int[N][N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 0x3f3f3f3f;
                }
            }
        }
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int t = prim();
        if (t == 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

    }

    static int prim() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if(dist[t]==0x3f3f3f3f) {
                return 0x3f3f3f3f;
            }
            //先累加再更新
            res += dist[t];
            //拿这个点去更新其他所有的点到集合的距离
            for (int j = 1; j <= n; j++) {
                System.out.println(dist[j]+" "+g[t][j]);
                dist[j] = Math.min(dist[j],g[t][j]);
                
            }

            st[t] = true;
        }
        return res;

    }
}

```

### (8)Kruskal算法

直接选择权值最小的边

![image-20210504141054387](https://s3.bmp.ovh/imgs/2022/01/8ef47e4214efd5bf.png)

```java
import java.util.ArrayList;

import java.util.Scanner;

public class Main{
    static int n, m;
    static int[] p = new int[200010];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            list.add(arr);
        }
        list.sort((o1,o2)->{
            return o1[2]-o2[2];
        });

//        for(int i = 0; i < m; i++){
//            System.out.println(Arrays.toString(list.get(i)));
//
//        }
        for(int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0, cnt = 0;
        for(int i = 0; i < m; i++){
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int w = list.get(i)[2];
            if(find(a)!=find(b)){
                p[find(a)] = p[find(b)];
                cnt ++;
                res += w;
            }
        }
        if (cnt == n-1){
            System.out.println(res);
        }else{
            System.out.println("impossible");
        }
    }
    static int find(int x){
        if(x!=p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

}

```

### (9）floyd算法

用邻接矩阵来存储所有的边，基于动态规划

这里的> INF/2，是这样一种情况在更新的时候，虽然求的是两个数最小值，但是

1到2的距离是1-2,3的距离初始化是+无穷，则在更新到3的距离过程中，则可能更新成-2 + +无穷.

```java


import java.util.Scanner;


public class Main {
    static int N = 210;
    static int n,m,k,INF = (int)1e9;
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j){
                    d[i][j] = 0;
                }else{
                    d[i][j] = INF;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            d[x][y] = Math.min(d[x][y],z);
        }
        floyd();
        while(k-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(d[a][b] > INF/2){
                System.out.println("impossible");
            }else{
                System.out.println(d[a][b]);
            }
        }
    }
    static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    //从
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
}

```



### (10)二分图

二分图：当且仅当图中不含奇数环，

![image-20210608084207186](https://s3.bmp.ovh/imgs/2022/01/c78f15949e7dda83.png)

https://www.acwing.com/solution/content/6347/

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int n;
    static int m;
    static int N = 100010;
    static int M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static int[] color = new int[N];//共1和2两种不同的颜色
    static boolean[] st = new boolean[N];
    public static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
    public static boolean dfs(int u,int c)
    {
        color[u] = c;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            //当前点没有染过颜色
            if(color[j] == 0)
            {	//染成另外一种颜色
                if(!dfs(j,3 - c)) return false;
            }
            //矛盾
            else if(color[j] == c) return false;//颜色重复
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while(m -- > 0)
        {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            add(a,b);
            add(b,a);
        }
        boolean flag = true;//标记是否染色成功
        for(int i = 1;i <= n;i++)
        {
            //若未染色
            if(color[i] == 0)
            {
                if(!dfs(i,1))
                {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
}

```

### (11)匈牙利算法

要了解匈牙利算法必须先理解下面的概念：

匹配：在图论中，一个「匹配」是一个边的集合，其中任意两条边都没有公共顶点。

最大匹配：一个图所有匹配中，所含匹配边数最多的匹配，称为这个图的最大匹配。

下面是一些补充概念：

完美匹配：如果一个图的某个匹配中，所有的顶点都是匹配点，那么它就是一个完美匹配。

交替路：从一个未匹配点出发，依次经过非匹配边、匹配边、非匹配边…形成的路径叫交替路。

增广路：从一个未匹配点出发，走交替路，如果途径另一个未匹配点（出发的点不算），则这条交替 路称为增广路（agumenting path）

```java
import java.util.*;
class Main{
    static int N = 510,M = 100010,n1,n2,m,idx;
    static int[] h = new int[M],ne = new int[M],e = new int[M];
    //用来存储女生匹配的男生
    static int[] match = new int[N];
    static boolean[]  st = new boolean[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h,-1);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        int cnt = 0;
        for(int i = 1; i <= n1; i++){
            //初始化女生都没有预定过，给自己增加信心
            Arrays.fill(st,false);
            if(find(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    //为男生添加女生联系方式
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static boolean find(int x){
        //在列表里找找女生
        for(int i = h[x]; i != -1; i = ne[i]){
            int j = e[i];
            if(!st[j]){//如果女孩还没有被预定
                st[j] = true;//预定成功
                if(match[j]==0||find(match[j])){//看女孩是否有男朋友或者她的男朋友可以出轨
                    match[j] = x;//直接横刀夺爱
                    return true;
                }
            }
        }
        return false;
    }
}
```
# 单源最短路的建图方式
## AcWing 1129. 热浪
## AcWing 1128. 信使
## AcWing 1127. 香甜的黄油
## AcWing 1126. 最小花费
## AcWing 920. 最优乘车
## AcWing 903. 昂贵的聘礼
# 单源最短路的综合应用
## AcWing 1135. 新年好
## AcWing 340. 通信线路
## AcWing 342. 道路与航线
## AcWing 341. 最优贸易
# 单源最短路的扩展应用
## AcWing 1137. 选择最佳线路
## AcWing 1131. 拯救大兵瑞恩
## AcWing 1134. 最短路计数
## AcWing 383. 观光
# Floyd算法
## AcWing 1125. 牛的旅行
## AcWing 343. 排序
## AcWing 344. 观光之旅
##AcWing 345. 牛站
# 最小生成树
## AcWing 1140. 最短网络
## AcWing 1141. 局域网
## AcWing 1142. 繁忙的都市
## AcWing 1143. 联络员
## AcWing 1144. 连接格点
# 最小生成树的扩展应用
## AcWing 1146. 新的开始
## AcWing 1145. 北极通讯网络
## AcWing 346. 走廊泼水节
## AcWing 1148. 秘密的牛奶运输
# 负环
## AcWing 904. 虫洞
## AcWing 361. 观光奶牛
## AcWing 1165. 单词环
# 差分约束
## AcWing 1169. 糖果
## AcWing 362. 区间
## AcWing 1170. 排队布局
## AcWing 393. 雇佣收银员
# 最近公共祖先
## AcWing 1172. 祖孙询问
## AcWing 1171. 距离
## AcWing 356. 次小生成树
## AcWing 352. 闇の連鎖
# 有向图的强连通分量
## AcWing 1174. 受欢迎的牛
## AcWing 367. 学校网络
## AcWing 1175. 最大半连通子图
## AcWing 368. 银河
# 无向图的双连通分量
## AcWing 395. 冗余路径
## AcWing 1183. 电力
## AcWing 396. 矿场搭建
# 二分图
## AcWing 257. 关押罪犯
## AcWing 372. 棋盘覆盖
## AcWing 376. 机器任务
## AcWing 378. 骑士放置
## AcWing 379. 捉迷藏
# 欧拉回路和欧拉路径
## AcWing 1123. 铲雪车
## AcWing 1184. 欧拉回路
## AcWing 1124. 骑马修栅栏
## AcWing 1185. 单词游戏
# 拓扑排序
## AcWing 1191. 家谱树
## AcWing 1192. 奖金
## AcWing 164. 可达性统计
## AcWing 456. 车站分级
# LeetCode练习题
## LeetCode200.岛屿数量（并查集+坐标变换）
## LeetCode207.课程表（拓扑排序）
## LeetCode210.课程表Ⅱ
## LeetCode310.最小高度树（BFS）
## LeetCode332.重新安排行程（欧拉路径）
## LeetCode399.除法求值（Floyd求最短路）
## LeetCode547.朋友圈（并查集模板题）
## LeetCode684.冗余连接（并查集）
## LeetCode743.网络延迟时间（最短路模板题，可用来练习最短路算法： Dijkstra/Bellman-ford/SPFA/Floyd）
## LeetCode785.判断二分图（染色法判定二分图）
## LeetCode797.所有可能的路径（建图+DFS）
## LeetCode990.等式方程的可满足性（并查集）
## LeetCode1584.连接所有点的最小费用（最小生成树）
## LeetCode1615.最大网络秩
## LeetCode1627.带阈值的图连通性（并查集+数论）
## LeetCode1631.最小体力消耗路径（并查集+坐标变换/DFS+二分）
## LeetCode1697.检查边长度的路径是否存在（离线算法+并查集）
## LeetCode2115. 从给定原材料中找到所有可以做出的菜（拓扑排序）

