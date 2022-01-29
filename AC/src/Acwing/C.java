package Acwing;

import java.util.*;
import java.io.*;

public class C {
    static int r, c, t, a, b, d, e;
    static char[][] arr;
    static int[][] flag;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
        int t = Integer.parseInt(s);

        for (int i = 0; i < t; i++) {
            String[] ss = read.readLine().split(" ");
            r = Integer.parseInt(ss[0]);
            c = Integer.parseInt(ss[1]);
            arr = new char[r][c];
            flag = new int[r][c];
            for (int j = 0; j < r; j++) {
                s = read.readLine();
                for (int k = 0; k < c; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == 'S') {
                        a = j;
                        b = k;
                        arr[j][k]='#';
                    }
                    if (arr[j][k] == 'E') {
                        d = j;
                        e = k;
                    }
                }
            }
            bfs();
        }
    }

    public static void bfs() {
        queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        queue.offer(new int[]{a, b});
        while (!queue.isEmpty()) {
            int []nums = queue.poll();
            if(nums[0]==d&&nums[1]==e){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = nums[0]+dx[i];
                int y = nums[1]+dy[i];
                if(x<0||x>=r||y<0||y>=c||arr[x][y]=='#'){
                    continue;
                }
                arr[x][y] = '#';
                queue.offer(new int[]{x,y});
                flag[x][y] = flag[nums[0]][nums[1]]+1;
            }
        }
        if(flag[d][e]!=0){
            System.out.println(flag[d][e]);
        }else {
            System.out.println("oop!");
        }
    }
}