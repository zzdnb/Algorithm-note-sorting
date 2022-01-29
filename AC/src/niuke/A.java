package niuke;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while ((n--) != 0) {
            int a = sc.nextInt();
            int x = sc.nextInt();
            int ans = 0;
            for (int bit = (1 << 30); bit!=0; bit >>= 1)
            {
                if ((x & bit)==0) {
                    continue;
                }
                int cnt = 0;
                for (int i = (bit >> 1); i!=0; i >>= 1) {
                    if ((i & a)==0) {
                        cnt++;
                    }
                }
                ans += (1 << cnt);
                if ((bit & a)!=0) {
                    break;
                }
            }
            if ((a | x) == a + x) {
                ans++;
            }
            System.out.println(ans - 1);
        }
    }
}
