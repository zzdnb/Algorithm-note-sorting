---
title: 算法考研辅导课
date: 2021-12-14 17:43:39.749
updated: 2021-12-14 17:43:39.749
url: /archives/suan-fa-kao-yan-fu-dao-ke
categories: 算法
tags: 考研 | 算法 | 排序 | 拓扑排序
---

[TOC](这里写目录标题)

## 第一讲 排序和进位制

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

###  3374.进制转换2

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

## 第二讲 链表和日期问题

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

## 第三讲 表达式求值

### 3302. 表达式求值

```java
import java.util.*;
class Main{
    static Stack<Character> op = new Stack<>();
    static Stack<Integer> num = new Stack<>();
    static HashMap<Character,Integer> map = new HashMap<>();

    public static void main(String[] args){
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int j =  i, x = 0;
                while(j < s.length()&&Character.isDigit(s.charAt(j))){
                    x = x*10+s.charAt(j)-'0';
                    j++;
                } 
                i = j-1;
                num.push(x);
            }else if('(' == c){
                op.push(c);
            }else if(')'== c){
                while(op.peek()!='('){
                    eval(num,op);
                }
                op.pop();
            }else {
                while(!op.isEmpty()&&op.peek()!='('&&map.get(op.peek())>=map.get(c)){
                    eval(num,op);
                }
                op.push(c);
            }

        }
            while(!op.isEmpty()){
                eval(num,op);
            }
            System.out.println(num.peek());

    }

    static void eval(Stack<Integer> num,Stack<Character> op){
        int a = num.pop();
        int b = num.pop();
        char c = op.pop();
        int res = 0;
        if('+' == c){
            res = a+b;
        }else if('-'== c){
            res = b-a;
        }else if('*'== c){
            res = a*b;
        }else if('/' == c){
            res = b/a;
        }
        num.push(res);
    }
}
中转后
import java.util.*;
class Main{
    static Stack<Character> op = new Stack<>();
    static HashMap<Character,Integer> map = new HashMap<>();

    public static void main(String[] args){
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int j =  i, x = 0;
                while(j < s.length()&&Character.isDigit(s.charAt(j))){
                    x = x*10+s.charAt(j)-'0';
                    j++;
                } 
                System.out.print(x+" ");
                i = j-1;

            }else if('(' == c){
                op.push(c);
            }else if(')'== c){
                while(op.peek()!='('){
                    eval(op);
                }
                op.pop();
            }else {
                while(!op.isEmpty()&&op.peek()!='('&&map.get(op.peek())>=map.get(c)){
                    eval(op);
                }   
                op.push(c);
            }

        }
            while(!op.isEmpty()){
                eval(op);
            }


    }

    static void eval(Stack<Character> op){

        char c = op.pop();
        System.out.print(c+" ");
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1451585/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第四讲 树的遍历

### 3766. 二叉树的带权路径长度

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depeth = 0;
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
                if(tmp.left==null&&tmp.right==null){
                    res += tmp.val*depeth;
                }
        
            }
            depeth++;
        }
        return res;
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1488277/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

### 18. 重建二叉树

```java
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i < n; i++){
            map.put(inorder[i],i);
        }
        //前序遍历是0到n-1，中序遍历是0到n-1
        return build(preorder,inorder,0,n-1,0,n-1);
    }
    //a   b
    //x k y
    TreeNode build(int[] preorder,int[] inorder,int a,int b,int x, int y){
        if(a>b){
            return null;
        }
        TreeNode root = new TreeNode(preorder[a]);
        //快速通过根节点找到在中序遍历中的位置
        int k = map.get(preorder[a]);
        root.left = build(preorder,inorder,a+1,k-x+a,x,k-1);
        root.right = build(preorder,inorder,k-x+a+1,b,k+1,y);
        return root;
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1515988/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第五讲 二叉搜索树与表达式树

###  3786. 二叉排序树

```c++
#include<iostream>
using namespace std;

const int INF = 1e8;
struct TreeNode{
    int val;
    TreeNode *left,*right;
    TreeNode (int _val): val(_val), left(NULL),right(NULL){}
}*root;

void insert(TreeNode* &root,int x){
    //如果为空就创建
    if(!root){
        root = new TreeNode(x);
        //如果出现过就直接return
    }else if(x == root->val){
        return;
        //如果小于就去左子树
    }else if(x < root->val){

        insert(root->left,x);
        //如果大于就去右子树
    }else if(x > root->val){
        insert(root->right,x);
    }
}
void remove(TreeNode* &root,int x){
    if(!root){
        return;
    }else if(x < root->val){
        remove(root->left,x);
    }else if(x > root->val){
        remove(root->right,x);
    }else if( x == root->val){
        if(!root->left && !root->right){
            root = NULL;
        }else if(!root->left){
            root = root->right;
        }else if(!root->right){
            root = root->left;
        }else{
            auto p = root->left;
            while(p->right){
                p = p->right;
            }
            root->val = p->val;
            remove(root->left,p->val);
        } 
    }

}
int get_pre(TreeNode* root, int x){
    if(!root){
        return -INF;
    }
    if(root->val >= x){
        return get_pre(root->left,x);
    }
    return max(root->val,get_pre(root->right,x));
}
int get_sub(TreeNode* root, int x){
    if(!root){
        return INF;
    }
    if(root->val <= x){
        return get_sub(root->right,x);
    }
      return min(root->val,get_sub(root->left,x));
}
int main(){
    int n;
    cin >> n;
    while(n-- ){
        int t,x;
        cin >> t >> x;
        if(t == 1){
            insert(root,x);
        }else if(t == 2){
            remove(root,x);
        }else if(t == 3){
            cout << get_pre(root,x) << endl;
        }else 
            cout << get_sub(root,x) <<endl;

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1555196/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3765. 表达式树

```c++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     string val；
 *     TreeNode *left;
 *     TreeNode *right;
 * };
 */
class Solution {

public: 
    string ans;
    void dfs(TreeNode* root){
        if(root == NULL){
            return;
        }
        if(!root->left && !root->right){
            ans += root->val;
        }else{
            ans += '(';
            dfs(root->left);
            ans +=root->val;
            dfs(root->right);
            ans += ')';
        }

    }
    string expressionTree(TreeNode* root) {

        dfs(root->left),ans += root->val,dfs(root->right);
        return ans;
    }
};

```

## 第六讲 Huffman树

### 148. 合并果子

```java
//哈夫曼编码，每次将两个最小的数取出，算总和，再丢进去，只剩最后一个的时候就是答案
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->{
            return o1-o2;
        });
        while(n-- != 0){
            int x = sc.nextInt();
            queue.offer(x);
        }
        int res = 0;
        while(queue.size() > 1){

            int x = queue.poll();

            int y = queue.poll();

            res += x+y; 
            queue.offer(x+y);
        }
        System.out.println(res);
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1560185/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 149. 荷马史诗

```java
import java.util.*;
class Node{
    long x;
    int y;
    Node(long x,int y){
        this.x = x;
        this.y = y;
    }
}
class Main{
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->{
        if(o1.x==o2.x){
            return o1.y-o2.y;
        }
        return o1.x < o2.x ?-1:1;
    });
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        while(n-- != 0){
            long w = sc.nextLong();
            //刚开始深度都是0
            queue.offer(new Node(w,0));

        } 
        while((queue.size()-1)%(k-1)!=0){
                queue.offer(new Node(0,0));
        }
        long res = 0;
        while(queue.size() > 1){
            long s = 0;
            int depth = 0;
            for(int i = 0; i < k; i++){
                Node node = queue.poll();
                s += node.x;
                depth = Math.max(depth,node.y);
            }
            res += s;
            queue.offer(new Node(s,depth+1));
        }
        System.out.println(res);
        //根节点的值
        System.out.println(queue.peek().y);


    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1560927/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第七讲 拓扑排序

###  848. 有向图的拓扑序列

```c++
dfs

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
BFS

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


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1566646/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第八讲 最小生成树、最短路

