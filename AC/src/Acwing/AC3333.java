package Acwing;

import java.util.Scanner;

public class AC3333 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j = 1; j <= t; j++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int res = 0;
            for(int i = 0; i < n/2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    res++;
                }
            }
            System.out.println("Case #"+j+": "+Math.abs(k-res));
        }
    }
}
