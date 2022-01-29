---
title: 搜索专题
date: 2022-01-07 12:28:42.411
updated: 2022-01-13 22:13:25.399
url: /archives/sousuo
categories: 算法
tags: dfs | bfs
---

[TOC]()
## (1)DFS介绍

- 优缺点

- 容易爆栈，如果树有1e4层，就爆了

- 空间和深度成正比，相对较小。

- 不能搜最短，最小。

  **思考方式&&代码模板**

  ```[
  dfs()//参数用来表示状态
  {
  	if(到达终点状态){
  		//根据题意添加
  		return;
  	}
  	if(越界或者不合法状态){
  		return;
  	}
  	if(特殊状态){
  		//剪枝
  		return;
  	}
  	for(扩展方式){
  		if(扩展方式所达到状态合法){
  		 	修改操作；//根据题意来参加
  		 	标记；
  		 	dfs();
  		 	(还原标记);
  		 	//是否还原标记根据题意
  		 	//如果加上（还原标记）就是回溯
  		}
  	}
  }
  ```

  

**全排列**

理解：

这里的dfs函数指的是什么？

第u行到第n行的path的路径

如何求出一整个路径？

 假设已经知道第u+1行到最后一行的所有path，其实综合12可知：path[u]与path[u+1]合并后，即为dfs的解。

为什么要进行回溯？

递归的外层是一个循环，如果不进行恢复现场，下层回溯到上层状态被改变，数据就会乱套，甚至死循环。

```java
import java.util.*;
class Main{
    static int[] arr = new int[10];
    static boolean[] flag = new boolean[10];
    static int n;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }
    static void dfs(int u){
        if(u==n){
            for(int i = 0; i < n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i <= n;i++){
            //如果当前没有走过的话，就开始走
            if(!flag[i]){
                arr[u] = i;
                //置为true后，就不再走了
                flag[i] = true;
                dfs(u+1);
                //遍历完成后，置为false
                flag[i] = false;
            }
        }
    }
}
```

**八皇后问题**：

```java
import java.util.*;
class Main{
    //记录正对角线
    static boolean[] dg = new boolean[20];
    //记录负对角线
    static boolean[] udg = new boolean[20];
    //记录列
    static boolean[] col = new boolean[10];
    //记录答案
    static char[][] arr = new char[10][10];
    static int n ;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //初始化为.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = '.';
            }
        }
        //从第0行开始遍历
        dfs(0);
    }
    static void dfs(int u){
        //如果遍历到最后一行就将答案输出	
        //ch[i]直接输出一行
        if(u==n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //u是行 i是列 u+i指的是截距，由于都是正整数所以不担心为0，然而如果是-u+i的话有可能是负数，u最大就是n-1，所以设为n即可。
        for(int i = 0; i < n; i++){
            if(!col[i]&&!dg[u+i]&&!udg[-u+i+n]){
                //变换记录答案
                arr[u][i] = 'Q';
                //做标记
                col[i] = dg[u+i] = udg[-u+i+n] = true;
                dfs(u+1);
                //返回原样 
                col[i] = dg[u+i] = udg[-u+i+n] = false;
                arr[u][i] = '.';
            }
        }
    }
}
```



## (2)BFS介绍



模板：

```java
while(queue.isEmpty()){
    queue.poll(队头);
    拓展所有部分
    if(x未遍历){
        queue.offer(x);
        d[x] = d[t] + 1;
    }
}
```



- 优缺点

- 空间是指数级别的大

- 不会有爆栈的风险

- 可以搜最短，最小

  一般情况下，我们是用队列来实现，先进先出，使用队列来保存未被检测的结点。结点按照宽度优先的次序被访问和进出队列。

**代码思路**

  1.先初始化队列q；
  2.从起点开始访问，并且改变他的状态为已经访问；
  3.如果他的队列非空，取出首个元素，将它弹出！
  4.如果u==目标状态，然后对所以与u邻近的点进入队列；
  5.标记它已经被访问！

**代码模板**

