package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AC5798 {
    public static void main(String[] args) {
        int[][] arr = rotateGrid(new int[][]{{40,10},{30,20}},1);
        for(int[] x: arr){
            System.out.println(Arrays.toString(x));
        }
    }


    public static int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++){
            res[i] = grid[i].clone();
        }
        for (int a = n, b = m, i = 0; a > 0 && b > 0; a -= 2, b -= 2, i ++ ) {
            int x = i, y = i;
            int size = 2*(m+n)-4;
            int[][] q = new int[size][2];
            int tmp = 0;
            for(int j = 0; j < b - 1;j ++,tmp++){
                q[tmp] = new int[]{x,++y};
            }
            for(int j = 0; j < a - 1; j++,tmp++){
                q[tmp] = new int[]{++x,y};
            }
            for(int j = 0; j < b - 1; j++,tmp++){
                q[tmp] = new int[]{x,--y};

            }
            for(int j = 0; j < a - 1; j++,tmp++){
                q[tmp] = new int[]{--x,y};
            }
            System.out.println(grid[q[0][0]][q[0][1]]);
            for(int j = 0; j < size; j++){
                int t = (j+k)%size;
                System.out.println( t +" "+ grid[q[t][0]][q[t][1]]);

                res[q[j][0]][q[j][1]] = grid[q[t][0]][q[t][1]];
                System.out.println(grid[q[0][0]][q[0][1]]);

            }
        }
        return res;
    }
}