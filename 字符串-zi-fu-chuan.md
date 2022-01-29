---
title: 字符串
date: 2022-01-07 12:40:46.291
updated: 2022-01-14 21:49:43.543
url: /archives/zi-fu-chuan
categories: 算法
tags: 
---

LeetCode5.最长回文子串（中心扩展法）
```java
 public String longestPalindrome(String s) {

        String res = "";
        for(int i = 0; i<s.length(); i++){
            //奇数情况
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                r ++;
                l --;
            }

            // r-1 - (l+1) + 1 = r - l - 1
            
            if(res.length()<r-l-1) res=s.substring(l+1,r);

            //偶数情况
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                r ++;
                l --;
            }

            if(res.length()<r-l-1) res=s.substring(l+1,r);

        }

        return res;

    }
```
LeetCode520.检测大写字母（模拟）
LeetCode521.最长特殊序列1（脑筋急转弯）
LeetCode522.最长特殊序列2（双指针判定子序列）
LeetCode551.学生出勤记录1
LeetCode647.回文子串（中心扩展法）
LeetCode1332.删除回文子序列（脑筋急转弯）
LeetCode1637.统计只差一个字符的子串数目（暴力枚举）