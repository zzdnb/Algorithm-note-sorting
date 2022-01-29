---
title: 算法考研辅导课
date: 2021-12-14 17:43:39.749
updated: 2021-12-14 17:43:39.749
url: /archives/suan-fa-kao-yan-fu-dao-ke
categories: 算法
tags: 考研 | 算法 | 排序 | 拓扑排序
---

[TOC](这里写目录标题)

## 排序和进位制

### 3375. 成绩排序

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][2];
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
            arr[i][0] = i;
            arr[i][1]= sc.nextInt();
        }
        if(k == 1){
            Arrays.sort(arr,(o1,o2)->{
                return o1[1]-o2[1];
            });   
        }else{
            Arrays.sort(arr,(o1,o2)->{
                return o2[1]-o1[1];
            });   
            
        }
        for(int[] x: arr){
            System.out.print(s[x[0]]+" ");
            System.out.println(x[1]);
        }
        
        
        
    }
}
```

### 3376. 成绩排序2

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

            Arrays.sort(arr,(o1,o2)->{
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
               
            });   
      
        for(int[] x: arr){
            System.out.print(x[0]+" ");
            System.out.println(x[1]);
        }
        
        
        
    }
}
```

### 3373. 进制转换

```java
package Acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC3373_2 {
    static Deque<Integer> div(Queue<Integer> queue, int b){
        Deque<Integer> tmp = new LinkedList<>();
        int cnt = queue.size();
        int r = 0;
        while(cnt-- != 0){
            r = r * 10 + queue.poll();
            tmp.offer(r/b);
            r %=b;
        }
        while(tmp.size() != 0 && tmp.peek()==0){
            tmp.poll();
        }
        return tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String x = sc.next();

            Deque<Integer> queue = new LinkedList<>();
            for(char c: x.toCharArray()){
                queue.offer(c-'0');
            }

            StringBuilder res = new StringBuilder();
            if("0".equals(x)){
                res.append("0");
            }else{
                while(!queue.isEmpty()){
                    System.out.println(queue.peekLast());
                    res.append(queue.peekLast()%2);
                    queue =  div(queue,2);
                }
            }
            System.out.println(res.reverse());
        }
    }
}

import java.util.*;
import java.math.BigInteger;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            BigInteger b = sc.nextBigInteger();
            System.out.println(b.toString(2));
        }
    }
}
```

### 3374.进制转换2

```java
import java.util.*;
import java.math.BigInteger;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            BigInteger b = sc.nextBigInteger(m);
            System.out.println(b.toString(n));
        }
    }
}

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String s = sc.next();
        Deque<Integer> queue = new LinkedList<>();
        for(char c: s.toCharArray()){
            int x = 0;
            if(c>='A'){
                x = c-'A'+10;
            }else{
                x = c-'0';
            }
            queue.offer(x);
        }
        StringBuilder sb = new StringBuilder();
        if("0".equals(s)){
            sb.append("0");
        }else{
            while(!queue.isEmpty()){
                Deque<Integer> tmp = new LinkedList<>();
                int cnt = queue.size();
                int r = 0;
                for(int i = 0; i < cnt; i++){
                    int t = queue.poll();
                    //计算t的十进制
                    t += r * a;
                    //记录余数
                    r= t%b;
                    //记录除数
                    t = t/b;
                    tmp.offer(t);
                    
                }
                while(!tmp.isEmpty() && tmp.peek()== 0){
                    tmp.poll();
                }
                queue=tmp;
                if(r <10){
                    sb.append(r);
                }else{
                    sb.append((char)(r-10+'a'));
                }
            }
            System.out.println(sb.reverse());
            
        }
        
    }
}
```

## 链表和日期问题

### 66.两个链表的第一个公共节点

这个题有两种做法：

