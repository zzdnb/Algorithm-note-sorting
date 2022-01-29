---
title: 哈希表
date: 2022-01-07 12:24:43.965
updated: 2022-01-20 12:05:54.493
url: /archives/ha-xi-biao
categories: 算法
tags: 哈希表
---

[TOC](重新认识Hash表)
# 1. 模拟哈希表
### 1.1 开放寻址法
开放寻址法- 线性探测法
例题：
题目：
      1.设散列函数H(k)=k%13,设关键字系列为{22,12,24,6,45,7,8,13,21},要求用线性探测法处理冲突。
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9nWk84NW5ncDduNGliS3BLb1Y2a1RLUjBPVk0zSGFOU0d3NHNuM0xNMXBRT2t2d0ZEV2xQVFVqd21qYmxoRkJIV01KVWdPUzF0MDRMYUxGaWNXaWFzZ3pwdy82NDA?x-oss-process=image/format,png)
使用线性探测法先求出关键字所在的位置，使用关键字%13得出所存储的位置，如果遇到冲突则(key+di)%13的计算方式得到关键字存储的位置。
  (1)存入第一个元素22，由于h(22)=22%13=9,又因为3号位置没有数据，所以把22存入2号位置，探测次数为1；
  (2)存入第二个元素12，由于h(12)=12%13=12,又因为12号位置没有数据，所以把12存入12号位置，探测次数为1；
  (3)存入第三个元素24，由于h(24)=24%13=11,又因为11号位置没有数据，所以把24存入11号位置，探测次数为1；
  (4)存入第四个元素6，由于h(6)=6%13=6,又因为6号位置没有数据，所以把6存入6号位置，探测次数为1；
  (5)存入第五个元素45，由于h(45)=45%13=6,但6号位置已经被6占用，因此进行限行再散列Hi=(h(key)+di)%m,di=1,2,3,4.....。所以H1=(6+1)%13=7,7号位置没有数组，因此把45存入7号位置，探测次数为2；
  (6)存入第六个元素7，由于h(7)=7%13=7,但7号位置已经被45占用，因此进行限行再散列Hi=(h(key)+di)%m,di=1,2,3,4.....。所以H1=(7+1)%13=8,8号位置没有数组，因此把7存入8号位置，探测次数为2；
  (7)存入第六个元素8，由于h(8)=8%13=8,但8号位置已经被7占用，因此进行限行再散列Hi=(h(key)+di)%m,di=1,2,3,4.....。所以H1=(8+1)%13=9,9号位置也被数据占用，依此类推，H2=(8+2)%13=10，因此把8存入10号位置，探测次数为3；
  (8)存入第八个元素13，由于h(13)=13%13=0,又因为0号位置没有数据，所以把13存入0号位置，探测次数为1；
  (9)存入第九个元素21，由于h(21)=21%13=8,但8号位置已经被7占用，因此进行限行再散列Hi=(h(key)+di)%m,di=1,2,3,4.....。所以H1=(8+1)%13=9,9号位置也被数据占用，依此类推，H6=(8+6)%13=1，因此把21存入1号位置，探测次数为7；

```c++
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
```

### 1.2  拉链法
```c++
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
```


