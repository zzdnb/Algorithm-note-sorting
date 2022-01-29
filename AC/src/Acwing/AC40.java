package Acwing;

public class AC40 {
    public static void main(String[] args) {
        System.out.println(new AC40().printMatrix(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}}));
    }
    public int[] printMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[]dx = {-1,0,1,0},dy = {0,1,0,-1};
        int x = 0, y = 0, k = 1;
        int[]ans = new int[n*m];
        for(int i = 0; i < n*m; i++){
            System.out.println(x +" "+ y);
            ans[i] = matrix[x][y];
            matrix[x][y] = -1;
            int xx = x + dx[k];
            int yy = y + dy[k];

            if(xx < 0 || xx >= n || yy < 0 || yy >= m|| matrix[xx][yy] == -1){
                k = (k+1)%4;
                xx = x + dx[k];
                yy = yy + dy[k];
            }
            x = xx;
            y = yy;
        }
        return ans;
    }
}
