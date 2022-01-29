---
title: 滑动窗口
date: 2022-01-07 12:13:45.062
updated: 2022-01-07 12:50:38.482
url: /archives/hua-dong-chuang-kou
categories: 算法
tags: 滑动窗口
---


[TOC](滑动窗口)
## ACW154 滑动窗口
(https://www.acwing.com/problem/content/156/)
```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 1e6+10;
int n,m;
int p[N],q[N];
int hh = 0,tt = -1;
int main()
{
    scanf("%d%d",&n,&m);
    for (int i = 0; i < n; i ++ ){
        scanf("%d", &p[i]);
    }
    for(int i = 0; i < n; i++){
        if(hh <= tt && i-m+1 > q[hh]){
            hh++;
        }
        while(hh <= tt && p[q[tt]] >= p[i]){
            tt--;
        }
        q[++tt] = i;
        if(i+1>=m){
            printf("%d ",p[q[hh]]);
        }
    }
    cout  <<endl;
    hh = 0;
    tt = -1;
    for(int i = 0; i < n; i++){
        if(hh <= tt && i-m+1 > q[hh]){
            hh++;
        }
        while(hh <= tt && p[q[tt]] <= p[i]){
            tt--;
        }
        q[++tt] = i;
        if(i+1>=m){
            printf("%d ",p[q[hh]]);
        }
    }
    return 0;
    
}
```
## ACW135 最大子序和
```c++
#include<bits/stdc++.h>

using namespace std;
typedef long long LL;
const int N = 300005;
int q[N],a[N];
LL s[N];


int n,m;
int main(){
    cin >> n >> m;

    for(int i = 1; i <= n; i++){
        cin >> a[i];
        s[i] += s[i-1] + a[i];
    }
    int hh = 0, tt = 0;
    LL ans = INT_MIN;
    //q[0] = 0 这里放了一个s[0]，我们要求的就是在j固定的前提下求在j-m到j中最小的值，可以用单调队列
    //这里的q中存的是下标
    for(int i = 1; i <= n; i++){
        while(hh <= tt && i - m > q[hh]){
            hh ++;
        }
        ans = max(ans,s[i] - s[q[hh]]);
        //从队头到队尾是一个递增序列，队头最小
        while(hh <= tt && s[q[tt]] >= s[i]){
            tt--;
        }

        q[++tt] = i;
    }
    //我写过i-1，i-1它是从零开始存的，存完再开始计算都是一样的。
    cout << ans << endl;
}
```
## LeetCode3.无重复字符的最长子串
## LeetCode76.最小覆盖子串
## LeetCode209.长度最小的子数组（前缀和+双指针）
## LeetCode424.替换后的最长重复字符
```c++
class Solution {
public:
    int characterReplacement(string s, int k) {
        int ans = 0;
        for(int i = 0; i < 26;i++){
            char c = (char)('A'+i);
            for(int i = 0, j = 0, cnt = 0; i < s.length(); i++){
                if(s[i] == c){
                    cnt++;
                }
                while(i-j+1-cnt > k){
                    if(s[j]==c){
                        cnt--;
                    }
                    j++;
                }
                ans = max(ans,i-j+1);
            }
        }
        return ans;
    }
};
```
## LeetCode438.找到字符串中所有字母异位词
## LeetCode532.数组中的k-diff数对
## LeetCode567.字符串的排列
## LeetCode1004.最大连续1的个数Ⅲ
## LeetCode1493.删掉一个元素以后全为1的最长子数组
## LeetCode1695.删除子数组的最大得分（哈希表+滑动窗口）
## 和大于等于 target 的最短子数组
https://leetcode-cn.com/problems/2VG8Kg/
```c++
滑动窗口，用双指针实现：

窗口内之和小于目标值时右指针向右移动增加窗口宽度；
窗口内之和大于目标值时左指针向右移动减少窗口宽度。
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        if (nums.empty()) return 0;

        int left = 0;
        int curSum = 0;
        int minLength = INT_MAX;

        for (int right = 0; right < nums.size(); ++ right)
        {
            curSum += nums[right];
            while (left <= right && curSum >= target)
            {
                minLength = min(minLength, right - left + 1);
                curSum -= nums[left ++ ];
            }
        }

        return minLength == INT_MAX ? 0 : minLength;
    }
};
```
