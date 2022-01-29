---
title: LeetCode周赛补题
date: 2022-01-16 16:37:14.762
updated: 2022-01-16 16:37:14.762
url: /archives/leetcode-zhou-sai-bu-ti
categories: 算法
tags: 
---

>中午不想打，下午补一补
![image.png](/upload/2022/01/image-2a1076f88bfd4145b9d4fe4ee3518ceb.png)
## 5980. 将字符串拆分为若干长度为 k 的组
>简单模拟
```java
class Solution {
    public String[] divideString(String s, int k, char fill) {
           int cnt = s.length();
        int n = cnt/k;
        int mod = cnt%k;
        String[]ans = new String[n+(mod==0?0:1)];
        for(int i = 0; i < n; i++){
            String ss="";
            for(int j = 0; j < k; j++){
                ss += s.charAt(i*k+j);
            }
            ans[i] = ss;
        }
        String ss="";
        if(mod!=0){
            for(int i = 0; i < mod; i++){
                ss += s.charAt(n*k+i);
            }
            for(int i = 0; i < k-mod; i++){
                ss +=fill;
            }
            ans[ans.length-1] = ss;
        }
        return ans;
        
    }
}
```
## 5194. 得到目标值的最少行动次数
> 从target往回推，注意特判max==0，wa了一次
```java
class Solution {
    public int minMoves(int target, int max) {
        int cnt = 0;
        while(target!=1){
            if(target%2==0&&max >0){
                cnt++;
                max--;
                target /=2;
            }else{
                if(max == 0){
                    cnt += target-1;
                    target = 1;
                    continue;
                }
                cnt++;
                target--;
            }
        }
        return cnt;
    }
}
```
## 5982. 解决智力问题
> DP：状态表示：以第i个数结尾的得到分数集合
属性是最大值
集合划分：主要是 跳过和不跳过：
跳过的话:dp[i+k+1] = max(dp[i+k+1],dp[i]);
不跳过的话： dp[i+1] = max(dp[i],dp[i+1]); 
```java
class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[]arr = new long[n+1];
        long ans = 0;
        for(int i = 0; i < n; i++){
            int ne = i+1;
            if(ne < n){
                arr[ne] = Math.max(arr[ne],arr[i]);
            }
            arr[i]+=q[i][0];
            if(i+q[i][1]+1 < n){
                arr[i+q[i][1]+1] = Math.max(arr[i],arr[i+q[i][1]+1]);
            }
            ans = Math.max(ans,arr[i]);
        }
        return ans;
        
    }
}
```
## 5983. 同时运行 N 台电脑的最长时间
>贪心+前缀和
分析：要求同时运行，所以当剩余总电量 >= sum/n时说明有个电池能够支持一台电脑一直运行，就减去 电量，n--
当< sum/n,就直接返回就行了！！！
```java
class Solution {
    public long maxRunTime(int n, int[] bat) {
        Arrays.sort(bat);
        long sum = 0;
        for(int i : bat) sum += i;
        //
        for(int i = bat.length - 1; i >= 0; i--){
            if(bat[i] > sum / n){
                n--;
                sum -= bat[i];
            }else return sum / n;
        }
        return 0;
    }
}

```