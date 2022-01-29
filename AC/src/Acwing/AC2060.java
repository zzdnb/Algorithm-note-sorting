//将两个XXX区域染成YYY，然后对两个区域里的所有数进行BFS,记录求曼哈顿距离
package Acwing;
import java.util.*;

public class AC2060 {
    static final int N = 55;
    static int n, m;
    static char[][] ch = new char[N][N];
    static ArrayList<int[]> list1 = new ArrayList<>();
    static ArrayList<int[]> list2 = new ArrayList<>();
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            for (int j = 0; j < s.length(); j++) {
                ch[i][j] = c[j];
            }
        }
        //将搜到的第一个区域染成YYY
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 'X') {
                    queue.offer(new int[]{i,j});
                    ch[i][j] = 'Y';
                    break out;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            list1.add(tmp);

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && ch[xx][yy] == 'X') {
                    queue.offer(new int[]{xx,yy});ch[xx][yy] = 'Y';
                }

            }
        }
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 'X') {
                    queue.offer(new int[]{i,j});
                    ch[i][j] = 'Y';
                    break out;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            list2.add(tmp);
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && ch[xx][yy] == 'X') {

                    queue.offer(new int[]{xx,yy});ch[xx][yy] = 'Y';
                }

            }
        }
        int ans = (int) 1e9;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                ans = Math.min(get(list1.get(i), list2.get(j)), ans);
            }
        }
        System.out.println(ans);
    }
    static int get(int[] p1, int[] p2) {
        return Math.abs(p1[0]- p2[0] )+ Math.abs(p1[1]- p2[1]) - 1;
    }
}