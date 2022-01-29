package leetcode;

/**
 * 200 岛屿问题
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
public class B {
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '*';
                    queue.offer(new int[]{i, j});
                    bfs(grid, queue);
                }
            }
        }
        return res;
    }

    static void bfs(char[][] grid, Queue<int[]> queue) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + curr[0];
                int y = dy[i] + curr[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                    continue;
                }

                grid[x][y] = '*';
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(arr));
    }
}