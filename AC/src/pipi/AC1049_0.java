package pipi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC1049_0 {
    static char[][] ch;
    static int[][] cnt;
    static int n;
    static int[]dx = {-1,-1,0,1,1},dy = {0,1,1,1,0};
    static void bfs(){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0,0});
        while(queue.size()!=0){
            int[] tmp = queue.poll();
            for(int i = 0; i < 5; i++){
                int xx = tmp[0]+dx[i];
                int yy = tmp[1]+dy[i];
                if(xx >=0 && xx < 2 && yy >= 0 && yy < n && ch[xx][yy] =='0' ){
                    queue.offer(new int[]{xx,yy});
                    ch[xx][yy] = '1';
                    cnt[xx][yy] = cnt[tmp[0]][tmp[1]] + 1;
                }
            }
        }
        System.out.println(cnt[1][n-1] == 0 ? -1: cnt[1][n-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            n = sc.nextInt();
            ch = new char[2][n];
            cnt = new int[2][n];
            for (int i = 0; i < 2; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    ch[i][j] = s.charAt(j);
                }
            }
            bfs();
        }
    }
}
