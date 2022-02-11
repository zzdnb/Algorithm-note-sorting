package bigdataclass;

import java.util.Arrays;
import java.util.TreeSet;

public class AC2 {
    public static void main(String[] args) {
        System.out.println(getBiggestThree(new int[][]{{7, 7, 7}}));
    }

    public static int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        TreeSet<Integer> set = new TreeSet<Integer>((o1, o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(grid[i][j]);
                for (int k = 1; j + 2 * k < m && i - k >= 0 && i + k < n; k++) {
                    int s = 0;
                    for (int l = 0; l < k; l++) {
                        s += grid[i - l][j + l] + grid[i - k + l][j + k + l] + grid[i + l][j + 2 * k - l] + grid[i + k - l][j + k - l];
                    }
                    set.add(s);
                }
            }
        }
        int[] arr;
        int cnt = 0;
        if (set.size() < 3) {
            arr = new int[set.size()];
            for (int x : set) {
                arr[cnt] = x;
                cnt++;
            }
        } else {
            cnt = 0;
            arr = new int[3];
            for (int x : set) {
                arr[cnt] = x;
                cnt++;
                if (cnt == 3) {
                    break;
                }
            }


        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}