### 858. Prim算法求最小生成树

```java
朴素版prim算法
//可以使用memset(array, 0x3f, sizeof(array))来为数组设初值为0x3f3f3f3f，因为这个数的每个字节都是0x3f。

#include<iostream>
#include<cstring>
using namespace std;

const int N = 510,INF = 0x3f3f3f3f;
int dist[N],arr[N][N];
bool st[N];
int n,m;

int prim(){
    memset(dist,0x3f,sizeof dist);
    dist[1] = 0;
    int res = 0;
    for(int i = 1; i <= n; i++)
    {
        int t = -1;
        for(int j = 1; j <= n; j++)
        {
            if(!st[j]&&(t == -1 || dist[t] > dist[j]))
            {
                t = j;
            }
        }
        if(dist[t] == INF)
        {   
            return INF;
        }
        st[t] = true;
        res += dist[t];


        for(int j = 1; j <= n; j++)
        {
            dist[j] = min(dist[j],arr[t][j]);
        }
    }
    return res;
}

int main(){
    scanf("%d%d",&n,&m);
    memset(arr,0x3f,sizeof arr);

    while(m-- ){
        int a,b,c;
        scanf("%d%d%d",&a,&b,&c);
        arr[a][b]=arr[b][a] = min(arr[a][b],c);
    }
    int ans = prim();
    if(ans==INF){
        printf("impossible");
    }else{
        printf("%d\n",ans);
    }
    return 0;
}
kurskal算法
#include<iostream>
#include<algorithm>
using namespace std;

const int N = 510,M = 100010 ;
int n,m;
struct Edge{
    int a,b,c;
    bool operator< (const Edge& t) const{
        return c < t.c;
    }
}e[M];
int p[M];
int find(int x){
    while(p[x] != x){
        return find(p[x]);
    }
    return p[x];
}
int main(){
    cin >> n >> m;

    for(int i = 0; i < m; i++){
        scanf("%d%d%d",&e[i].a,&e[i].b,&e[i].c);
    }
    sort(e,e+m);
    for(int i = 1; i <= n; i++){
        p[i] = i;
    }
    int res = 0,cnt = n;
    for(int i = 0; i < m; i++){
        int a = e[i].a, b = e[i].b, c = e[i].c;
        if(find(a) != find(b)){
            res += c;
            cnt--;
            p[find(a)] = find(b);
        }
    }
    if(cnt > 1){
        puts("impossible");
    }else{
        printf("%d",res);
    }
    return 0;



}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1567785/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 849. Dijkstra求最短路 I

```java
#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
const int N = 510, M = 10010,INF = 0x3f3f3f3f;

int dist[N],g[N][N];
int n,m;
bool st[N];

