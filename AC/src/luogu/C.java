package luogu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C {
    static int N = 1000010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx = 0, n, m, sum;

    static int[][] arr;
    static boolean[] st1 = new boolean[N],st2 = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] s = read.readLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        Arrays.fill(h, -1);
        arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] ss = read.readLine().split(" ");
            int a = Integer.valueOf(ss[0]);
            int b = Integer.valueOf(ss[1]);

            arr[i][0] = a;
            arr[i][1] = b;

        }
        Arrays.sort(arr,((o1, o2) -> {
            //不用大于小于用等于就可以了
            if(o1[0]==o2[0]&&o1[1]!=o2[1]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        }));
        for (int i = 0; i < m; i++) {
            add(arr[i][0], arr[i][1]);
        }

        System.out.print(1+ " ");
        dfs(1);
        System.out.println();
        bfs();
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        st1[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st1[j]) {
                sum++;
                System.out.print(j);
                if(sum!=n){
                    System.out.print(" ");
                }
                dfs(j);
            }
        }
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        sum = 0;
        st2[1] = true;
        System.out.print("1 ");
        while(!queue.isEmpty()){
            if(sum==n){
                return;
            }
            int t = queue.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(!st2[j]){
                    st2[j] = true;
                    queue.offer(j);
                    sum++;
                    System.out.print(e[i]);
                    if(sum!=n){
                        System.out.print(" ");
                    }
                }
            }

        }
    }
}
