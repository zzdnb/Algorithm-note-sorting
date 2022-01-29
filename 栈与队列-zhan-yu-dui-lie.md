---
title: 栈与队列
date: 2022-01-07 12:16:54.824
updated: 2022-01-26 18:26:23.807
url: /archives/zhan-yu-dui-lie
categories: 算法
tags: 栈 | 队列
---

[TOC](单调栈的讲解及例题)

> 单调栈顾名思义，就是栈中元素呈现单调性。

## 例题一：单调栈
给定一个长度为N的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出-1。

输入格式
第一行包含整数N，表示数列长度。

第二行包含N个整数，表示整数数列。

输出格式
共一行，包含N个整数，其中第i个数表示第i个数的左边第一个比它小的数，如果不存在则输出-1。

数据范围
1≤N≤105
1≤数列中元素≤109
输入样例：
5
3 4 2 7 5
输出样例：
-1 3 -1 2 2

### 解题思路及伪代码

```java
for(int i = 0; i <n; i++ ){
	while(栈不为空并且栈顶元素大于入栈元素){
		栈顶元素出栈；
		更新结果;
		}
	将当前元素可以拓展到的位置入栈
	更新最后一次出栈的栈顶元素其对应的值；
	}
```
### 单调栈做法
java代码实现：

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            while(idx!=0&&arr[idx]>=x){
                idx--;
            }
            if(idx!=0){
                System.out.print(arr[idx]+" ");
            }else{
                System.out.print("-1"+" ");
            }
            arr[++idx] = x;
        }
    }
}
```
## 例题二：直方图中最大的矩形
直方图是由在公共基线处对齐的一系列矩形组成的多边形。

矩形具有相等的宽度，但可以具有不同的高度。

例如，图例左侧显示了由高度为2,1,4,5,1,3,3的矩形组成的直方图，矩形的宽度都为1：
![在这里插入图片描述](https://img-blog.csdnimg.cn/img_convert/a5579f135556cc6dc0a2249b3f5282e4.png#pic_center)



通常，直方图用于表示离散分布，例如，文本中字符的频率。

现在，请你计算在公共基线处对齐的直方图中最大矩形的面积。

图例右图显示了所描绘直方图的最大对齐矩形。

输入格式
输入包含几个测试用例。

每个测试用例占据一行，用以描述一个直方图，并以整数n开始，表示组成直方图的矩形数目。

然后跟随n个整数h1，…，hn。

这些数字以从左到右的顺序表示直方图的各个矩形的高度。

每个矩形的宽度为1。

同行数字用空格隔开。

当输入用例为n=0时，结束输入，且该用例不用考虑。

输出格式
对于每一个测试用例，输出一个整数，代表指定直方图中最大矩形的区域面积。

每个数据占一行。

请注意，此矩形必须在公共基线处对齐。

数据范围
1≤n≤100000,
0≤hi≤1000000000
输入样例：
7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0
输出样例：
8
4000

### 解题思路
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210227221934167.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjg4NTg3,size_16,color_FFFFFF,t_70)
### 暴力做法

```java
先读入数组中的值
int max = 0;
for(int i = 0; i < n; i ++){
	for(int j = i;j < n; j++){
		if(arr[j]>=arr[i]){
			len++;
		}else{
			break;
		}
	}
	max = Math.max(len*arr[i],max);
}
```
这道题其实就是对于每个数找到左边第一个比它小的数的位置，然后找到右边第一个比它小的位置，（右边-左边-1）*高度然后做一下max的比较即可。
单调栈就是一个里面的数单调递增的数的栈，一旦栈顶的元素大于或者等于要加入的数的话，这个数就出栈。
### 单调栈做法
```java
import java.util.*;
class Main{
    static int N = 100010;
    //存储高度
    static int[] h = new int[N];
    //存储左边小于第i个数的第一个数
    static int[] l = new int[N];
    //存储右边大于第i个数的第一个数
    static int[] r = new int[N];
    //临时数组用来存储位置就是下标
    static int[] q = new int[N];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 0){
            for(int i = 1; i <= n; i++){
                h[i] = sc.nextInt();
            }
            //方便特判，高度最小都是0，不存在比0小的数所以开-1
            h[0] = h[n+1] = -1;
            //求左边界
            int tt = 0;
            q[0] = 0;
            for(int i = 1; i <= n; i++){
            //如果前面的数大于等于当前数的话就出栈，就头指针--
                while(h[q[tt]]>=h[i]){
                    tt--;
                }
                //否则就存储说明当前的值就可以存储到l[i]中
                l[i] = q[tt];
                //然后将当前下标加到里面继续组成单调递增的序列
                q[++tt] = i;
            }
            //求右边界
            tt = 0;
            q[0] = n+1;
            for(int i = n; i > 0;i--){
                while(h[q[tt]] >= h[i]){
                    tt--;
                }
                r[i] = q[tt];
                q[++tt]  = i;
            }
            //数据过大，记得开long类型
            long res = 0;
            for(int i = 1; i <= n; i++){
                res = Math.max(res,(long)h[i]*(r[i]-l[i]-1));
            }
            System.out.println(res);
            n = sc.nextInt();
        }
    }
}
```

## 1.1 栈与队列
### 剑指OFFER 42. 栈的压入、弹出序列
模拟栈
```java
class Solution {
    public boolean isPopOrder(int [] pushV,int [] popV) {
        if(pushV.length != popV.length){
            return false;
        }
        Stack<Integer> stk = new Stack<Integer>();
        int cnt = 0;
        int n = pushV.length;
        for(int i = 0; i < n; i++){
            int x = pushV[i];
            
            if(popV[cnt]==x){
                cnt++;
                while(stk.size()!=0 && stk.peek() == popV[cnt]){
                    stk.pop();
                    cnt++;
                }
            }else{
                stk.push(x);
            }
        }
        // System.out.println(cnt);
        if(cnt == n){
            return true;
        }
        return false;
        
    }
}
```
### LeetCode155.最小栈（设计）
### LeetCode844.比较含退格的字符串
### LeetCode1381.设计一个支持增量操作的栈（设计）
### LeetCode622.设计循环队列
### LeetCode641.设计循环双端队列
### LeetCode946.验证栈序列（模拟）
### LeetCode1047.删除字符串中的所有相邻重复项
### LeetCode1209.删除字符串中的所有相邻重复项II
## 1.2 转换
### LeetCode225.用队列实现栈
### LeetCode232.用栈实现队列
## 1.3 单调栈
### LeetCode42.接雨水
### LeetCode84.柱状图中最大的矩形
### LeetCode85.最大矩形（84拓展）
### LeetCode496.下一个更大元素Ⅰ
### LeetCode503.下一个更大元素Ⅱ
### LeetCode739.每日温度
## 1.4 单调队列
### LeetCode239.滑动窗口最大值
## 1.5 逆波兰表达式/计算器
波兰数学家Jan Lukasiewicz提出了另一种数学表示法，它有两种表示形式：
把运算符写在操作数之前，称为波兰表达式(Polish Expression)或前缀表达式(Prefix Expression)，如+AB；
把运算符写在操作数之后，称为逆波兰表达式(Reverse Polish Expression)或后缀表达式(Suffix Expression)，如AB+；
### LeetCode150.逆波兰表达式求值
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
```
LeetCode224.基本计算器
```java
import java.util.*;
class Solution {    
    Stack<Character> op = new Stack();
    Stack<Integer> num = new Stack();
    HashMap<Character,Integer> map = new HashMap<>();
    void eval(Stack<Integer> num,Stack<Character> op){
        int a = num.pop();
        int b = num.pop();
        char c = op.pop();
        int res = 0;
        if(c == '+'){
            res = a+b;
        }else if(c =='-'){
            res = b-a;
        }
        num.push(res);
    }
    public int calculate(String s) {
         // write code here
        num.push(0);
        map.put('+',1);map.put('-',1);
        for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(c==' '){
               continue;
           }
           if(Character.isDigit(c)){
               int j = i,x = 0;
               while(j < s.length()&&Character.isDigit(s.charAt(j))){
                   x = x*10+s.charAt(j)-'0';
                   j++;
               }
               i = j-1;
               num.push(x);
               System.out.println(x);
           }else if('(' == c){
               op.push(c);
           }else if(')' == c){
               while(op.peek()!='('){
                   eval(num,op);
               }
               op.pop();
           }else{
               if (i > 0 && (s.charAt(i-1) == '(' || s.charAt(i-1)  == '+' || s.charAt(i-1)  == '-')) {
                        num.push(0);
                    }
               while(!op.isEmpty() && op.peek()!='('&&map.get(op.peek())>=map.get(c)){
                   eval(num,op);
               }
               op.push(c);
           }
       }
        while(op.size()!=0){
            eval(num,op);
        }
        return num.peek();
    }    
}
```
LeetCode227.基本计算器Ⅱ
```java
import java.util.*;
class Solution {    
    Stack<Character> op = new Stack();
    Stack<Integer> num = new Stack();
    HashMap<Character,Integer> map = new HashMap<>();
    void eval(Stack<Integer> num,Stack<Character> op){
        int a = num.pop();
        int b = num.pop();
        char c = op.pop();
        int res = 0;
        if(c == '+'){
            res = a+b;
        }else if(c =='-'){
            res = b-a;
        }else if(c == '*'){
            res = a*b;
        }else if(c == '/'){
            res = b/a;
        }
        num.push(res);
    }
    public int calculate(String s) {
         // write code here
        num.push(0);
        map.put('+',1);map.put('-',1);map.put('*',2);map.put('/',2);
        for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(c==' '){
               continue;
           }
           if(Character.isDigit(c)){
               int j = i,x = 0;
               while(j < s.length()&&Character.isDigit(s.charAt(j))){
                   x = x*10+s.charAt(j)-'0';
                   j++;
               }
               i = j-1;
               num.push(x);
               System.out.println(x);
           }else if('(' == c){
               op.push(c);
           }else if(')' == c){
               while(op.peek()!='('){
                   eval(num,op);
               }
               op.pop();
           }else{
               if (i > 0 && (s.charAt(i-1) == '(' || s.charAt(i-1)  == '+' || s.charAt(i-1)  == '-')) {
                    num.push(0);
                }
               while(!op.isEmpty() && op.peek()!='('&&map.get(op.peek())>=map.get(c)){
                   eval(num,op);
               }
               op.push(c);
           }
       }
        while(op.size()!=0){
            eval(num,op);
        }
        return num.peek();
    }

   
        
    
}
```
## 1.6 括号序列
LeetCode20.有效的括号
LeetCode32.最长有效括号
