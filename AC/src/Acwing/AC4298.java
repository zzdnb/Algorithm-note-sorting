package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC4298 {
    static int N = 510, M = 100010, n1, n2, m, idx;
    static int[] h = new int[M], ne = new int[M], e = new int[M];
    //用来存储女生匹配的男生
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h, -1);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++){
            arr2[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(Math.abs(arr1[i] -arr2[j]) <= 1){
                    add(i+1,j+1);
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            //初始化女生都没有预定过，给自己增加信心
            Arrays.fill(st, false);
            if (find(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    //为男生添加女生联系方式
    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean find(int x) {
        //在列表里找找女生
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {//如果女孩还没有被预定
                st[j] = true;//预定成功
                if (match[j] == 0 || find(match[j])) {//看女孩是否有男朋友或者她的男朋友可以出轨
                    match[j] = x;//直接横刀夺爱
                    return true;
                }
            }
        }
        return false;
    }
}