```java
链表相加：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1!=h2){
            h1 = h1!=null? h1.next:headB;
            h2 = h2!=null? h2.next:headA;
        }
        return h1;
    }
}
链表相减找后半段：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        int len1 = 0;
        int len2 = 0;
        while(h1 != null){
            len1++;
            h1 = h1.next;
        }
         while(h2 != null){
            len2++;
            h2 = h2.next;
        }
        if(len1 <= len2){
            for(int i = 0; i < len2 - len1; i++){
                headB = headB.next;
            }
        }else{
             for(int i = 0; i < len1 - len2; i++){
                headA = headA.next;
            }
        }

        while(headA!=null&&headB!=null){
            if(headA.val==headB.val){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }
}

作者：福尔摩DONG
链接：https://www.acwing.com/activity/content/code/content/1414690/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3756.筛选链表

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* filterList(ListNode* head) {
        bool st[10001] = {};
        ListNode *dummy = new ListNode(-1);
        ListNode *cur = dummy, *p = new ListNode(-1);
        while(head){
            int val = abs(head->val);
            if(!st[val]){
                cur->next = head;
                p = head;
                cur = cur->next;
                st[val] = true;
            }
            head = head->next;
            
        }
        p->next = NULL;
        return dummy->next;
        
    }
};
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode filterList(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy,h1 = new ListNode(-1);
        while(head!=null){
            int x = Math.abs(head.val);
            
            if(!set.contains(x)){
                
                cur.next = head;
                h1 = head;
                cur = cur.next;
                set.add(x);
            } 
            head = head.next;
        }
        h1.next = null;
        return dummy.next;
    }
}
```





### 3757.重排链表

```java
ListNode在 = 赋值的时候，传递的是地址。前半段要记得终止，就要是的a->next = null，而在遍历的时候使用的是指针。地址是全局的。相当于链表的最后一个肯定要指向空
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void rearrangedList(ListNode head) {
         //计算链表长度
        ListNode p = head;
        int len = 0;
        while(p!=null){
            len++;
            p = p.next;
        }
        int left = (len+1)/2;
        ListNode a = head;
        for(int i = 0; i < left-1; i++){
            a = a.next;
        }
        ListNode b = a.next;
        a.next = null;
        
        ListNode pre = null;
        while(b!=null){
            ListNode c = b.next;
            b.next = pre;
            pre = b;
            b = c;
        }
        
       
        while(pre!=null){
            ListNode ta = head.next, tb = pre.next;
            head.next = pre;
            pre.next = ta;
            head = ta;
            pre = tb;
        }
    }
}
```

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void rearrangedList(ListNode* head) {
        ListNode *h = head;
        int len = 0;
        while(h){
            len++;
            h = h->next;
        }
        int left = (len+1)/2;
        ListNode *l = head;
        for(int i = 0; i < left-1; i++){
            l = l->next;
        }
        ListNode *r = l->next;
        l->next = NULL;
        ListNode *pre = NULL;
        while(r){
            ListNode *ne = r ->next;
            r->next = pre;
            pre = r;
            r = ne;
        }
        while(pre){
            ListNode *l1 = head->next;
            ListNode *r1 = pre->next;
            head ->next =pre;
            pre->next = l1;
            head = l1;
            pre = r1;
        }
    }
};
```

### 3607 打印日期

一年中的天数为

1,3,5,7,8,10,12为31天，2月的话闰年为29天，平年为28天。

闰年的话分为普通闰年和世纪闰年，4年一闰，百年不闰或400年一闰。

这个比较恶心的是yyyy-mm-dd，

可以用prinf试试，卧槽，printf可以补前导0，绝了，以前不知道，一直特判，人傻了。。。

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr1 = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] arr2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();  
           
            if((x%4==0&&x%100!=0)||(x%400==0)){
              
                for(int i = 1; i <= 12; i++){
                    y = y - arr2[i-1];
                    if(y<=0){
                       System.out.printf("%04d-%02d-%02d\n",x,i,(y+arr2[i-1]));
                        break;
                    }
                }
            }else{
                for(int i = 1; i <= 12; i++){
                    y = y - arr1[i-1];
                    if(y<=0){
                       System.out.printf("%04d-%02d-%02d\n",x,i,(y+arr1[i-1]));
                        break;
                    }
                }
            }
        }
    }
}
```

