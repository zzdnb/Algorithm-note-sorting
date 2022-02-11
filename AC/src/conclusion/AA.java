package conclusion;


import java.util.Scanner;

public class AA {

}

class Main {
    static int[][] s = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 },
            { 1, 1, 0 },
            { 1, 0, 1 },
            { 0, 1, 1 },
            { 1, 1, 1 }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            int ans = 0;
            for (int i = 0; i < 1 << 7; i++) {
                int sa = 0, sb = 0, sc = 0, count = 0;
                for (int j = 0; j < 7; j++) {

                    if ((i >> j & 1) == 1) {
                        sa += s[j][0];
                        sb += s[j][1];
                        sc += s[j][2];
                        count++;
                    }
                }
                System.out.println(count);
                if (sa <= a && sb <= b && sc <= c) {
                    ans = Math.max(ans, count);
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
