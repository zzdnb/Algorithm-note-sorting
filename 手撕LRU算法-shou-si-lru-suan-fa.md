---
title: 手撕LRU算法
date: 2022-01-07 14:04:28.516
updated: 2022-01-07 14:04:28.516
url: /archives/shou-si-lru-suan-fa
categories: 算法
tags: 
---

@[TOC](手撕LRU算法)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607105103846.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjg4NTg3,size_16,color_FFFFFF,t_70)

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

提示：

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
最多调用 3 * 104 次 get 和 put
## 题目解析

>本题解析：
>在本题中，我们首先要知道LRU算法
LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。

最常见的实现是使用一个链表保存缓存数据，详细算法实现如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607104016188.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjg4NTg3,size_16,color_FFFFFF,t_70)

新数据插入到链表头部；
每当缓存命中（即缓存数据被访问），则将数据移到链表头部；
当链表满的时候，将链表尾部的数据丢弃。
【命中率】
当存在热点数据时，LRU的效率很好，但偶发性的、周期性的批量操作会导致LRU命中率急剧下降，缓存污染情况比较严重。
【复杂度】
实现简单。
【代价】
命中时需要遍历链表，找到命中的数据块索引，然后需要将数据移到头部。


## 具体实现
哈希表 + 双向链表



1、Node结构体代表的是双向链表的结点，有 key，val 值，以及方向值 left，right
2、用哈希表存在 key 和 val 的映射和什么时候使用过，即哈希表存的是 key 和 Node 的映射值
3、规定双向链表的越靠头的部分表示越最近使用，越靠尾的部分表示越早使用，若需要替换都拿尾部分进行替换
4、get(key) 函数：查询哈希表中是否存在 key 值，若不存在则返回 -1 ，否则返回该值，并且维护双向链表，将 key 对应的 Node 放在双向链表头部分，即进行删除当前结构体 并 在队头加入结构体的操作
5、put(key,value) 函数：
1、若哈希表中存在 key 值，则对 key 的映射值进行修改，并把 key 对应的 Node 放在双向链表头部分，即进行删除当前结构体 并 在队头加入结构体的操作
2、若哈希表中不存在 key 值，若双向链表存的个数已经达到n（给定的个数），则将最尾部的 Node 删除，在队头添加新的结构体，若双向链表存的个数已经达不到n（给定的个数），则在队头添加新的结构体。
```java
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1436 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    static Node head,tail;
    static HashMap<Integer,Node> map = new HashMap<>();
    static int n;
    public LRUCache(int capacity) {
        n = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.right = tail;
        tail.left = head;
        map.clear();
    }
    static void insert(Node p){
        p.right = head.right;
        p.left = head;
        p.right.left = p;
        head.right = p;
    }
    static void remove(Node p){
        p.right.left = p.left;
        p.left.right = p.right;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        int val = node.val;
        remove(node);
        insert(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node p = map.get(key);
            p.val = value;
            remove(p);
            insert(p);
        }else{
            if(map.size()==n){
                Node p = tail.left;
                remove(p);
                map.remove(p.key);
            }
            Node t = new Node(key,value);
            insert(t);
            map.put(key,t);
        }
    }
}
class Node{
    int key,val;
    Node left,right;
    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

```


## 分享手写双向链表
e[N]表示这个点是谁

l[N]表示这个点右边的点是谁

r[N]表示这个点右边的点是谁

```java
/*
注意点：
    1.往最后端点插入时，可以用l[1],即最后一个位置的左节点来确定
    2.同样，往一个点左边插入时，需要的也是l[k]
    3.初始化操作：r[0]=1; l[1]=0; idx=2; head和tail分别为下标0和1
    4.      int t=0;
            while(r[t]!=1){t=r[t];}
            add(t,x);
            //这种方式取尾节点的时间最差为1e9，时间会爆掉=100000^2
*/
import java.util.*;
class Main{
    private static int N=100010;
    //private static int head;
    private static int idx=0;
    private static int[] e=new int[N];
    private static int[] l=new int[N];
    private static int[] r=new int[N];
    public static void init(){
        r[0]=1;
        l[1]=0;
        idx=2;
    }
    //在idx为k后加入一个节点
    public static void add(int k,int x){
        e[idx]=x;
        r[idx]=r[k];
        //l[idx] = l[r[k]];
        l[idx]=k;
        l[r[k]]=idx;
        r[k]=idx++;  //这步要最后做
    }
    //删除idx为k的节点
    public static void remove(int k){
        l[r[k]]=l[k];
        r[l[k]]=r[k];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        init();
        while(n-->0){
            String c=sc.next();
			
            int k,x;
            
            //0和1相当于头和尾
            //往最左边插
            if(c.equals("L")){
                x=sc.nextInt();
                add(0,x);
             //往最右边插
            }else if(c.equals("R")){
                x=sc.nextInt();
                add(l[1],x);

                /*int t=0;
                while(r[t]!=1){t=r[t];}
                add(t,x);*/
            }else if(c.equals("D")){
                k=sc.nextInt();
                /因为0和1已经被占了，第一个添加的节点是从2开始的，所以第k个节点编号是k+1。
                remove(k+1);
                //指定值的左边插入
            }else if(c.equals("IL")){
                k=sc.nextInt();
                x=sc.nextInt();
                add(l[k+1],x);
                //指定值的右边插入
            }else if(c.equals("IR")){
                k=sc.nextInt();
                x=sc.nextInt();
                add(k+1,x);
            }
        }
        for(int i=0;r[i]!=1;i=r[i]) 
            System.out.print(e[r[i]]+" ");
    }
}

```