int dijkstra(){
    memset(dist,0x3f,sizeof dist);
    dist[1] = 0;
    for(int i = 1; i <= n; i++){
        int t = -1;
        for(int j = 1; j <= n; j++){
            if(!st[j]&&(t == -1 || dist[t] > dist[j])){
                t = j;
            }
        }
        st[t] = true;
        for(int j = 1; j <= n;j++){
            dist[j] = min(dist[j],dist[t]+g[t][j]);
        }
    }
    return dist[n];
}
int main(){
    memset(g,0x3f,sizeof g);
    scanf("%d%d",&n,&m);
    int a,b,c;
    while(m--){
        scanf("%d%d%d",&a,&b,&c);
        g[a][b] = min(g[a][b],c);
    }
    dijkstra();
    if(dist[n]==INF){
        cout << -1 << endl;
    }else{
        cout << dist[n] << endl;
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1569245/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 854. Floyd求最短路

```java
#include<iostream>
#include<cstring>

using namespace std;

const int N = 210,INF = 0x3f3f3f3f;

int d[N][N];
int n,m,k;

int main(){
    scanf("%d%d%d",&n,&m,&k);
    memset(d,0x3f,sizeof d);
    for(int i = 1; i <= n; i++){
        d[i][i] = 0;
    }
    int a,b,c;
    while(m--){
        scanf("%d%d%d",&a,&b,&c);
        d[a][b] = min(d[a][b],c);
    }
    for(int k = 1; k <= n; k++){
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= n; j++){
                d[i][j] = min(d[i][j],d[i][k]+d[k][j]);
            }
        }
    }
    while(k--){
        scanf("%d%d",&a,&b);
        if(d[a][b] > INF/2){
            cout << "impossible" << endl;
        }else{
            cout << d[a][b] << endl;
        }
    }
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1569376/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第九讲 哈希表和KMP

### 840. 模拟散列表

```c++
开放寻址法- 线性探测法
#include<iostream>
#include<cstring>

using namespace std;

const int N = 2e5+10,null = 0x3f3f3f3f;
int p[N];


int find(int x){
    int index = (x%N+N)%N;
    while(p[index] != null&& p[index] != x){
        index = (index+1)%N;
    }
    return index;
}
int main(){
    int n;
    scanf("%d",&n);
    //int有四个字节，按字节初始化
    memset(p,0x3f,sizeof p);
    while(n--){
       char a[2];
       int b;
       scanf("%s%d",a,&b);
       if(*a =='I'){
           p[find(b)] = b;
       }else{
           if(p[find(b)] == null){
               puts("No");
           }else{
               puts("Yes");
           }
       }

    }
}
拉链法
#include<iostream>
#include<cstring>
using namespace std;

const int N = 200003;
int a[N],e[N],ne[N],h[N],idx,n;

void insert(int b){
    int a = (b%N+N)%N;
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}
bool find(int x){
    int u  = (x%N+N)%N;
    for(int i = h[u]; i != -1; i = ne[i]){
        if(e[i] == x){
            return true;
        }
    }
    return false;
}
int main(){
    // char *类型 。它是一个指针，这个指针指向一个字符串。

    // char [] 类型。它是一个数组，他代表了这堆内存空间。
   memset(h,-1, sizeof h);
   scanf("%d",&n);
   while(n--){
       char x[2];
       int y;
        scanf("%s%d",x,&y);
        if(*x == 'I'){
           insert(y);
       }else{
           if(find(y)){
               puts("Yes");
           }else{
               puts("No");
           }
       }
   }



}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1598423/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3820. 未出现过的最小正整数

```java
class Solution {
public:
    int findMissMin(vector<int>& nums) {
        int n = nums.size();
        vector<bool> st(n+1);
        for(int x : nums){
            if(x>=1 && x<= n){
                st[x] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            if(!st[i]){
                return i;
            }
        }
        return n+1;
    }
};

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1598439/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 831. KMP字符串

```c++
#include<iostream>
#include<cstring>

const int N = 1e5+10, M = 1e6+10;
char p[N],s[M];
int ne[N];
int n,m;

int main(){
    scanf("%d%s",&n,p+1);
    scanf("%d%s",&m,s+1);

    //计算next数组
    for(int i = 2, j = 0; i <= n; i++){
        while(j && p[i] != p[j+1]){
            j = ne[j];
        }
        if(p[i] == p[j+1]){
            j++;
        }
        ne[i] = j;
    }

    for(int i = 1, j = 0; i <= m; i++){
        while(j && s[i] != p[j+1]){
            j = ne[j];
        }
        if(s[i] == p[j+1]){
            j++;
        }
        if(j==n){
            printf("%d ",i-n);
        }
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1600923/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十讲 排序、多路归并和摩尔投票法

### 1603. 整数集合划分

```c++
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5+10;
LL p[N],arr[N],n;
int main()
{
    scanf("%d", &n);
    for (int i = 0; i < n; i ++ ){
        scanf("%d", &p[i]);

    } sort(p,p+n);

    for (int i = 0; i < n; i ++ ){
        arr[i+1] = arr[i] + p[i];

    } 
    LL x = n/2;

    printf("%ld %ld",n-x*2,arr[n]-arr[x]*2);
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1627591/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3874. 三元组的最小距离

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 100010;

typedef long long LL;

int a[N],b[N],c[N];
int i,j,k;
int l,m,n;
int main()
{   scanf("%d%d%d",&l,&m,&n);
    for(int i = 0; i < l; i++){
        scanf("%d",&a[i]);
    }
    for(int i = 0; i < m; i++){
        scanf("%d",&b[i]);
    }
    for(int i = 0; i < n; i++){
        scanf("%d",&c[i]);
    }
    LL res = 1e18;
    while(i < l && j < m&& k < n){
        res = min(res,(LL)abs(a[i]-b[j])+abs(a[i]-c[k])+abs(b[j]-c[k]));
        if(a[i] <= b[j] && a[i] <= c[k]){
            i++;
        }else if(b[j] <= a[i] && b[j] <= c[k]){
            j++;
        }else{
            k++;
        }
    }
    cout << res <<endl;
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1692393/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 52. 数组中出现次数超过一半的数字

```c++
摩尔投票法
这个题就是由于最后留下来的数肯定大于n/2，所以可以采用这样一种方式去计数
如果cnt == 0，就开始计数，把当前这个数放到集合里
否则 就再算 cnt++,否则不等于val，cnt –

class Solution {
public:
    int moreThanHalfNum_Solution(vector<int>& nums) {
        int cnt = 0,val;
        for(auto x: nums){
            if(!cnt){
                val = x;
                cnt++;
            }else if(x == val){
                cnt++;
            }else{
                cnt--;
            }
        }
        cnt = 0;
        for(auto x: nums){
            if(x == val){
                cnt++;
            }
        }
        if(cnt <=nums.size()/2){
            return -1;
        }
        return val;
    }

};

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1692863/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十一讲 DFS

### 3429. 全排列

```java
import java.util.*;
class Main{
    static char[] ch;
    static boolean[] st = new boolean[10];
    static char[] ans = new char[10];
    static int n ;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        n = s.length();
        ch= s.toCharArray();
        int[] arr = new int[s.length()];
        for(int i = 0;i < s.length(); i++){
            arr[i] = ch[i]-'a';
        }
        Arrays.sort(arr);
        for(int i = 0; i < s.length(); i++){
            ch[i] = (char)(arr[i]+'a');
        }
        dfs(0);
    }
    static void dfs(int u){
        if(u == n){
            for(int i = 0; i < n; i++){
                System.out.print(ans[i]);
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++){
            if(!st[i]){
                ans[u] = ch[i];
                st[i] = true;
                dfs(u+1);
                st[i] =false;
            }
        }
    }

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1430902/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3472. 八皇后

```java
import java.util.*;
class Main{
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] col = new boolean[20];
    static boolean[] du = new boolean[20];
    static boolean[] udu = new boolean[20];
    static int n;
    static char[] ans = new char[8];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        list.sort((o1,o2)->{
            return o1.compareTo(o2);
        });
        while(n-- != 0){
            int x = sc.nextInt();
            System.out.println(list.get(x-1));
        }
    }
    static void dfs(int u){
        if(u>=8){
            String x = new String(ans);
            list.add(x);
            return ;
        }
        for(int i = 0; i < 8; i++){
            if(!col[i]&&!du[u+i]&&!udu[-u+i+8]){
                ans[u] = (char)(i+1+'0');
                col[i] = du[u+i] = udu[-u+i+8] = true;
                dfs(u+1);
                col[i] = du[u+i] = udu[-u+i+8] = false;
            }
        }


    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1431148/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十二讲 模拟、递推、BFS

### 3379. 反序输出

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            System.out.println(new StringBuilder(s).reverse());
        }
    }
}
```

### 3390. 特殊乘法

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int res = 0;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                res += (s1.charAt(i)-'0')*(s2.charAt(j)-'0');
            }
        }
        System.out.println(res);
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1682223/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3397. 众数

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[][] ans = new int[m][10];

        for(int i = m-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                ans[i][arr[j]%10]++;
                arr[j] = arr[j]/10;
            }
        }
        for(int i = m-1 ; i >= 0; i--){
            int k = 0,tmp = 0;
            for(int j = 0; j < 10; j++){
                if(ans[i][j] > tmp){
                    tmp = ans[i][j];
                    k = j;
                }
            }
            System.out.println(k);
        }
    }
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1682355/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

###  3426. 糖果分享游戏

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int cnt = 0;

            while (true) {
                boolean flag = true;
                for (int i = 1; i < n; i++) {
                    if (arr[i] != arr[i - 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(cnt + " " + arr[0]);
                    break;
                }
                int[] tmp = new int[n];
                for (int i = 0; i < n; i++) {
                    tmp[(i + 1) % n] = arr[i % n] / 2;
                }

                for (int i = 0; i < n; i++) {
                    arr[i] = arr[i]/2+tmp[i];
                }

                for (int i = 0; i < n; i++) {
                    if (arr[i % n] % 2 != 0) {
                        arr[i % n]++;
                    }
                }

                cnt++;




            }  n = sc.nextInt();
        }
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1682362/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3392. 递推数列

```c++
#include<bits/stdc++.h>

using namespace std;

int a0,a1,p,q,k;
int main(){
    scanf("%d%d%d%d%d",&a0,&a1,&p,&q,&k);
    int ans = 0;
    for(int i = 0; i < k-1; i++){
        ans = (p*a1 + q*a0)%10000;
        a0 = a1;
        a1 = ans;
    }
    cout << ans << endl;
    return 0;
}
```

### 3433. 吃糖果

```java
#include<bits/stdc++.h>

using namespace std;

int a = 1,b = 1,n,c = 1;
int main(){
    scanf("%d",&n);

    for(int i = 0; i < n-1; i++){
        c = a+b;
        a = b;
        b = c;
    }
    cout << c << endl;
    return 0;
}
```

### 3385. 玛雅人的密码

```java
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(solve(s,n));
    }
    static int solve(String s,int n){
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        set.add(s);
        int cnt = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                String ss = queue.poll();
                for(int j = 0; j < n-1;j++){

                    char[] c = ss.toCharArray();
                    char tmp = 'a';
                    tmp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = tmp;
                    String sss = new String(c);

                    if(!set.contains(sss)){
                        set.add(sss);
                        queue.offer(sss);
                    }
                }

                for(int j = 0; j <= n - 4; j++){
                    if(ss.substring(j,j+4).equals("2012")){
                        return cnt;
                    }
                }
            }

            cnt++;


        }
        return -1;



    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1684653/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3402. 等差数列

