package Acwing;

import java.util.LinkedList;
import java.util.Queue;

public class K {
    public static void main(String[] args) {

    }

    private boolean[][] visited = new boolean[55][55];
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            res++;
            for (int i = 0; i < 4; i++) {
                int fx = x[0] + dx[i];
                int fy = x[1] + dy[i];
//                if (fx >= 0 && fy >= 0 && fx < rows && fy < cols &&)
            }
        }
        return 0;
    }
}