### 

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr1 = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] arr2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();  
            String xx = String.valueOf(x);
                if(xx.length()<4){
                    for(int i = 0; i < 4-xx.length();i++){
                        xx = "0"+xx;
                    }
                }
            if((x%4==0&&x%100!=0)||(x%400==0)){
              
                for(int i = 1; i <= 12; i++){
                    y = y - arr2[i-1];
                    if(y<=0){
                        System.out.println(xx+"-"+(i<10?"0":"")+i+"-"+(arr2[i-1]+y<10?"0":"")+(arr2[i-1]+y));
                        break;
                    }
                }
            }else{
                for(int i = 1; i <= 12; i++){
                    y = y - arr1[i-1];
                    if(y<=0){
                        System.out.println(xx+"-"+(i<10?"0":"")+i+"-"+(arr1[i-1]+y<10?"0":"")+(arr1[i-1]+y));
                        break;
                    }
                }
            }
        }
    }
}
```

### 3573.日期累加

```java
import java.util.*;
class Main{
    //日期问题三板斧
    static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int is_leap(int year){
        if((year %4 == 0&& year %100 !=0)||(year % 400 == 0)){
            return 1;
        }
        return 0;
    }
    static int get_month(int y ,int m){
        if(m == 2){
                //获得月份天数
                return month[m]+is_leap(y);
        }
        return month[m];
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0){
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            int a = sc.nextInt();
            int sum = 0;
            //算总数从一年的开始开始算        
            for(int i = 1; i < m; i++){
                sum +=get_month(y,i);
            }
            
            sum+=d+a;
            //然后按年算
            while(sum > 365+is_leap(y)){
                sum -= 365+is_leap(y);
                y++;
            }
            m = 1;
            //按月算
            while(sum > get_month(y,m)){
                sum -=get_month(y,m);
                m++;
            }
            //最后剩下的就是天数
            System.out.printf("%04d-%02d-%02d\n",y,m,sum);
        }
    }
}
```

## 图的深度优先遍历

```c++
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
bool st[N];
void add(int a,int b){
    auto p = new Node(b);
    p->next = head[a];
    head[a] = p;
}

void dfs(int u){
    st[u] = true;
    printf("%d ",u);
    for(auto p = head[u]; p ; p = p->next){
         int j = p->id;
         if(!st[j]){
             dfs(j);
         }
    }
   
    
}
int main(){
    scanf("%d%d",&n,&m);
    while(m-- != 0){
        int a,b;
        scanf("%d%d",&a,&b);
        add(a,b); 
    }
    for(int i = 1; i <= n; i++){
        if(!st[i]){
            dfs(i);
        }
    }
    return 0;
}
```

## 图的广度优先遍历

```c++
#include<iostream>

#include <queue>

using namespace std;

const int N = 100010,M = 100010;

int n,m;
struct Node{
    int id;
    Node* next;
    Node(int _id):id(_id),next(NULL){}
}* head[N];
bool st[N];
void add(int a,int b){
    auto p = new Node(b);
    p->next = head[a];
    head[a] = p;
}

void bfs(int u){
    queue<int> q;
    q.push(u);
    st[u] = true;
    while(q.size()){
        auto t = q.front();
        q.pop();
        printf("%d ",t);
        for(auto p = head[t]; p ; p = p->next){
            int j = p->id;
            if(!st[j]){
                q.push(j);
                st[j] = true;
            }
        }
    }
    
}
int main(){
    scanf("%d%d",&n,&m);
    while(m-- != 0){
        int a,b;
        scanf("%d%d",&a,&b);
        add(a,b); 
    }
    for(int i = 1; i <= n; i++){
        if(!st[i]){
            bfs(i);
        }
    }
    return 0;
}

```

## 拓扑排序的宽搜写法

```c++
#include<iostream>

#include <queue>

using namespace std;

const int N = 100010,M = 100010;
int d[N],ans[N];
int n,m,cnt=1;
struct Node{
    int id;
    Node* next;
    Node(int _id):id(_id),next(NULL){}
}* head[N];
bool st[N];
void add(int a,int b){
    auto p = new Node(b);
    p->next = head[a];
    head[a] = p;
}

bool topsort(){
    queue<int> q;
    for(int i = 1; i <= n; i++){
        if(!d[i]){
            q.push(i);
            
        }
    }
    
    while(q.size()){
        auto t = q.front();
        ans[cnt++] = t;
        q.pop();
        for(auto p = head[t]; p ; p = p->next){
            int j = p->id;
            if(! --d[j]){
                q.push(j);
            }
        }
    }
    return cnt >= n;
    
}
int main(){
    scanf("%d%d",&n,&m);
    while(m-- != 0){
        int a,b;
        scanf("%d%d",&a,&b);
        add(a,b);
        d[b]++;
    }

    if(topsort()){
        for(int i = 1; i <= n; i++){
            printf("%d ",ans[i]);
        }
    }else{
        printf("-1");
    }
    
    return 0;
}

```

 ## 拓扑排序的深搜写法

```c++
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

## 关键路径：

AOE网：带权的AOV（有向无环图）

关键路径不能用dijkstra来求，其实它是一种贪心的思想，不能用来计算最长路径。

### 汉诺塔

## 排序算法

### 插入排序

时间复杂度：

1.最好情况：O(n)

2.平均情况：O(n^n)

3.最坏情况：O(n^n)

辅助空间复杂度：

o(1)，只需要开一些临时变量

稳定



