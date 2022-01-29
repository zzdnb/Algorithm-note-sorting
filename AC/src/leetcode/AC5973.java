package leetcode;

import java.util.*;

public class AC5973 {
    public static void main(String[] args) {
        System.out.println(new AC5973().highestRankedKItems(new int[][]{{0,2,0}},new int[]{2,2},new int[]{0,1},1));
    }

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