```c++
#include <iostream>
#include <cstring>
#include <algorithm>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;

const int N = 1010;

int n, m, cnt;
int col[N], row[N], a[N][N];
bool stc[N], str[N];
PII res[N * N];
PII q[N << 1];
int hh = 0, tt = -1;

void fill_col(int j)
{
    int a0 = 0, a1 = 0;
    for (int i = 0; i < n; i ++ )
        if (a[i][j])
            if (!a0) a0 = i;
            else a1 = i;
    int d = (a[a1][j] - a[a0][j]) / (a1 - a0);
    for (int i = 0; i < n; i ++ )
        if (!a[i][j])
        {
            a[i][j] = a[a0][j] + (i - a0) * d;
            if ( ++ col[j] >= 2 && !stc[j]) q[ ++ tt] = {1, j}, stc[j] = true;
            if ( ++ row[i] >= 2 && !str[i]) q[ ++ tt] = {0, i}, str[i] = true;
            res[cnt ++ ] = {i, j};
        }
}
void fill_row(int i)
{
    int a0 = 0, a1 = 0;
    for (int j = 0; j < m; j ++ )
        if (a[i][j])
            if (!a0) a0 = j;
            else a1 = j;
    int d = (a[i][a1] - a[i][a0]) / (a1 - a0);
    for (int j = 0; j < m; j ++ )
        if (!a[i][j])
        {
            a[i][j] = a[i][a0] + (j - a0) * d;
            if ( ++ col[j] >= 2 && !stc[j]) q[ ++ tt] = {1, j}, stc[j] = true;
            if ( ++ row[i] >= 2 && !str[i]) q[ ++ tt] = {0, i}, str[i] = true;
            res[cnt ++ ] = {i, j};
        }
}
void bfs()
{
    for (int i = 0; i < n; i ++ )
        if (2 <= row[i] && row[i] < n)
            q[ ++ tt] = {0, i}, str[i] = true;
    for (int j = 0; j < m; j ++ )
        if (2 <= col[j] && col[j] < m)
            q[ ++ tt] = {1, j}, stc[j] = true;
    while (hh <= tt)
    {
        PII u = q[hh ++ ];
        if (u.x) fill_col(u.y);
        else fill_row(u.y);
    }

}
int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i ++ )
    {
        for (int j = 0; j < m; j ++ )
        {
            cin >> a[i][j];
            if (a[i][j]) col[j] ++ , row[i] ++ ;
        }
    }
    bfs();
    sort(res, res + cnt);
    for (int i = 0; i < cnt; i ++ )
        printf("%d %d %d\n", res[i].x + 1, res[i].y + 1, a[res[i].x][res[i].y]);
    return 0;
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1685204/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



## 第十三讲 字符串处理，递归，背包问题

 ###  3439. 首字母大写

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0,j = 0;
        while(i < s.length()){
            while(i < s.length() && s.charAt(i)!= ' '){
                i++;
            }

            for(int k = j; k < i; k++){
                if(k-j==0 &&s.charAt(j)>= 'a'&& s.charAt(j) <='z'){
                    System.out.print((char)(s.charAt(j)-32));
                    continue;
                }
                System.out.print(s.charAt(k));
            }
            while(i < s.length() && s.charAt(i)==' '){
                i++;
                System.out.print(" ");
            }
            j = i;
        }
    }

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1706623/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3406. 日志排序

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(sc.hasNext()){
            String s = sc.nextLine();
            list.add(s);

        }
        list.sort((o1,o2)->{
            String[] s1 = o1.split("\\s+");
            String[] s2 = o2.split("\\s+");
            String[] s3 = s1[3].split("\\.");
            String[] s4 = s2[3].split("\\.");
            int x = Integer.valueOf(s3[0]);
            int y = Integer.valueOf(s4[0]);
            if(x != y){
                return x-y;
            }else{
                if(s3[1].equals(s4[1])){
                    String s5 = s1[1]+s1[2];
                    String s6 = s2[1]+s2[2];
                    return s5.compareTo(s6);
                }else{
                    return s3[1].compareTo(s4[1]);
                }
            }
        });
        for(String x:list){
            System.out.println(x);
        }
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1706948/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3504. 字符串转换整数

```java
import java.util.*;
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Long x = 0L;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    x = x*10+s.charAt(i++)-'0';

                }
                flag = true;
            }
                if(flag){
                    if(x > Integer.MAX_VALUE){
                        System.out.println(-1);
                        return;
                    }
                    System.out.println(x);
                    return;
                }
            }

        System.out.println(-1);
    } 
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1707020/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3441. 重复者 

```c++
#include<bits/stdc++.h>
using namespace std;

int n;
vector<string> p;

vector<string> g(int k){
    if(k == 1){
        return p;
    }
    auto s = g(k-1);
    int m = s.size();
    vector<string> res(n*m);
    for(int i = 0; i < n*m; i++){
        res[i] = string(n*m,' ');
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(p[i][j] != ' '){
                for(int x = 0; x < m; x++){
                    for(int y = 0; y < m; y++){
                        res[i*m+x][j*m + y] = s[x][y];
                    }
                }
            }
        }
    }
    return res;
}
int main(){
    while(cin >> n, n){
        p.clear();
        getchar();//读掉回车
        for(int i = 0; i <n; i++){
            string line;
            getline(cin,line);
            p.push_back(line);
        }
        int k;
        cin >> k;
        auto res = g(k);
        for(auto &s: res){
            cout << s << endl;
        }
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1724135/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 2. 01背包问题

```java
#include<iostream>
using namespace std;

