---
title: 贪心算法
date: 2022-01-07 12:30:02.391
updated: 2022-01-15 12:40:33.971
url: /archives/tan-xin-suan-fa
categories: 算法
tags: 
---

## AcWing 1978. 奶牛过马路（贪心加二分）
```java
import java.util.Arrays;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] tmp = new int[n+10];
        for (int i = 0; i < n; i++) {

            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

        }

        Arrays.sort(arr, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        int r = arr[0][1];
        int ans = 1;
        tmp[1] = r;
        for (int i = 1; i < n; i++) {
            if (arr[i][1] > r) {
                tmp[++ans] = r = arr[i][1];
            } else {
               int ll = 1, rr = ans+1;
               while(ll < rr){
                   int mid = (ll+rr)>>1;
                   if( tmp[mid] > arr[i][1]){
                       rr = mid;
                   }else{
                       ll = mid+1;
                   }
               }
               ans = ll-1;


            }
        }
        System.out.println(ans);
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/2281911/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
## LeetCode55.跳跃游戏
## LeetCode45.跳跃游戏Ⅱ
## LeetCode124.加油站
## LeetCode316.去除重复字母（贪心+单调栈+哈希表）
## LeetCode330.按要求补齐数组
## LeetCode376.摆动序列
## LeetCode402.移掉K位数字（贪心+单调栈）
## LeetCode455.分发饼干
## LeetCode502.IPO（贪心+堆）
## LeetCode605.种花问题
## LeetCode649.Dota2参议院（贪心+队列）
## LeetCode659.分割数组为连续子序列（贪心+哈希表）
## LeetCode681.翻转矩阵后的得分（基于操作顺序的贪心）
## LeetCode767.重构字符串（贪心+堆）
## LeetCode738.单调递增是数字
## LeetCode860.柠檬水找零
## LeetCode1642.可以到达的最远建筑（贪心+堆）
## LeetCode1648.销售价值减少的颜色球（贪心+优化计算）
## LeetCode1673.找出最具竞争力的子序列（贪心+单调栈，同402）
# 区间类贪心
## LeetCode435.无重叠区间
## LeetCode452.用最少数量的箭引爆气球
## LeetCode1024.视频拼接