```c++
//插入排序：从右侧没有排序的区域中取数据，插入到左边排好序的位置上


void insert_sort(){
    for(int i = 1; i < n; i++){
        int t = p[i], j = i;
         //元素都大于t的话
        while(j && p[j-1] > t){
            //将前边的元素往后移动一位,找到该放的坑
            p[j] = p[j-1];
            j--;
        }
        p[j] = t;
    }
}
```

### 折半插入排序

时间复杂度：

1.最好情况：O(n)

2.平均情况：O(n^n)

3.最坏情况：O(n^n)

辅助空间复杂度：

o(1)，只需要开一些临时变量

稳定

```c++
void binary_search_insert_sort(){
    for(int i = 1; i < n; i++){
        int t = q[i];
        //如果前边的一个数小于这个数的话，就没必要
        if(q[i-1] <= t){
            continue;
        }
        int l = 0, r = i-1;
        while(l < r){
            int mid = l + r >> 1;
            if(q[mid] > t){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        
        for(int  j = i; j > r; j--){
            q[j] = q[j-1];
        }
        q[l] = t;
    }
}
```



### 冒泡排序

时间复杂度：

1.最好情况：O(n)

2.平均情况：O(n^n)

3.最坏情况：O(n^n)

辅助空间复杂度：

o(1)，只需要开一些临时变量

稳定

```c++

void bubble_sort(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n-i-1; j++){
            if(q[j] > q[j+1] ){
                swap(q[j],q[j+1]);
            }
        }
    }
}
```



### 简单选择排序

时间复杂度：

1.最好情况：O(n)

2.平均情况：O(n^n)

3.最坏情况：O(n^n)

辅助空间复杂度：

o(1)，只需要开一些临时变量

不稳定（2 2 1 相同元素的位置相对位置变了）

选择最小下标到dii个

```c++
void select_sort(){
    for(int i = 0; i < n; i++){\
        int k = i;
        for(int j = i+1; j < n; j++){
            if(p[j] < p[k]){
                k = j;
            }
        }
        swap(p[k],p[i]);
    }
}
```

### 希尔排序

1.最好情况：O(n)

2.平均情况：O(n^n)

3.最坏情况：O(n根号n)

辅助空间复杂度：o(1)，只需要开一些临时变量

不稳定（会分组）

分组，每组的下标是等差序列，组内用插入排序，插入排序对于部分有序的序列效果nice

以2的整次幂，以3为公差更好

```c++
void shell_sort(){
    //d为2的时候，直接为1
    for(int d = n/3; d; d = d ==2?1:d/3){
        for(int start = 0; start < d; start ++){
            for(int i = start+d; i < n; i = i+d){
                int t = p[i],j = i;
                while(j > start && p[j-d] > t){
                    p[j] = p[j-d];
                    j = j-d;
                }
                p[j] = t;
            }
        }
    }
}
```

### 快速排序

1.最好情况O（nlogn）

2.平均情况O(nlogn)

3.最坏情况O(n^n)

空间复杂度O（logn）

不稳定排序

```c++
void quick_sort(int l ,int r){
    if(l >= r){
        return;
    }
    int i = l - 1;
    int j = r + 1;
    int mid = p[(l+r)/2];
    while(i < j){
        do{
            i++;
        }while(p[i] < mid);
        do{
            j--;
        }while(p[j] > mid);
        if(i < j){
            swap(p[i],p[j]);
        }
    }
    //递归处理
    quick_sort(l,j);
    quick_sort(j+1,r);
    
}
```

### 堆排序

1.最好情况O（nlogn）

2.平均情况O(nlogn)

3.最坏情况O(nlogn)

空间复杂度O（logn）

不稳定排序

**大顶堆**：

![image-20210812233713537](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210812233713537.png)

```c++
#include<iostream>
#include<cstring>

using namespace std;
int p[(int)1e5+10];
int n,sz;

void down(int u){
    int t = u;
    
    if(u*2 <= sz && p[t] < p[u*2]){
        t = u*2;
    }
    if(u*2+1 <= sz && p[t] < p[u*2+1]){
        t = u*2+1;
    }
    
    if(t != u){
        swap(p[t],p[u]);
        down(t);
    }
    
}
void heap_sort(){
    for(int i = n/2; i > 0;i--){
        down(i);
        
        
    }
    for(int i =0; i < n-1; i++){
        for(int j =1; j <= n; j++){
            printf("%d ",p[j]);
        }puts(" ");
        swap(p[1],p[sz]);
        sz--;
        down(1);
    }
    
}
int main(){
    
    scanf("%d", &n);
    sz = n;
    for(int i = 1; i <= n; i++){
        scanf("%d",&p[i]);
    }
    heap_sort();
    for(int i = 1; i <= n; i++){
        printf("%d ",p[i]);
    }
}

```

