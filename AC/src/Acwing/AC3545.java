package Acwing;

import java.util.Scanner;
import java.util.TreeSet;

public class AC3545 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (Math.sqrt(m) == (int) Math.sqrt(m) && (int) Math.sqrt(m) <= n) {
                System.out.println(1);
                continue;
            }
            TreeSet<Integer> set = new TreeSet<>();
            int cnt = 0;

                for (int j = 1; j <= m / j; j++) {
                    if (m % j == 0) {
                        set.add(j);
                        set.add(m / j);
                    }
                }

            for(int x:set){
                if(x<=n&&m/x<=n){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
