---
title: Leetcode双周赛
date: 2022-01-23 01:35:11.425
updated: 2022-01-23 01:35:11.425
url: /archives/leetcode-shuang-zhou-sai
categories: 算法
tags: 
---

![image.png](/upload/2022/01/image-3cca936e03524aacb240c75015d2fd40.png)
## 5971. 打折购买糖果的最小开销
```java
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int mod = n%3,div = n/3;
        int ans = 0;
        for(int i = n-1; div !=0 ;i = i-3,div-- ){
            ans += cost[i]+cost[i-1];
        }
        for(int i = 0; i < mod; i++){
            ans += cost[i];
        }
        return ans;
        
    }
}
```

## 5972. 统计隐藏数组数目
```java
class Solution {
    public int numberOfArrays(int[] d, int lower, int upper) {
        long pre = 0;
        long maxx = -(int)1e6,minn = (int)1e6;
        for(int i = 0; i < d.length; i++){
            pre += d[i];
            maxx = Math.max(maxx,pre);
            minn = Math.min(minn,pre);
        }
        int ans = (int) (Math.min(upper-maxx,upper)-Math.max(lower-minn,lower)+1);
        return ans > 0?ans:0;
        
    }
}
```
## 5973. 价格范围内最高排名的 K 样物品
```java
class Solution {
 List<List<Integer>> ans = new ArrayList<>();
    int n, m;
    ArrayList<int[]> tmp = new ArrayList<>();
    int[][]arr;
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        n = grid.length;
        m = grid[0].length;
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            arr[i] = grid[i].clone();
        }
        bfs(grid,pricing,start,k);




        tmp.sort((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (arr[o1[0]][o1[1]] == arr[o2[0]][o2[1]]) {
                    if (o1[0] == o2[0]) {
                        if (o1[1] == o2[1]) {

                        } else {
                            return o1[1] - o2[1];
                        }
                    } else {
                        return o1[0] - o2[0];
                    }
                } else {
                    return arr[o1[0]][o1[1]] - arr[o2[0]][o2[1]];
                }
            } else {
                return o1[2] - o2[2];
            }
            return 0;
        });
        if(tmp.size() < k){

            for(int[] t:tmp){
                ArrayList<Integer> list = new ArrayList();
                list.add(t[0]);
                list.add(t[1]);
                ans.add(list);
            }

        }else{
            for(int i = 0; i < k; i++){
                ArrayList<Integer> list = new ArrayList();
                    list.add(tmp.get(i)[0]);
                    list.add(tmp.get(i)[1]);
                ans.add(list);
            }
        }
        return ans;
    }

    void bfs(int[][] grid, int[] pricing, int[] start, int k) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        if(grid[start[0]][start[1]] > 1 && grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1]){
            tmp.add(new int[]{start[0], start[1], 0});
        }
        grid[start[0]][start[1]] = 0;
        while (q.size() != 0) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = t[0] + dx[i], yy = t[1] + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] != 0 ) {

                    q.offer(new int[]{xx, yy, t[2] + 1});

                    if(grid[xx][yy] >= pricing[0] && grid[xx][yy] <= pricing[1]){System.out.println(xx +" "+yy);
                        tmp.add(new int[]{xx, yy, t[2] + 1});
                    }
                    grid[xx][yy] = 0;
                }
            }
        }
    }
}
```

## 5974. 分隔长廊的方案数
```java
class Solution {
    public int numberOfWays(String c) {
         int n = c.length(), MOD = (int) 1e9 + 7;
        int len = 0;
        long ans = 1;
        int pre = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'S') {
                len++;
                if (len >= 3 && len % 2 != 0) {
                    ans = ans * (i - pre) % MOD;
                }
                pre = i;
            }
        }
        return len > 0 && len % 2 == 0 ? (int) ans : 0;


    
    }
}
```