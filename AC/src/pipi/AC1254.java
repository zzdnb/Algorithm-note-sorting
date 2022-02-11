package pipi;


import java.util.Scanner;

public class AC1254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            long[][] arr = new long[5010][5010];
            arr[0][1] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    arr[i][j] = (arr[i - 1][j] + arr[i][j - 1])%1000000007;
                }
            }

            while (q-- != 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                System.out.println((arr[c-a+1][d-b+1]));
            }

        }
        sc.close();
    }
}
