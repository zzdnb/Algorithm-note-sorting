---
title: 树状数组
date: 2022-01-07 12:35:22.255
updated: 2022-01-21 22:43:13.013
url: /archives/shu-zhuang-shu-zu
categories: 算法
tags: 
---

> 树状数组先了解基本原理，然后再去拓展【差分或者是差分加公式】
>
> 主要用处：
>
> 1.快速求前缀和[o(logn)]
>
> 2.修改某个数[o(logn)]
>
> 正常情况下，我们可以用数组来维护修改 o(n) o(1)
>
> 用前缀数组来维护求前缀和 o(n) o(1)

基于二进制来实现：

比如说 x = 2 ^ ik + 2 ^ i(k-1) + ... + 2^1 这里的k是小于等于 log x的

区间划分

(x-2 ^ i1,x]  包含 2 ^ i1 个数

(x - 2 ^ i1 - 2^i2 , x - 2 ^ i1]   包含2 ^ i2 个数

... 

(0,2^ik] 包含2 ^ ik 个数



那么对于 (l,R]来说就是R的最后一个1对应的次幂

就是(r-lowbit(r)+1,r) 分析一下这里就是 lowbit就是截取最后一个1后面的所有位，r-lowbit（r）+1再到r就是区间起点。

![](https://s3.bmp.ovh/imgs/2022/01/b312a16d35ea1000.png)

那么区间划分就是

- ![image-20211112201658750](https://s3.bmp.ovh/imgs/2022/01/49a9825ea075464f.png)

  

- ![image-20211112202225829](https://s3.bmp.ovh/imgs/2022/01/e599192dd0ed0693.png)通过父节点来找子节点

- 通过子节点来找父节点![image-20211112203002835](https://s3.bmp.ovh/imgs/2022/01/5c0ac392809c90b4.png)



```java
(lowbit) O(nlogn)
使用lowbit操作，进行，每次lowbit操作截取一个数字最后一个1后面的所有位，每次减去lowbit得到的数字，直到数字减到0，就得到了最终1的个数，

lowbit原理
根据计算机负数表示的特点，如一个数字原码是10001000，他的负数表示形势是补码，就是反码+1，反码是01110111，加一则是01111000，二者按位与得到了1000，就是我们想要的lowbit操作
相当于 n -= (-n) & n
```

```c++
int tr[N];


int lowbit(int x){
    return x & -x;
}
//修改某个数
void add(int x,int c){
    for(int i = x; i <= n; i+=lowbit(i)){
        tr[i]+=c;
    }
}
int sum(int x){
    int res = 0;
    for(int i = x; i; i-=lowbit(i)){
        res += tr[i];
    }
    return res;
}
int main()
{
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> a[i];
    }
    for(int i = 1; i <= n; i++){
        int y = a[i];
        Greater[i] = sum(n) - sum(y);
        lower[i] = sum(y-1);
        add(y,1);
    }
    memset(tr,0,sizeof(tr));
    LL res1,res2;
    for(int i = n; i; i--){
        int y = a[i];
        res1 = Greater[i] * (LL)(sum(n) - sum(y));
        res2 = lower[i] * (LL)(sum(y-1));
        add(y,1);
    }
    cout << res1 <<" "<< res2 <<endl;
    return 0;
    
}
```


LeetCode307.区域和检索-数组可修改（树状数组模板题）
LeetCode315.计算右侧小于当前元素的个数
LeetCode327.区间和的个数
LeetCode493.翻转对
LeetCode1649.通过指令创建有序数组
剑指offer.51.数组中的逆序对