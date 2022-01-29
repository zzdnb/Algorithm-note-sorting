package leetcode;

import java.util.ArrayList;

public class AC111{
    int n = 0,m = 0;
    ArrayList<int[]> list = new ArrayList<>();
    boolean[][] st;
    void dfs(int x,int y, int cnt,int []pos,int[][] terrain, int[][] obstacle){
        st[x][y] = true;
        if(cnt < 0){
            return;
        }
        if(cnt == 0 && (x != pos[0] || y != pos[1])){
            list.add(new int[]{x,y});
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx >= 0 && xx < n && yy >= 0 && yy < m && !st[xx][yy]){
                dfs(xx,yy,cnt+terrain[x][y]-terrain[xx][yy]-obstacle[xx][yy],pos,terrain,obstacle);

            }
        }


    }
    public int[][] bicycleYard(int[] pos, int[][] terrain, int[][] obstacle) {
        n = terrain.length;
        m = terrain[0].length;
        st   = new boolean[n][m];
        dfs(pos[0],pos[1],0,pos,terrain,obstacle);
        list.sort((o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1] - o2[1];
            }
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return 0;
        });
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < 2; j++){
                ans[i][j] = list.get(i)[j];

            }
//            System.out.println(ans[i][0]+" "+ans[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new AC111().bicycleYard(new int[]{1,1},new int[][]{{5,0},{0,6}},new int[][]{{0,6},{7,0}});
    }
}