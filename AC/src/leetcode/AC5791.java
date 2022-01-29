package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AC5791 {
    public static void main(String[] args) {
        System.out.println(new Solution1().countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
    }

}
class Solution1 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid2.length;
        int n = grid2[0].length;

        for(int i = 0; i< m;i++){
            for(int j = 0 ;j <n;j++){
                if(grid2[i][j]==1){
                    grid2[i][j]=2;
                    if(bfs(grid1,grid2,i, j)){
                        res++;
                    }
                }
            }
        }
        return  res;
    }
    boolean bfs(int[][]grid1, int[][] grid2,int xx, int yy){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{xx,yy});
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        boolean flag = true;
        while(!queue.isEmpty()){
            int []curr = queue.poll();
//            System.out.println(curr[0]+" "+curr[1]);
            if( grid1[curr[0]][curr[1]] != 1 ){
                flag = false;
            }
            for(int i = 0;i<4;i++){
                int x = dx[i]+curr[0];
                int y = dy[i]+curr[1];

                if(x<0||x>=grid2.length||y<0||y>=grid2[0].length||grid2[x][y]!=1){
                    continue;
                }
                grid2[x][y] = 2;
                queue.offer(new int[]{x,y});
            }
        }
        return flag;
    }

}