**小顶堆**

```c++
#include<iostream>
#include<cstring>

using namespace std;
int p[(int)1e5+10];
int n,sz;

void down(int u){
    int t = u;
    
    if(u*2 <= sz && p[t] > p[u*2]){
        t = u*2;
    }
    if(u*2+1 <= sz && p[t] > p[u*2+1]){
        t = u*2+1;
    }
    
    if(t != u){
        swap(p[t],p[u]);
        down(t);
    }
    
}
void heap_sort(){
    for(int i = n/2; i > 0;i--){
        down(i);
        
        
    }
    for(int i =0; i < n; i++){
        printf("%d ",p[1]);
        p[1] = p[sz];
        sz--;
        down(1);
    }
    
}
int main(){
    
    scanf("%d", &n);
    sz = n;
    for(int i = 1; i <= n; i++){
        scanf("%d",&p[i]);
    }
    heap_sort();
    // for(int i = 1; i <= n; i++){
    //     printf("%d ",p[i]);
    // }
}

```

### 归并排序

1.最好情况O（nlogn）

2.平均情况O(nlogn)

3.最坏情况O(nlogn)

空间复杂度O（n）

 稳定排序

```c++
void merge_sort(int l,int r){
    int tmp[n];
    if(l >= r){
        return;
    }
    int mid = (l+r) >> 1;
    merge_sort(l,mid);
    merge_sort(mid+1,r);
    int i = l, j = mid +1,k = 0;
    while(i <= mid && j <= r){
        if(p[i] < p[j]){
            tmp[k++] = p[i++];
        }else{
            tmp[k++] = p[j++];
        }
    }
    while(i <= mid){
        tmp[k++] = p[i++];
    }
    while(j <= r){
        tmp[k++] = p[j++];
    }
    for(i = l,j = 0; i <= r; i++,j++){
        p[i] = tmp[j];
    }
    
    
}
```

### 桶排序

设数组a0到ai, 数组元素的大小为1到m

那么ai取决于小于ai的元素数量和等于ai的元素数量

开m个桶，求小于ai的元素数量，直接前缀和求一下

复杂度o(n+m)

```c++
int q[N],w[N],s[N];
void bucket_sort(){
    //0 1 2 3 4
    //3 2 2 1 5
    
    //1 2 3 4 5
    //1 2 1 0 1
    //1 3 4 4 5
        
    //统计数量
    for(int i = 0; i < n; i++){
        s[q[i]]++;
    }
    //计算前缀和
    for(int i = 1; i < N; i++){
        s[i] += s[i-1];
    }
    //从后往前，不改变元素数量
    for(int i = n-1; i >= 0; i--){
        w[--s[q[i]]] = q[i];
    }
    //还原回原数组
    for(int i = 0; i < n; i++){
        q[i] = w[i];
    }
}
```



### 基数排序

```c++
void radix_sort(int d,int r){
    int radix = 1;//从个位开始
    for(int i = 1; i <= d; i++){
        //清空所有桶
        for(int j = 0; j < r; j++){
            s[j] = 0;
        }
        //统计
        for(int j = 0; j < n; j++){
            s[q[j]/radix%r]++; 
        }
        //处理前缀和
        for(int j = 1; j < r; j++){
            s[j] += s[j-1];
        }
        for(int j = n-1; j >= 0; j--){
            w[--s[q[j]/radix%r]] = q[j];
        }
        //复制回原数组
        for(int j = 0; j < n; j ++){
            q[j] =w[j];
        }
        radix *= r;
        
    }
}

```



### 单链表快速排序

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode * get_tail(ListNode *head){
        while(head->next){
            head = head->next;
        }
        return head;
    }
    ListNode* quickSortList(ListNode* head) {
          if(!head||!head->next){
            return head;
        }
        ListNode *left = new ListNode(-1), *mid = new ListNode(-1), * right = new ListNode(-1);
        ListNode * ltail = left, *mtail = mid, *rtail = right;
        auto val = head->val;
        for(auto p = head; p; p = p->next){
            if(p->val < val){
                ltail = ltail->next = p;
            }else if( p->val == val){
                mtail = mtail->next = p;
            }else{
                rtail = rtail->next = p;
            }
        }
        ltail->next = mtail->next = rtail->next = NULL;
        
        left->next = quickSortList(left->next);
        right->next = quickSortList(right->next);
        
        get_tail(left)->next = mid->next;
        get_tail(left)->next = right->next;
        return left->next;
    }
};
```

​	