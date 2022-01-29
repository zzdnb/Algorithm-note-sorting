---
title: 经典好题：暴力搜索
date: 2022-01-24 22:25:52.554
updated: 2022-01-24 22:25:52.554
url: /archives/jing-dian-hao-ti--bao-li-sou-suo
categories: 算法
tags: dfs
---

AC1875
农夫约翰和奶牛贝茜喜欢在业余时间互相出数学题。

约翰给贝茜出了一道相当难的问题，导致她没能解决。

现在，她希望通过给约翰出一道有挑战性的难题来报复他。

贝茜给了约翰一个表达式 (B+E+S+S+I+E)(G+O+E+S)(M+O+O)，其中包含七个变量 B,E,S,I,G,O,M（O 是变量，不是零）。

对于每个变量，她给约翰一个列表，表中包含该变量可采用的最多 20 个整数值。

她要求约翰计算，共有多少种给变量赋值的方法可以使得表达式的计算结果为偶数。

输入格式
第一行包含一个整数 N。

接下来 N 行，每行包含一个变量和该变量的一个可能值。

每个变量至少出现 1 次，最多出现 20 次。

同一变量不会重复列出同一可能值。

输出格式
输出可以使得表达式的计算结果是偶数的给变量赋值的方法总数。

数据范围
7≤N≤140,
所有变量的可能取值范围 [−300,300]
本题答案不会超出int范围。

输入样例：
10
B 2
E 5
S 7
I 10
O 16
M 19
B 3
G 1
I 9
M 2
输出样例：
6
样例解释
共有 6 种可能的赋值方式：

(B,E,S,I,G,O,M) = (2, 5, 7, 10, 1, 16, 19) -> 53,244
                = (2, 5, 7, 10, 1, 16, 2 ) -> 35,496
                = (2, 5, 7, 9,  1, 16, 2 ) -> 34,510
                = (3, 5, 7, 10, 1, 16, 2 ) -> 36,482
                = (3, 5, 7, 9,  1, 16, 19) -> 53,244
                = (3, 5, 7, 9,  1, 16, 2 ) -> 35,496
注意，(2, 5, 7, 10, 1, 16, 19) 和 (3, 5, 7, 9, 1, 16, 19)，虽然计算结果相同，但是赋值方式不同，所以要分别计数。

## 20的7次方
```java
package Acwing;

import java.util.*;

public class AC1875 {
        static long ans = 0;
    static TreeMap<String, ArrayList<Long>> map = new TreeMap<>();
    static long[][] tmp = new long[7][30]; // 7 20
    static long[] arr = new long[7];
    static boolean[] st = new boolean[26];
    static String[] ss = {"B", "E", "G", "I", "M","O", "S"};
    static void dfs(int u) {
        if (u == 7) {

            long b = arr[0], e = arr[1], s = arr[6], i = arr[3], g = arr[2], o = arr[5], m = arr[4];
            if ((b + e + s + s + i + e) * (g + o + e + s) * (m + o + o) % 2 == 0) {
//                System.out.println((b + e + s + s + i + e) * (g + o + e + s) * (m + o + o) );
                ans++;
            }
            return;
        }
//        System.out.println(Arrays.toString(map.keySet().toArray()));

        if (map.get(ss[u]).size() == 0) {
            System.out.println("xxx");
            dfs(u + 1);
        } else {
            for (int j = 0; j < map.get(ss[u]).size(); j++) {
                if (tmp[u][j] != 400) {
                    arr[u] = tmp[u][j];
                    tmp[u][j] = 400;
                    dfs(u + 1);
                    tmp[u][j] = arr[u];
                }
            }

        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map.put("B", new ArrayList<>());
        map.put("E", new ArrayList<>());
        map.put("S", new ArrayList<>());
        map.put("I", new ArrayList<>());
        map.put("G", new ArrayList<>());
        map.put("O", new ArrayList<>());
        map.put("M", new ArrayList<>());
        for (int i = 0; i < 7; i++) {
            Arrays.fill(tmp[i], 400);
        }
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("B",0);map1.put("E",1);map1.put("G",2);map1.put("I",3);map1.put("M",4);map1.put("O",5);map1.put("S",6);
        while (n-- != 0) {
            String s = sc.next();
            long x = sc.nextLong();
            ArrayList<Long> list = map.get(s);
            tmp[map1.get(s)][list.size()] = x;
            list.add(x);
            map.put(s, list);
        }
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 30; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();

        }
        dfs(0);
        System.out.println(ans);
    }
}
```

## 优化后：2的7次方
```java
package Acwing;

import java.util.*;

public class AC1875 {
       
    static int ans;
    static String s = "BESIGOM";
    static int[] arr1 = new int[26], arr2 = new int[26], arr3 = new int[26];
    static void dfs(int u, int x) {
        if (u == 7) {
            if ((arr3['B' - 'A'] + arr3['I' - 'A']) % 2 != 0 && (arr3['G' - 'A'] + arr3['O' - 'A'] + arr3['E' - 'A'] + arr3['S' - 'A']) % 2 != 0 && (arr3['M' - 'A'] % 2 != 0)) {
                return;
            }
//            System.out.println(x);
            ans += x;
            return;
        }
        int xx =  (s.charAt(u) - 'A');
        arr3[xx] = 1;
        dfs(u+1,x*arr2[xx]);
        arr3[xx] = 2;
        dfs(u+1,x*arr1[xx]);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            if (x % 2 == 0) {
                //偶数
                arr1[s.charAt(0) - 'A']++;
            } else {
                arr2[s.charAt(0) - 'A']++;
            }

        }

        System.out.println(ans);

    }


}


```
## 二进制优化：
```java
#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main()
{
    int n;
    cin >> n;

    unordered_map<char, int> cnt[2];
    while (n -- )
    {
        char c;
        int x;
        cin >> c >> x;
        cnt[abs(x) % 2][c] ++ ;
    }

    char str[] = "BESIGOM";

    int res = 0;
    unordered_map<char, int> v;
    for (int i = 0; i < 1 << 7; i ++ )
    {
        for (int j = 0; j < 7; j ++ )
            v[str[j]] = i >> j & 1;

        if ((v['B'] + v['I']) * (v['G'] + v['O'] + v['E'] + v['S']) * v['M'] % 2 == 0)
        {
            int sum = 1;
            for (int j = 0; j < 7; j ++ )
                sum *= cnt[i >> j & 1][str[j]];
            res += sum;
        }
    }

    cout << res << endl;
    return 0;
}

```