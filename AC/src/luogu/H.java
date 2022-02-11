package luogu;


import java.util.Scanner;

public class H {
    static int N = (int) 1e5 + 10;
    static int[][] s = new int[11][N];
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            long t = a[i] % m;
            for (int j = 0; j < 11; j++) {
                s[j][(int) t]++;
                t = t * 10 % m;
            }
            System.out.println(t);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long t = a[i] % m;
            int len = String.valueOf(a[i]).length();
            res += s[len][(int) ((m - t) % m)];
            long r = t;
            while (len-- != 0) {
                r = r * 10 % m;
            } //求a[j]的余数，同上面的预处理求法一样
            if (r == (m - t) % m) {
                res--;
            }
        }
        System.out.println(res);
    }
}