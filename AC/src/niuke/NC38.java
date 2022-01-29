package niuke;

import java.util.ArrayList;

public class NC38 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};
        int n = matrix.length, m = matrix[0].length;
        int x = 0,y = 0, k = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n*m; i++){
            System.out.println(x +" "+y );
            list.add(matrix[x][y]);
            matrix[x][y] = 0;
            int xx = x + dx[k];
            int yy = y + dy[k];
            if(xx<0||xx>=n||yy<0||yy>=m||matrix[xx][yy]==0){
                k = (k+1)%4;
                xx = x + dx[k];
                yy = y + dy[k];
            }
            x = xx;
            y = yy;
        }
        return list;
    }

    public static void main(String[] args) {
        new NC38().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
