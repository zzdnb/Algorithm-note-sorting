//package Acwing;
//
//import java.util.Scanner;
//
//public class M {
//    static int[][] arr;
//    static boolean[][] st;
//    static int res;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- != 0) {
//            int m = sc.nextInt();
//            dfs(0, m);
//            System.out.println(res);
//            res = 0;
//        }
//    }
//
//    static void dfs(int u, int m) {
//        if (u == m) {
//            res++;
//            return;
//        }
//        for (int i = 0; i < m; i++) {
//            if (!st[u][i]) {
//                arr[u][i] = ;
//                st[u][i] = true;
//                dfs(u + 1, m);
//                st[u][i] = false;
//                arr[u][i] =
//            }
//        }
//    }
//}