# 2. 字符串哈希
> 字符串前缀哈希法
> 设 str = “abcacbabc”
> 设h[0] = 0 
> h[1] 是a的hash值
> h[2]是ab的hash值
> 那么如何对字符的hash值进行保存，可以利用p进制就是利用ASCII值进行计算
![在这里插入图片描述](https://img-blog.csdnimg.cn/c6bac674ffad47ad8ef9d6a53c578a90.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA56aP5bCU5pGp5Lic,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
```c++
#include<bits/stdc++.h>
using namespace std;

typedef unsigned long long ULL;
const int N = 100010, P = 131;
int n,m;
char str[N];
ULL h[N],p[N];
ULL get(int l,int r){
    return h[r] - h[l-1]*p[r-l+1];
}
int main(){
    scanf("%d%d",&n,&m);
    scanf("%s",str+1);
    
    p[0] = 1;
    for(int i = 1; i <= n; i++){
        //计算并预处理进制
        p[i] = p[i-1]*P;
        //计算每一个前缀和的哈希值
        h[i] = h[i-1]*P+str[i];
    }
    while(m--){
        int l1,r1,l2,r2;
        scanf("%d%d%d%d",&l1,&r1,&l2,&r2);
        if(get(l1,r1) == get(l2,r2)){
            puts("Yes");
        }else{
            puts("No");
        }
    }
    return 0;
}
```

##  处理字符串经常用的还有KMP
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


````
## leetcode 187 字符串哈希
```c++
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string,int> hash;
        vector<string> ans;
        for(int i = 0; i+10 <= s.length(); i++){
            hash[s.substr(i,10)]++;
        }
        for(auto &[k,v]:hash){
            if(v > 1){
                ans.push_back(k);
            }
        }
        return ans;
    }
};
```
```c++
class Solution {
    int N = (int)1e5+10, P = 13331;
    int[] h = new int[N], p = new int[N];
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + 10 - 1));
            map.put(hash, cnt + 1);
        }
        return ans;
    }
}


```

## ACW 141 字符串哈希加二分解决最长回文子串(https://www.acwing.com/problem/content/description/141/)
解析[描述](https://www.acwing.com/solution/content/30482/)
```c++
#include<bits/stdc++.h>
using namespace std;

typedef unsigned long long ULL;
const int N = 2e6+10,P = 131;
ULL sl[N],sr[N],p[N];
char ss[N];
ULL get(ULL s[],int l,int r){
	return s[r] - s[l-1] * p[r-l+1];
}
int main(){
	int T = 1;
	while(scanf("%s",ss+1),strcmp(ss+1,"END")){
		int n = strlen(ss+1);
		//初始化字符串 
		for(int i = n*2; i ; i-=2){
			ss[i] = ss[i/2];
			ss[i-1] = 'z'+1;
		}
		n*=2;
		p[0] = 1;
		for(int i = 1, j = n; i <= n; i++,j--){
			p[i] = p[i-1] *P;
			sl[i] = P * sl[i-1]+ss[i];
			sr[i] = P * sr[i-1]+ss[j];
		}
		int res = 0;
		for(int i = 1; i <= n; i++){
			//半径的最大长度 
			int l = 0, r = min(i-1,n-i);
			while(l < r){
				int mid = (l+r+1)>>1;
				if(get(sl,i-mid,i-1) == get(sr,n-(i+mid)+1,n-(i+1)+1)){
					l = mid;
				}else{
					r = mid - 1;
				}
			}
			if(ss[i-l] <='z'){
				res = max(res,l+1);
			}else{
				res = max(res,l);
			}
		}
		printf("Case %d: %d\n",T++,res);
	}
	
	
}
```
# ACW 1913. 公平摄影[前缀和+双指针+哈希表]
```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import java.io.*;
import java.util.*;
public class Main {
    static class JoinSet {
        int[] fa;
        JoinSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }
        int find(int t) {
            if (t != fa[t]) {
                fa[t] = find(fa[t]);
            }
            return fa[t];
        }
        void join(int x, int y) {
            x = find(x);
            y = find(y);
            fa[x] = y;
        }
    }
    static int mod = (int)1e9+7;
    static int[]dx = {-1,0,1,0},dy = {0,1,0,-1};
    static int[] dx1 = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy1 = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dx2= {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy2= {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[] prime = new boolean[10];
    static {
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int k = 2; i * k < prime.length; k++) {
                    prime[i * k] = false;
                }
            }
        }
    }
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }
    static int powmod(long a, long b, int mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return (int) ans;
    }
    static void sort(int[] a) {
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }
    static void sort(long[] a) {
        int n = a.length;
        Long[] b = new Long[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }
    static int max(int a, int b) {
        return Math.max(a,b);
    }
    static int min(int a, int b) {
        return Math.min(a,b);
    }
    static long max(long a, long b) {
        return Math.max(a,b);
    }
    static long min(long a, long b) {
        return Math.min(a,b);
    }
    static int max(int[] a) {
        int max = a[0];
        for(int i : a) {
            max = max(max,i);
        }
        return max;
    }
    static int min(int[] a) {
        int min = a[0];
        for(int i : a) {
            min = min(min,i);
        }
        return min;
    }
    static long max(long[] a) {
        long max = a[0];
        for(long i : a) {
            max = max(max,i);
        }
        return max;
    }
    static long min(long[] a) {
        long min = a[0];
        for(long i : a) {
            min = min(min,i);
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = "H".equals(sc.next()) ? 1 : -1;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while(j < n &&arr[j][1] == arr[i][1]){
                j++;
            }
            ans = Math.max(ans,arr[j-1][0]-arr[i][0]);
            i = j-1;
        }
        int[] pre = new int[n+1];
        pre[0]=arr[0][1];
        for(int i = 1; i < n; i++){
            pre[i] = pre[i-1]+arr[i][1];
        }
        //存储前缀和与下标
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i = 0; i < n; i++){
            if(!map.containsKey(pre[i])){
                map.put(pre[i],i);
            }else{
                ans = max(ans,arr[i][0]-arr[map.get(pre[i])+1][0]);
            }
        }
        System.out.println(ans);
    }
}

```
# LeetCode49.字母异位词分组
# LeetCode128.最长连续序列
# LeetCode217.存在重复元素
# LeetCode219.存在重复元素Ⅱ
# LeetCode220.存在重复元素Ⅲ
# LeetCode299.猜数字游戏
# LeetCode349.两个数组的交集
# LeetCode350.两个数组的交集Ⅱ
# LeetCode380.常数时间插入、删除和获取随机元素
# LeetCode381.O(1)时间插入、删除和获取随机元素-允许重复
# LeetCode383.赎金信
# LeetCode387.字符中的第一个唯一字符
# LeetCode409.最长回文串
# LeetCode437.路径总和Ⅲ（前缀和+哈希表）
# LeetCode454.四数相加Ⅱ
# LeetCode560.和为K的子数组（前缀和+哈希表）
# LeetCode454.四数相加Ⅱ
# LeetCode146.LRU缓存
# LeetCode460.LFU缓存
# LeetCode523.连续子数组和（前缀和+哈希表）
# LeetCode525.连续数组（前缀和+哈希表）
```java
class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] pre = new int[nums.length+1];
        for(int i = 1; i <= n; i++){
            pre[i] += pre[i-1]+(nums[i-1]==0?1:-1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i <= n;i++){
            if(!map.containsKey(pre[i])){
                map.put(pre[i],i);
            }else{
                ans = Math.max(ans,i-map.get(pre[i]));
            }
        }
        return ans;
    }
}
```
# LeetCode532.数组中的k-diff数对
# LeetCode554.砖墙
# LeetCode575.分糖果
# LeetCode705.设计哈希集合
# LeetCode706.设计哈希映射
# LeetCode1577.数的平方等于两数乘积的方法数
# LeetCode1604.警告一小时内使用相同员工卡大于等于3次的人（哈希表，排序）
# LeetCode1647.字符频次唯一的最小删除次数
# LeetCode1679.K和数对的最小数目（哈希表/双指针）

