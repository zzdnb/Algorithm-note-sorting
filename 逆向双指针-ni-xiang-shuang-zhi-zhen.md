---
title: 逆向双指针
date: 2022-01-07 12:14:28.457
updated: 2022-01-14 22:12:31.646
url: /archives/ni-xiang-shuang-zhi-zhen
categories: 算法
tags: 逆向双指针
---

[TOC]()
## LeetCode5.最长回文子串
```java
class Solution {
    public String longestPalindrome(String s) {
        String ss = "";
        for(int i = 0; i < s.length() ;i++){
            int l = i-1, r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if(ss.length() < r - l - 1){
                ss = s.substring(l+1,r);
            }

        
            l = i;
            r = i+1;
            while(l >= 0 && r< s.length() && s.charAt(l)== s.charAt(r)){
                l--;
                r++;
            }
            if(ss.length() < r - l - 1){
                ss = s.substring(l+1,r);
            }
            
        }
        return ss;
    }
}
```
## LeetCode11.盛水最多的容器
## LeetCode15.三数之和
```java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if(nums == null ||nums.length < 3){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
               continue;
            }
            int l = i + 1;
            int r = len-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else {
                    r--;
                }
            }



        }
        return list;
    }
}

作者：福尔摩东
链接：https://www.acwing.com/activity/content/code/content/1355914/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```	
## LeetCode16.最接近的三数之和
## LeetCode18.四数之和
## LeetCode125.验证回文串
## LeetCode167.两数之和Ⅱ-输入有序数组
## LeetCode344.反转字符串
## LeetCode345.反转字符串中的元音字母