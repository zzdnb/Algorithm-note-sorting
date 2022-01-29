---
title: LeetCode周赛总结-227
date: 2022-01-23 14:04:49.916
updated: 2022-01-23 14:05:38.221
url: /archives/leetcode-zhou-sai-zong-jie
categories: 算法
tags: 
---

## LeetCode 2148. 元素计数
```java
class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int len = 0;
        for(int i = 0 ; i < n; i++){
            if(nums[i] > nums[0] && nums[i] < nums[n-1]){
                len ++;
            }
        }
        return len;
    }
}
```

## LeetCode 2149. 按符号重排数组
```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int x:nums){
            if(x > 0){
                list1.add(x);
            }else{
                list2.add(x);
            }
        }
        int[]ans = new int[nums.length];
        int cnt = 0;
        for(int i = 0; i < list1.size(); i++){ 
                ans[cnt++] = list1.get(i);
                ans[cnt++] = list2.get(i);
            
        }
        return ans;
    }
}
```
## 5990. 找出数组中的所有孤独数字
```java
class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int x:nums){
            if(map.containsKey(x)){
                if(map.get(x) == 1){
                    if(!map.containsKey(x-1)&&!map.containsKey(x+1)){
                            list.add(x);
                    }
                }
            }
        }
        return list;
    }
}
```

## 5992. 基于陈述统计最多好人数（位运算）
```java
\class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int res = 0;
        next:
        for(int i = 0; i < 1 << n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if((i >> j & 1) !=0){
                    for(int k = 0; k < n; k++){
                        if(statements[j][k] < 2 && statements[j][k] != (i >> k & 1)){
                            continue next;
                        }
                    }
                    cnt++;
                }
            }
            res = Math.max(res,cnt);
        }
        return res;
    }
}
```