```java
import java.util.*;
class Main{
    static int n,m;
    static int[][] arr;
    static int[][] path;
    static Node[][]pre;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        pre = new Node[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        bfs();
    }
    static void bfs(){
        path = new int[n][m];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            for(int i = 0;i < 4; i++){
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && path[x][y]==0 ){
                    pre[x][y] = node;
                    arr[x][y] = 1; 
                    queue.add(new Node(x,y));
                    path[x][y] +=path[node.x][node.y]+1;
                }
            }
        }
        int x = n-1,y = m-1;
        while(x!=0||y!=0){
            System.out.println(x+" "+y);
            Node node = pre[x][y];
            x = node.x;
            y = node.y;
        }
        System.out.println(path[n-1][m-1]);
    }
}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
```

**ACW845**

```java
import java.util.*;
import java.io.*;
class Main{
    static void swap(char[] c,int a,int b){
        char s = c[a];
        c[a] = c[b];
        c[b] = s;
    }
    static int bfs(String start,String end){
        Queue<String> q = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        q.offer(start);
        map.put(start,0);
        int []dx = {0,1,0,-1};
        int []dy = {1,0,-1,0};
        while(!q.isEmpty()){
            String t = q.poll();
            if(t.equals(end)){
                return map.get(t);
            }
            int k = t.indexOf('x');
           //二维转为一维
            int x = k/3,y = k%3;
            for(int i = 0;i < 4;i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if(a>=0&&a<3&&b>=0&&b<3){
                    char []arr = t.toCharArray();
                    //一维转为二维
                     swap(arr,k,a*3+b);//交换值&变状态（因为前面是一维存储字符串，所以二维坐标转一维下标）
                    String s=new String(arr);//转成字符串，因为定义队列和map是用String的

                    if(map.get(s)==null){//如果这个状态没出现过就存储这个状态
                        q.offer(s);
                        map.put(s,map.get(t)+1);//变化前的次数值加一，因为是+1所以保证四个方向变化的值都是一样的；
                    }

                }
            }
        }
        return -1;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String q[]=sc.readLine().split(" ");
        String start="";//因为输入问题所以不能直接给一个字符串
        for(int i=0;i<q.length;i++){
            start+=q[i];
        }
        String end="12345678x";
        System.out.println(bfs(start,end));//从开始状态到结束状态要多少次交换
    }


}

作者：福尔摩DONG
链接：https://www.acwing.com/activity/content/code/content/798623/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 模型练习
### Flood Fill
### 最短路模型
### 多源BFS
### 最小步数模型
### 双端队列广搜
### 双向广搜
### A*
### DFS之连通性模型
### DFS之搜索顺序
### DFS之剪枝与优化
### 迭代加深
### 双向DFS
### IDA*

## DFS练习
### LeetCode17.电话号码的字母组合
### LeetCode22.括号生成
### LeetCode37.解数独
### LeetCode39.组合总和
### LeetCode40.组合总和Ⅱ
### LeetCode126.组合总和Ⅲ
### LeetCode46.全排列
### LeetCode47.全排列Ⅱ
### LeetCode51.N皇后
### LeetCode52.N皇后Ⅱ
### LeetCode77.组合
### LeetCode78.子集
### LeetCode90.子集Ⅱ
### LeetCode79.单词搜索
### LeetCode93.复原IP地址
### LeetCode130.被围绕的区域（Flood Fill）
### LeetCode133.克隆图
### LeetCode138.复制带随机指针的链表
### LeetCode301.删除无效的括号
### LeetCode386.字典序排数（模拟遍历Trie树）
### LeetCode417.太平洋大西洋水流问题（Flood Fill）
### LeetCode430.扁平化多级双向链表（可看成二叉树的层序遍历）
### LeetCode473.火柴拼正方形
### LeetCode784.字母大小写全排列
### LeetCode842.将数组拆分成斐波那契数列
## BFS练习
### LeetCode127.单词接龙
### LeetCode126.单词接龙Ⅱ（BFS+DFS）
### LeetCode433.最小基因变化
### LeetCode690.员工的重要性（BFS/DFS）