const int N = 1010;
int n,m;
int v[N],w[N];
int dp[N];
int main(){
    scanf("%d%d",&n,&m);
    for(int i = 1; i <= n; i++){
        scanf("%d%d",&v[i],&w[i]);
    }
    for(int i = 1; i <= n; i++){
        for(int j = m; j >= v[i]; j--){
            dp[j] = max(dp[j],dp[j-v[i]]+w[i]);
        }
    }
    printf("%d",dp[m]);
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1707056/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3445. 点菜问题

```c++
#include<iostream>
using namespace std;

const int N = 1010;
int n,m;
int v[N],w[N];
int dp[N];
int main(){
    scanf("%d%d",&m,&n);
    for(int i = 1; i <= n; i++){
        scanf("%d%d",&v[i],&w[i]);
    }
    for(int i = 1; i <= n; i++){
        for(int j = m; j >= v[i]; j--){
            dp[j] = max(dp[j],dp[j-v[i]]+w[i]);
        }
    }
    printf("%d",dp[m]);
    return 0;
}
#include<bits/stdc++.h>
using namespace std;

int n,m;
int dp[1010];

int main(){
    cin >> m >> n;

        for(int i = 1; i <= n; i++){
            int v,w;
            cin >> v >> w;
            for(int j = m; j >= v; j-- ){
                dp[j] = max(dp[j],dp[j-v]+w);
            }
        }

    cout << dp[m] << endl;
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1707150/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3442. 神奇的口袋

```c++
//dp[i][j] 从前i个物品中选择并且总体体积等于j的选法的集合
//属性：元素数量
//集合划分：选择第i个物品和不选择第i个物品的选法的总和
//初始化：dp[0] = 1，从前0个物品中选总体积为0的选法有1种
#include<bits/stdc++.h>
using namespace std;
int dp[50];
int n;
int main(){
    scanf("%d", &n);
    dp[0] = 1;
    while(n--){
        int v;
        cin >> v;
        for(int j = 40; j >= v; j--){
            dp[j] = dp[j]+dp[j-v];
        }
    }
    cout << dp[40] <<endl;
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1724211/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### 3382. 整数拆分

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 1000010, MOD = 1e9;
int n;
int f[N];
int main()
{   
    scanf("%d", &n);
    f[0] = 1;
    //枚举可以选的数，即v[i]
    //f[j] = f[j] + f[j-v[i]] 
    for(int i = 1; i <= n; i = i*2){
        for(int j = i; j <= n; j++){
            f[j] = (f[j]+f[j-i])%MOD;
        }
    }
    cout << f[n] << endl;
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1724326/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十四讲 高精度和因式分解

### 3389. N 的阶乘

```c++
优化前：
#include<bits/stdc++.h>
using namespace std;


vector<int> solve(vector<int> A,int x){
    vector<int> C;
    for(int i = 0,t = 0; i < A.size()||t; i++){
        if(i < A.size()){
            t += A[i] * x;
        }
        C.push_back(t%10);
        t /= 10;
    }
    return C;
}
int main(){
    int n;

    while(cin >> n){
        vector<int> A{1};
        for(int i = 1; i <= n; i++){
           A =  solve(A,i);
        }
        for(int i = A.size()-1; i >= 0; i--){
            printf("%d",A[i]);
        }
        cout << endl;
    }
}
#include<bits/stdc++.h>
using namespace std;

vector<int> F[1010];
vector<int> solve(vector<int> A,int x){
    vector<int> C;
    for(int i = 0,t = 0; i < A.size()||t; i++){
        if(i < A.size()){
            t += A[i] * x;
        }
        C.push_back(t%10);
        t /= 10;
    }
    return C;
}
int main(){
    int n;
    F[0] = {1};
    for(int i= 1; i <= 1000; i++){
        F[i] = solve(F[i-1],i);
    }
    while(cin >> n){
        for(int i = F[n].size()-1; i >= 0; i--){
            printf("%d",F[n][i]);
        }
        cout << endl;
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1737063/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3448. 基本算术

```java


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = "",s2 = "";
        while(sc.hasNext()){
            s1 = sc.next();
            s2 = sc.next();
            if(s1.equals( "0") && s2.equals("0")){
                break;
            }
            ArrayList<Character> l1 = new ArrayList<>();
            ArrayList<Character> l2 = new ArrayList<>();
            for(int i = s1.length()-1; i >= 0; i--){
                l1.add(s1.charAt(i));
            }
            for(int i = s2.length()-1; i >= 0; i--){
                l2.add(s2.charAt(i));
            }
            int t = 0,cnt = 0,i = 0;
            while(i < l1.size() || i < l2.size() || t!= 0){
                if(i < l1.size()){
                    t+=l1.get(i)-'0';
                }
                if(i < l2.size()){
                    t+=l2.get(i)-'0';
                }
                t = t/10;
                cnt += t;
                i++;
            }
            if(cnt == 0){
                System.out.println("No carry operation.");
            }else if (cnt == 1){
                System.out.println("1 carry operation.");
            }else{
                System.out.println(cnt+" carry operations.");
            }
        }
    }
}

```

### 3453. 整数查询

```c++
#include<bits/stdc++.h>
using namespace std;


vector<int> add(vector<int> &A, vector<int>&B){

    vector<int> c;
    for(int i = 0, t = 0; i < A.size() || i < B.size() || t; i++){
        if(i < A.size()){
            t += A[i];
        }
        if(i < B.size()){
            t += B[i];
        }
        c.push_back(t%10);
        t = t/10;
    }
    return c;

}
int main(){
    string a;
    vector<int> A{0};
    while(cin >> a, a!="0"){
        vector<int> B;
        for(int i = a.size()-1; i >= 0; i--){
            B.push_back(a[i]-'0');
        }
        A = add(A,B);
    }
    //去除前导零
    while(A.size() > 1 && !A.back()){
        A.pop_back();
    }
    for(int i = A.size()-1; i >= 0; i--){
        cout << A[i];
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1745756/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3380. 质因数的个数

```java
每个数最多只有一个大于根号n的质因子，所以枚举到根号n即可
#include<iostream>

using namespace std;

int n;
int main(){
    while(cin >> n){

        int cnt = 0;
        for(int i = 2; i<= n/i; i++){
            if(n%i == 0){
                while(n%i ==0){
                    cnt++;
                    n /= i;
                }
            }
        }

        if(n != 1){cnt++;}
        cout << cnt <<endl;

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1755907/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3377. 约数的个数

```c++
质因数个数+1 ，挨个相乘
#include<bits/stdc++.h>
using namespace std;

int n;
int main(){

    cin >> n;

    while(n--){
        int x;
        cin >> x;
        long long res = 1;
        for(int i = 2;i <= x/i; i++){
            if(x%i == 0){
                int cnt= 0;
                while(x%i == 0){
                    cnt++;
                    x /= i;
                }
                res *= cnt+1;
            }
        }
        if(x != 1){
            res *= 2;
        }
        cout << res <<endl;
    }
    return 0;
}

暴力求去除相同的和1即可
#include<bits/stdc++.h>

using namespace std;
int n;
int main(){
    cin >> n;
    while(n--){
        int x;
        cin >> x;
        int cnt = 0;
        for(int i = 1; i <= x/i; i++){
            if(x%i == 0){
                cnt++;
                if(x/i != 1 && x/i != i){
                    cnt++;
                }
            }
        }
        cout << cnt <<endl;
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1756020/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3507. 阶乘的末尾0

计算k在n的阶乘中出现多少次，k就是 除的次数

```c++
#include<bits/stdc++.h>

using namespace std;
int n;
//这道题就是算
// n/2 +n/(2*2) + n/(2*2*2)+...个数相加
// n/5 + n/(5*5)+... 个数相加 显然n/5个数少，就是因为2和5匹配10

int main(){
    cin >> n;
    int res = 0;
    while(n/5){
        res += n/5;
        n = n/5;
    }
    cout << res <<endl;
    return 0;
}
```

### 3484. 整除问题

```c++
//最多包含多少个a
//这里的
#include<bits/stdc++.h>
using namespace std;

int n,m;

vector<vector<int>> get_ds(int n){
    vector<vector<int>> res;
    for(int i = 2; i <= n/i; i++){
        if(n % i == 0){
            int s = 0;
            while(n % i == 0){
                s++;
                n /= i;
            }
            res.push_back({i,s});
        }
    }
    if(n != 1){
        res.push_back({n,1});

    }
    return res;
}
int get_p(int n, int m){
    int s = 0;
    while(n){
        s += n/m;
        n /= m;
    }
    return s;
}
int main(){
    scanf("%d%d",&n,&m);
    auto ds = get_ds(m);
    int res = 1e8;

    for(int i = 0; i < ds.size(); i++){
        //每个质因数和其个数
        int p = ds[i][0],s = ds[i][1];
        //计算 n！中有多少个p的倍数 最后除以需要的个数， 就是 最多能有的结果
        res = min(res,(get_p(n,p))/s);
    }
    cout << res <<endl;
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1761216/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十五讲 枚举和位运算

### 3434. 与7无关的数

```java
#include<bits/stdc++.h>
using namespace std;

int n;

int main()
{
    cin >> n;
    long long res = 0;
   for(int i = 1; i <= n; i++){
       if(i%10 == 7 || i/10 == 7|| i %7 == 0){
           continue;
       }
       res += i*i;

   }
   cout << res << endl;
   return 0;
}
```

### 3437. 打印极值点下标

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 105;
int a[N] ;
int main()
{
    int n;
    cin >> n;
    memset(a, 0, sizeof a);
    for(int i = 1; i <= n; i++){
        cin >> a[i];
    }
    if(a[1] != a[2]){
        cout << 0 << " ";
    }
    for(int i = 2; i < n; i++){
        if((a[i] > a[i+1] && a[i] > a[i-1] )|| (a[i] < a[i+1]&& a[i] < a[i-1])){
            cout << i-1 <<" ";
        }
    }
    if(a[n-1] != a[n]){
        cout << n-1 << " ";
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1761264/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3408. 最简真分数

```c++
#include<bits/stdc++.h>
using namespace std;

int n;
int a[610];
int cnt[610];
int gcd(int a,int b){
    return b?gcd(b,a%b):a;
}
int main(){


    while(cin >> n, n != 0){
        for(int i = 0; i < n; i++){
            cin >> a[i];
            cnt[i] = n-1;
        }
        sort(a,a+n);
        long long res = 0;


        for(int i = 0; i < n; i++){
            int j = i+1;
            while(j < n){
                if(gcd(a[i],a[j])!=1){
                    cnt[i]--;
                    cnt[j]--;
                }
                j++;
            }
            res += cnt[i];
        }
        cout << res/2 <<endl;

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1761523/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3444. 买房子

```c++
#include<bits/stdc++.h>
using namespace std;

int n,k;
int main(){


    while(cin >> n >> k){
        double s = (double)k/100;
        int cnt = 1;
        double w = 0;
        double house = 200;
        bool flag = false;

        while(cnt <= 21){

            w = (double)n*cnt;

            if(w >= house){
                flag = true;
                cout << cnt << endl;
                break;
            }
            house *= (1+s);
            cnt++;
        }

        if(!flag){

            cout << "Impossible" << endl;

        }
    }
    return 0;

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1761585/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```


### 3530. 二进制数

```c++
#include<bits/stdc++.h>
using namespace std;

int n;
long long get_x(int x){
    return x*x*x*x*x*x > 1e9? 1e9+10:x*x*x*x*x*x;
}
int main(){
    cin >> n;
    while(n--){
        int x;
        cin >> x;
        int cnt = 0;
        for(int i = 1; get_x(i) <= x; i++){
            cnt++;
        }

        cout <<cnt << endl;

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1761644/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3435. 位操作练习

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s1 = "";
            String s2 = "";
            for(int i = 0; i < 16; i ++){
                s1 = (n >> i & 1)+""+s1;
            }
            for(int i = 0; i < 16; i++){
                s2 = (m >> i & 1)+""+s2;

            }
            s1 +=s1;
            if(s1.contains(s2)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1763941/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3530. 二进制数

```c++
#include<bits/stdc++.h>
using namespace std;

int main(){
    unsigned int n;
    while(cin >> n){
        string s="";
        if(!n){
            s="0";
        }
        while(n){
            s += to_string(n&1);
            n >>= 1; 
        }
        reverse(s.begin(),s.end());
        cout << s << endl;

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1763999/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



## 第十六讲 矩阵、计算几何和前缀和

### 3527. 旋转矩阵

```c++
#include<bits/stdc++.h>
using namespace std;

int n;

vector<vector<int>> rotate(vector<vector<int>> &a){
    auto b = a;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            b[j][n-i-1] = a[i][j];
        }
    }
    return b;
}
int main(){
    cin >> n;
    vector<vector<int>> a(n,vector<int>(n));
    auto b = a;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> b[i][j];
        }
    }
    for(int i = 0; i < 4; i++){


        if(a == b){
            cout << i * 90 << endl;
            return 0;
        }
        a = rotate(a);
    }
    cout << -1  << endl;
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1783703/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
###  3534. 矩阵幂

```c++
#include<bits/stdc++.h>

using namespace std;

int n,k;


vector<vector<int>> solve(vector<vector<int>> a,vector<vector<int>> b){
    vector<vector<int>> tmp(n,vector<int>(n));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                    tmp[i][j] += b[i][k] * a[k][j];
            }
        }
    }
    return tmp;
}
int main(){
    cin >> n >> k;
    vector<vector<int>> a(n,vector<int>(n));

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    auto b = a;
    while(--k){
        a = solve(a,b);
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout << a[i][j] <<" ";
        }
        cout << endl;
    }
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1783783/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3535. C翻转

```c++
#include<bits/stdc++.h>
using namespace std;


const int N = 5;
int q[5][5];
int tmp[5][5];
void rotate(int b,int x,int y){
    for(int i = 0; i < b; i++){
        for(int j = 0; j < b; j++){
            //tmp[i][j] = q[b-j-1][i];
            tmp[i][j] = q[x+b-j-1][y+i];
        }
    }
    for(int i = 0; i < b; i++){
        for(int j  = 0; j < b; j++){
            q[i+x][j+y] = tmp[i][j];
        }
    }

}
int main(){
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
            cin >> q[i][j];
        }
    }
    int a,b,x,y;
    cin >> a>>b>>x>>y;
    x--,y--;
    if(a == 1){
        rotate(b,x,y);
    }else{
        for(int i = 0; i < 3; i++){
            rotate(b,x,y);
        }
    }
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
             cout << q[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1784077/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3571. 点的距离

```c++
#include<bits/stdc++.h>
using namespace std;

int T;
int x,y,a,b;
int main(){
    cin >> T;
    while(T--){
        cin >> x >> y >> a >> b;
        double ans = sqrt((x-a)*(x-a)+(y-b)*(y-b));
        printf("%.2lf\n",ans);
    }
    return 0;

}
```

### 3572. 直角三角形

```java
#include<bits/stdc++.h>
using namespace std;

double x,y,z,a,b,c;
int T;
int main(){
    cin >> T;
    while(T--){
        cin >> x >>  a >> y >> b >> z >> c;
        double xx = (x-y)*(x-y)+(a-b)*(a-b);
        double yy = (x-z)*(x-z)+(a-c)*(a-c);
        double zz = (y-z)*(y-z)+(b-c)*(b-c);
        double p[3] = {xx,yy,zz};
        sort(p,p+3);
        if(p[0]+p[1]==p[2]){
            puts("Yes");
        }else{
            puts("No");
        }
        printf("%.2lf\n",sqrt(xx)+sqrt(yy)+sqrt(zz));
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1820703/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3553. 最长平衡串

```c++
错误解法：每次写的时候看到数据范围都知道有好解法，不愿意取打暴力，前缀和的话，要注意式子与式子间的优化，这类题还是hash优化的多。
#include<bits/stdc++.h>
using namespace std;

const int N = 1e6+10;
int a[N],b[N];
int main(){
    string s;
    cin >> s;
    int ans = 0;
    for(int i = 1; i <= s.size(); i++){
        if(s[i-1]=='0'){
            a[i] += a[i-1]+1;
            b[i] += b[i-1];
        }else{
            b[i] += b[i-1]+1;
            a[i] += a[i-1];
        }
            ans = max(ans,min(a[i],b[i])*2);
    }
    cout << ans <<endl;
    return 0;
}
//这道题有点思维的呀
//如果你预处理前缀和的话，然后去枚举首尾找max 的话就会爆掉，所以这题只能用o（n）或者o（nlogn）
#include<bits/stdc++.h>

using namespace std;

const int N = 1e6+10;
char a[N];
int main(){
    unordered_map<int,int> hash;
    scanf("%s", a+1);
    int len = strlen(a+1);
    int s = 0,res = 0;
    // s[i] = a[i]-b[i] 就是 0处的0和1个数相减都等于0，第一个点就是0
    //key存的就是差值 value是位置 出现key相同就去处理结果 这样比去找两个差值即（a[i]-b[i]和a[j]-b[j]）相同的点更好
    hash[0] = 0;
    for(int i = 1; i <= len; i++){
        if(a[i] == '0'){
            s++;
        }else{
            s--;
        }
        //记录结果
        if(hash.count(s)){
            res = max(res,i-hash[s]);
        }else{
            hash[s] = i;
        }
    }
    cout << res << endl;
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1820953/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



## 第十七讲 推公式、最短路、思维题

### 3455. 数字台阶

```c++
#include<bits/stdc++.h>
using namespace std;

int T;
int main(){
    cin >> T;
    while(T--){
        int a,b;
        cin >> a >> b;
        if(a - 1 == b + 1 || a == b){
            if(a == b){
                if(a % 2 == 0){
                    cout << 2 * a << endl;
                }else{
                    cout <<2 * a - 1 << endl;
                }
            }else{
                if((a - 1) % 2 != 0){
                    cout << 2 * (a - 1) << endl;
                }else{
                    cout << 2 * (a - 1) - 1 << endl;
                }
            }
        }else{
            cout << "No Number" << endl;
        }
    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1834656/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3558. 整数和
```java
#include<bits/stdc++.h>
using namespace std;

int T;
int main(){
    cin >> T;
    while(T--){
        int n;
        cin >> n;
        bool flag = false;
        if(n < 0){
            n = -n;
            flag = true;
        }
        int sum = 0;
        for(int i = n; i <= 2*n; i++){
            sum += i;
        }
        if(flag){
            cout << -sum << endl;
        }else{
            cout << sum << endl;
        }

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1834663/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```








### 3570. 弹地小球

```c++
#include<bits/stdc++.h>
using namespace std;

int T;
int main(){
    cin >> T;
    while(T--){
        double n,m;
        cin >> n >> m;
        double ans = n;
        for(int i = 1; i < m; i++){
            ans += n;
            n /= 2.0;
        }
        printf("%.2lf\n",ans);
    }
}
```

### 3403. 我想回家

```c++
#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

const int N = 610, INF = 0x3f3f3f3f;

int n, m;
int g[N][N], camp[N];
int dist[N];
bool st[N];
void dijkstra(int color)
{
    dist[color] = 0;
    priority_queue<PII, vector<PII>, greater<PII>> heap;
    heap.push({0, color});

    while (heap.size())
    {
        PII t = heap.top(); heap.pop();
        int ver = t.second, distance = t.first;
        if (st[ver]) continue;
        st[ver] = true;
        for (int j = 1; j <= n; j ++ )
        {
            if (camp[j] == color && dist[j] > dist[ver] + g[ver][j])
            {
                dist[j] = dist[ver] + g[ver][j];
                heap.push({dist[j], j});
            }
        }
    }
}

void solve()
{
    scanf("%d", &m);
    while (m -- )
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = g[b][a] = min(g[a][b], c);
    }
    for (int i = 1; i <= n; i ++ ) scanf("%d", &camp[i]);
    dijkstra(1);
    dijkstra(2);
    int res = INF;
    for (int i = 1; i <= n; i ++ )
    {
        for (int j = 1; j <= n; j ++ )
        {   
            if(camp[i] == 1 && camp[j] == 2 && dist[i] != INF && dist[j] != INF){
                res = min(res, dist[i] + dist[j] + g[i][j]);
            }
        }
    }
    if (res == INF) res = -1;
    printf("%d\n", res);
}
int main()
{
    while (scanf("%d", &n), n)
    {
        memset(g, 0x3f, sizeof g);
        memset(dist, 0x3f, sizeof dist);
        memset(st, 0, sizeof st);
        solve();
    }

    return 0;
}




#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 610, M = 20010, INF = 0x3f3f3f3f;

int n, m;
int h[N], e[M], w[M], ne[M], idx;
int q[N], dist1[N], dist2[N];
bool st[N];
int team[N];

void add(int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx ++ ;
}

void spfa(int start, int dist[])
{
    int hh = 0, tt = 1;
    q[0] = start;
    memset(dist, 0x3f, sizeof dist1);
    dist[start] = 0;

    while (hh != tt)
    {
        int t = q[hh ++ ];
        if (hh == N) hh = 0;
        st[t] = false;

        for (int i = h[t]; ~i; i = ne[i])
        {
            int j = e[i];
            if (team[j] != start) continue;
            if (dist[j] > dist[t] + w[i])
            {
                dist[j] = dist[t] + w[i];
                if (!st[j])
                {
                    q[tt ++ ] = j;
                    if (tt == N) tt = 0;
                    st[j] = true;
                }
            }
        }
    }
}


int main()
{
    while (scanf("%d", &n), n)
    {
        scanf("%d", &m);
        memset(h, -1, sizeof h), idx = 0;

        while (m -- )
        {
            int a, b, c;
            scanf("%d%d%d", &a, &b, &c);
            add(a, b, c), add(b, a, c);
        }

        for (int i = 1; i <= n; i ++ ) scanf("%d", &team[i]);

        spfa(1, dist1);
        spfa(2, dist2);

        int res = INF;
        for (int i = 0; i < idx; i ++ )
        {
            int a = e[i ^ 1], b = e[i];
            if (team[a] == 1 && team[b] == 2)
                res = min(res, dist1[a] + w[i] + dist2[b]);
        }

        if (res == INF) puts("-1");
        else cout << res << endl;
    }

    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1835167/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3488. 最短路径

```c++
解法多种多样关键是使用并查集进行优化
求最短距离可以用多种dfs，dijstra，floyd，spfa都可以，在本题中高精度就是个幌子，用快速幂，也可以不用。最重要是洞悉刚开始加边的值就是最小值

#include<bits/stdc++.h>
using namespace std;

typedef long long LL;
const int N = 110,MOD = 100000,INF = 0x3f3f3f3f;
int g[N][N];
bool st[N];
int dist[N];
int p[N];
int n,m;
int find(int x){
    if(x!= p[x]){
        p[x] = find(p[x]);
    }
    return p[x];
}
int qmi(int a,int b,int mod){
    int res = 1;
    while(b!=0){
        if(b&1){
            res = (LL)res * a %mod;
        }
        b = b >> 1;
        a = (LL)a*a%mod;
    }
    return res%mod;
}
void distjra(){
    memset(dist,INF,sizeof dist);
    dist[0] = 0;
    for(int i = 0; i < n; i++){
        int t = -1;
        for(int j = 0; j < n; j++){
            if(!st[j]&&(t==-1||dist[t] > dist[j])){
                t = j;
            }
        }
        st[t] = true;
        for(int j = 0; j < n; j++){
            dist[j] = min(dist[j],dist[t]+g[t][j]);
        }
    }
    for(int i = 1; i < n; i++){
        if(dist[i]!=INF){
            cout << dist[i]%MOD <<endl;
        }else{
            cout << -1<<endl;
        }
    }
}
int main(){
    cin >> n >> m;
    memset(st,0,sizeof st);
    memset(g,INF,sizeof g);
    for(int i = 1; i <= n; i++){
        p[i] = i;
    }
    for(int i = 0; i < m; i++){
        int a,b;
        cin >> a >> b;
        int aa = find(a);
        int bb = find(b);
        if(aa!=bb){
            p[aa] = bb;
            g[a][b] = g[b][a] = min(g[a][b],(int)qmi(2,i,MOD));
        }

    }
    distjra();
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1873199/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 556. 最短路径

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 55,M = N*N/2,INF = 0x3f3f3f3f;
int T;
int g[N][N],d[N][N];
int n,m,q;
struct Edge{
    int a,b;
}e[M];
void floyd(){
    memcpy(g,d,sizeof d);
    for(int k = 1; k <= n; k++){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                g[i][j] = min(g[i][j],g[i][k]+g[k][j]);
            }
        }
    }
}

int main(){
    cin >> T;
    while(T--){
        cin >> n >> m >> q;
        memset(d,0x3f,sizeof d);
        for(int i = 1; i <= n; i++){
            d[i][i] = 0;
        }
        for(int i = 1; i <= m; i++){
            int x,y,z;
            cin >> x >> y >> z;
            d[x][y] = d[y][x] = z;
            e[i] = {x,y};
        }
        floyd();
        cout << g[1][n] <<endl;
        int s;
        for(int i = 0; i < q; i++){
            cin >> s;
            int a = e[s].a;
            int b = e[s].b;
            d[a][b] = d[b][a] = INF;
        }
        floyd();
        if(g[1][n] == INF){
            puts("-1");
        }else{
            cout << g[1][n] << endl;
        }       
    }


} 

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1907004/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3509. 棋盘遍历问题

```c++
#include<bits/stdc++.h> 
using namespace std;

int n,m;
int main(){
    while(cin >> n >> m){
        bool flag = true;

        if(n==1&&m==1){
            flag = true;
        }else if(n==1||m==1){
            flag = false;
        }else if(n*m & 1){
            flag = false;
        }
        printf( flag ?"Y\n":"N\n");

    }
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1936327/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

##  第十八讲 哈希表、双指针、序列型DP

### 3447. 子串计算

```c++
#include<bits/stdc++.h>
using namespace std;


int main(){
    string s;

    while(cin >> s){
        map<string,int> hash;
        for(int i = 0; i < s.size(); i++){
            string ss;
            for(int j = i; j < s.size(); j++){

                hash[s.substr(i,j-i+1)]++;
            }
        }
        for(auto &[k,v]:hash){
            if(v > 1){
                cout << k <<" " << v <<endl;
            }
        }
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1808765/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3542. 查找

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 101,M = 210;
int hash[N];
int n,m;
int e[M],h[N],ne[M],idx;
void add(int b){
    int cnt = (b%N+N)%N;
    e[idx] = b;
    ne[idx] = h[cnt];
    h[cnt] = idx++;
}
bool find(int x){
    int cnt = (x%N+N)%N;
    for(int i = h[cnt]; ~i; i = ne[i]){
        if(x==e[i]){
            return true;
        }
    }
    return false;
}
int main(){
    memset(h,-1,sizeof h);
    cin >> n;
    int x;
    while(n--){
        cin >> x;
        add(x);
    }
    cin >> m;

    while(m--){
        cin >> x;
        if(find(x)){
            puts("YES");
        }else{
            puts("NO");
        }
    }
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1863869/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3581. 单词识别

```c++
#include<bits/stdc++.h>
using namespace std;
//用hash表存储，但是要处理空格和句号和逗号

string lower(string tmp){
    for(int i = 0; i < tmp.size(); i ++ ){
        if(tmp[i] <= 'Z' && tmp[i] >= 'A')
            tmp[i] = char(tmp[i] - 'A' + 'a');
    }
    return tmp;
}

int main()
{
    string s;
    getline(cin, s);
    map<string,int> hash;
    for (int i = 0,j = 0; i < s.size(); i ++ ){
         while(j < s.size() && s[j]!=' '&&s[j]!='.'&&s[j]!=','){

            j++;
        }
        string x = s.substr(i, j - i);
        hash[lower(x)]++;
        while(j < s.size() && (s[j]==' '||s[j]=='.'||s[j]==',')){
            j++;
        }
        i = j-1;

    }
    for (auto& [k, v]: hash)
        cout << k << ':' << v << endl;

    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1868741/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3487. 最小面积子矩阵

```c++
#include<bits/stdc++.h>
using namespace std;


const int N = 110,INF = 1e5+10;
int n,m,k;
int sum[N][N];
int main(){
    cin >> n >> m >> k;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> sum[i][j];
            sum[i][j] += sum[i-1][j];
        }
    }
    int res = INF;
    //枚举每一行
    for(int x = 1; x <= n; x++){
        for(int y = x; y <= n; y++){

            for(int i = 1, j = 1,s = 0; i <= m;i++){
                s += sum[y][i]-sum[x-1][i];
                //减去每一列
                while(s - (sum[y][j]-sum[x-1][j]) >= k){
                    s -= sum[y][j]-sum[x-1][j];
                    j++;
                }
                if(s >= k){
                    res = min(res,(y-x+1)*(i-j+1));
                }

            }
        }
    }
    if(res == INF){
        res = -1;
    }
    cout << res <<endl;
    return 0;    
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1936643/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3393. 最大序列和

```c++
#include<bits/stdc++.h>
using namespace std;

int n;

int main(){
    cin >> n;
    long long ans = -1e9,tmp = 0;
    cin >> tmp;
    ans = max(ans,tmp);
    int x;
    for(int i = 1; i < n; i++){
        cin >> x;
        tmp = x+max(0LL,tmp);
        ans = max(ans,tmp);
    }
    cout << ans << endl;
    return 0;
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1936325/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 3505. 最长ZigZag子序列

```java
// 这个需要分成两种集合，f[i]和g[i],f[i]是以a[i]结尾且最后是上升情况的集合，
//g[i]是以a[i]结尾的最后是下降情况的集合。 
//最后取个max即可
//f[i] = max(f[i],g[i-1]+1) 
//g[i] = max(g[i],f[i-1]+1) 

#include<bits/stdc++.h>
using namespace std;

const int N = 55;
int n;
int a[N],f[N],g[N];
int main(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> a[i];
        f[i] = g[i] = 1; 
    }
    int res = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j < i; j++){
            if(a[j] > a[i]){
                f[i] = max(f[i],g[j]+1);
            }else if(a[j] < a[i]){
                g[i] = max(g[i],f[j]+1);
            }

        }
        res = max(f[i],g[i]);
    }
    cout << res <<endl;
    return 0;
}


作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1959534/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 第十九讲 红黑树和并查集

## 836. 合并集合

```c++
优化方式：
1.路径压缩
2.按秩合并【子树高度】【节点数目】
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

const int N = 1e5+10;

int p[N];
int n,m;
char op[2];
int a,b;
int find(int x){
    if(p[x] != x){
        p[x] = find(p[x]);
    }
    return p[x];
}
int main()
{   
    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        p[i] = i;
    }

    while(m--){
        cin >> op >> a >> b;
        int fa = find(a);
        int fb = find(b);
        if(*op =='M'){

            if(fa!=fb){
                p[fa] = fb;
            }
        }else{
            if(fa==fb){
                cout <<"Yes" <<endl;
            }else{
                cout << "No" <<endl;
            }
        }
    }
    return 0;

}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2178810/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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